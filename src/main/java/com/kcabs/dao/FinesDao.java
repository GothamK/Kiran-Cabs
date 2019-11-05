package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kcabs.model.Fines;


@Repository
@Transactional
public class FinesDao 
{
	
	@Autowired
    JdbcTemplate jt;
	
	@Autowired
	 NamedParameterJdbcTemplate nt;
	
	@Autowired
	PaymentsDao pd;

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
    
    public static final class FMapper implements RowMapper<Fines>
    {
        public Fines mapRow(ResultSet row, int i) throws SQLException {
        	Fines u = new Fines();

            u.setFine_id(row.getInt("fine_id"));
            u.setOffence(row.getString("offence"));
            u.setFined_amount(row.getInt("fined_amount"));
            u.setConsequences(row.getString("consequences"));
            u.setRegn_no(row.getString("regn_no"));
            u.setDate(row.getString("date"));
            u.setDriv_id(row.getInt("driv_id"));
            u.setPayment_id(row.getInt("payment_id"));
           
            return u;
        }
    }

	private SqlParameterSource getSqlParameterByModel(Fines a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("fine_id", a.getFine_id());
			   pS.addValue("offence",a.getOffence());
			   pS.addValue("fined_amount",a.getFined_amount());
			   pS.addValue("consequences",a.getConsequences());
			   pS.addValue("regn_no",a.getRegn_no());
			   pS.addValue("date", a.getDate());
			   pS.addValue("driv_id", a.getDriv_id());	
			   pS.addValue("payment_id", a.getPayment_id());
			   
		   }
		return pS;
	}
	
	public List<Fines> listAll() 
    {
		  String sql = "SELECT * FROM fines";
		  List<Fines> list = nt.query(sql, getSqlParameterByModel(null), new FMapper());
		  return list; 
    }
	
	public void add( String offence, Integer fined_amount, String consequences, String regn_no, String date, Integer driv_id)	
    {
		//String k = e.getEmpById(emp_id).getE_name();
		Integer payment_id = pd.add(-1*fined_amount, date, "Fine", "Police");
        String query = "insert into fines(offence,fined_amount,consequences, regn_no, date, driv_id, payment_id) values (?,?,?,?,?,?,?)";
        jt.update(query, offence,fined_amount,consequences, regn_no, date, driv_id, payment_id);
    }
    
    public List<Fines> getFinesByFineId (Integer fine_id) 
    {
        String query = "select * from fines where fine_id_no="+fine_id;
        List<Fines> list = nt.query(query, getSqlParameterByModel(null), new FMapper());
        return list;
        
    }
	
    public List<Fines> getFinesByDrivId (Integer driv_id) 
    {
        String query = "select * from fines where driv_id="+driv_id;
        List<Fines> list = nt.query(query, getSqlParameterByModel(null), new FMapper());
        return list;
        
    }
    
    public void update(Fines f)
    {
    	String sql="update cars set offence=:offence, fined_amount=:fined_amount, consequences=:consequences,regn_no=:regn_no, date=:date,driv_id=:driv_id,payment_id=:payment_id where fine_id=:fine_id";     
    	nt.update(sql,getSqlParameterByModel(f));
    }
    
    public void delete(Integer fine_id)
    {
    	String sql="DELETE FROM fines WHERE fine_id=:fine_id";
		nt.update(sql,getSqlParameterByModel(new Fines(fine_id)));
    }
	
	
	
	
	}