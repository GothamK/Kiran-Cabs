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

import com.kcabs.model.CarDocs;



@Repository
@Transactional
public class CarDocsDao 
{
	
	@Autowired
    JdbcTemplate jt;
	
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
    
    public static final class CDMapper implements RowMapper<CarDocs>
    {
        public CarDocs mapRow(ResultSet row, int i) throws SQLException {
        	CarDocs u = new CarDocs();
            u.setRegistration_no(row.getString("registration_no"));
            u.setPoll_check(row.getString("poll_check"));
            u.setPoll_expiry(row.getString("poll_expiry"));
            u.setI_no (row.getString("i_no "));
            return u;
        }
    }
    	
    

	private SqlParameterSource getSqlParameterByModel(CarDocs a) {
		MapSqlParameterSource paramSource =new MapSqlParameterSource();
		if(a!= null)
		   {
			   paramSource.addValue("registration_no", a.getRegistration_no());
			   paramSource.addValue("poll_check", a.getPoll_check());
			   paramSource.addValue("poll_expiry",a.getPoll_expiry());
			   paramSource.addValue("i_no",a.getI_no ());
			   
		   }
		return paramSource;
	}
	public List<CarDocs> listAll() 
    {
		  String sql = "SELECT * FROM car_docs";
		  List<CarDocs> list = nt.query(sql, getSqlParameterByModel(null), new CDMapper());
		  return list; 
    }
	
	public void add(String registration_no,String poll_check,String poll_expiry, String i_no)	
    {
        String query = "insert into car_docs values (?,?,?,?)";
        jt.update(query, registration_no, poll_check, poll_expiry, i_no);
    }
    
    public List<CarDocs> getDocsByRegNo (String registration_no) 
    {
        String query = "select * from car_docs where registration_no="+registration_no;
        List<CarDocs> list = nt.query(query, getSqlParameterByModel(new CarDocs(registration_no)), new CDMapper());
        return list;
        
    }
    public void update(CarDocs cd)
    {
    	String sql="update car_docs set poll_check=:poll_check, poll_expiry=:poll_expiry, i_no=:i_no where registration_no=:registration_no";
    	nt.update(sql,getSqlParameterByModel(cd));
    }
    
    public void delete(String registration_no)
    {
    	String sql="delete from car_docs where registration_no=:registration_no";
    	nt.update(sql,getSqlParameterByModel(new CarDocs(registration_no)));
    }

}
