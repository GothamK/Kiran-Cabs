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

import com.kcabs.model.ServiceRecords;


@Repository
@Transactional
public class ServiceRecordsDao 
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
    
    public static final class SRMapper implements RowMapper<ServiceRecords>
    {
        public ServiceRecords mapRow(ResultSet row, int i) throws SQLException {
        	ServiceRecords u = new ServiceRecords();

            u.setSer_id(row.getInt("ser_id"));
            u.setS_center(row.getString("s_center"));
            u.setS_cost(row.getInt("s_cost"));
            u.setS_type(row.getString("s_type"));
            u.setReg_no(row.getString("reg_no"));
            u.setDate(row.getString("date"));
            u.setPayment_id(row.getInt("payment_id"));
           
            return u;
        }
    }

	private SqlParameterSource getSqlParameterByModel(ServiceRecords a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("ser_id", a.getSer_id());
			   pS.addValue("s_center",a.getS_center());
			   pS.addValue("s_cost",a.getS_cost());
			   pS.addValue("s_type",a.getS_type());	
			   pS.addValue("reg_no",a.getReg_no());
			   pS.addValue("date", a.getDate());
			   pS.addValue("payment_id",a.getPayment_id());
			   
			   
		   }
		return pS;
	}
	
	public List<ServiceRecords> listAll() 
    {
		  String sql = "SELECT * FROM service_records";
		  List<ServiceRecords> list = nt.query(sql, getSqlParameterByModel(null), new SRMapper());
		  return list; 
    }
	
	public void add( String s_center, Integer s_cost, String s_type, String reg_no,String date)	
    {
		Integer payment_id = pd.add(-1*s_cost, date, "Car Service", s_center);
        String query = "insert into service_records(s_center,s_cost,s_type,reg_no,date,payment_id) values (?,?,?,?,?,?)";
        jt.update(query, s_center,  s_cost,  s_type,  reg_no, date, payment_id);
    }
    
    public List<ServiceRecords> getrecordsByCar (String reg_no) 
    {
        String query = "select * from service_records where reg_no = " + reg_no;
        List<ServiceRecords> list = nt.query(query, getSqlParameterByModel(null), new SRMapper());
        return list;
        
    }
    
	   public void update(ServiceRecords p)
	    {
	    	String sql="update service_records set s_center=:s_center, s_cost=:s_cost, s_type=:s_type, reg_no=:reg_no, date=:date where ser_id=:ser_id";     
	    	nt.update(sql,getSqlParameterByModel(p));
	    }
	    
	    public void delete(Integer ser_id)
	    {
	    	String sql="DELETE FROM service_records WHERE ser_id=:ser_id";
			nt.update(sql,getSqlParameterByModel(new ServiceRecords(ser_id)));
	    }
	
	
	}