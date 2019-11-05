package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kcabs.model.Payments;


@Repository
@Transactional
public class PaymentsDao 
{
	
	@Autowired
    JdbcTemplate jt;
	
	Payments p;
	
	@Autowired
	 NamedParameterJdbcTemplate nt;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
    {
        this.jt = jdbcTemplate;
    }
    
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.nt= namedParameterJdbcTemplate ;
}
    
    public static final class PMapper implements RowMapper<Payments>
    {
        public Payments mapRow(ResultSet row, int i) throws SQLException {
        	Payments u = new Payments();

            u.setPayment_id(row.getInt("payment_id"));
            u.setAmount(row.getInt("amount"));
            u.setDate(row.getString("date"));
            u.setType(row.getString("type"));
            u.setReceiver(row.getString("receiver"));
           
            return u;
        }
    }

	private SqlParameterSource getSqlParameterByModel(Payments a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("payment_id", a.getPayment_id());
			   pS.addValue("amount",a.getAmount());
			   pS.addValue("date",a.getDate());
			   pS.addValue("type",a.getType());	
			   pS.addValue("receiver",a.getReceiver());
			   
		   }
		return pS;
	}
	
	public List<Payments> listAll() 
    {
		  String sql = "SELECT * FROM payments";
		  List<Payments> list = nt.query(sql, getSqlParameterByModel(null), new PMapper());
		  return list; 
    }
	
	public Integer add( Integer amount, String date, String type, String receiver)	
    {
        String query = "insert into payments(amount, date, type,receiver) values (?,?,?,?)";
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jt.update(connection->
        {
        	PreparedStatement ps = connection.
        			prepareStatement(query,new String[] {"payment_id"});
        	ps.setInt(1, amount);
        	ps.setString(2, date);
        	ps.setString(3, type);
        	ps.setString(4, receiver);
        	return ps;
        }, keyHolder);
       
        Integer payment_id = keyHolder.getKey().intValue();
        
        return payment_id;
    }
    
	   public void update(Payments p)
	    {
	    	String sql="update payments set amount=:amount, date=:date, type=:type, receiver=:receiver where payment_id=:payment_id";     
	    	nt.update(sql,getSqlParameterByModel(p));
	    }
	    
	    public void delete(Integer payment_id)
	    {
	    	String sql="DELETE FROM payments WHERE payment_id=:payment_id";
			nt.update(sql,getSqlParameterByModel(new Payments(payment_id)));
	    }
	    
	    public Payments getPaymentByPID(Integer payment_id)
	    {
	    	String sql = "Select * from payments where payment_id =" +payment_id;
	    	Payments p1 = jt.queryForObject(sql, Payments.class);
	    	return p1;
	    }
		
    
    
	
	
	
	}