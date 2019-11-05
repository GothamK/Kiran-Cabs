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

import com.kcabs.model.CarInsurances;


@Repository
@Transactional
public class CarInsurancesDao
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
    
    public static final class CIMapper implements RowMapper<CarInsurances>
    {
        public CarInsurances mapRow(ResultSet row, int i) throws SQLException {
        	CarInsurances u = new CarInsurances();
            u.setI_no(row.getString("i_no"));
            u.setI_agent(row.getString("i_agent"));
            u.setI_amount(row.getInt("i_amount"));
            u.setI_start (row.getString("i_start"));
            u.setI_end (row.getString("i_end"));
            return u;
        }
    }
    	
    

	private SqlParameterSource getSqlParameterByModel(CarInsurances a) {
		MapSqlParameterSource paramSource =new MapSqlParameterSource();
		if(a!= null)
		   {
			   paramSource.addValue("i_no", a.getI_no());
			   paramSource.addValue("i_agent", a.getI_agent());
			   paramSource.addValue("i_amount",a.getI_amount());
			   paramSource.addValue("i_start ",a.getI_start());
			   paramSource.addValue("i_end ",a.getI_end());
			   
		   }
		return paramSource;
	}
	public List<CarInsurances> listAll() 
    {
		  String sql = "SELECT * FROM car_insurances";
		  List<CarInsurances> list = nt.query(sql, getSqlParameterByModel(null), new CIMapper());
		  return list; 
    }
	
	public void add(String i_no,String i_agent,Integer i_amount,String i_start, String i_end)	
    {
        String query = "insert into car_insurances values (?,?,?,?,?)";
        jt.update(query, i_no, i_agent, i_amount, i_start,  i_end);
    }
    
    public List<CarInsurances> getInsurancesByI_no (String i_no) 
    {
        String query = "select * from car_insurances where i_no= "+i_no;
        List<CarInsurances> list = nt.query(query, getSqlParameterByModel(new CarInsurances(i_no)), new CIMapper());
        return list;
        
    }
    
    public void update(CarInsurances ci)
    {
    	String sql="update car_insurances set i_agent=:i_agent, i_amount=:i_amount, i_start=:i_start,i_end=:i_end where i_no=:i_no";
    	nt.update(sql,getSqlParameterByModel(ci));
    }
    
    public void delete(String i_no)
    {
    	String sql="delete from car_insurances where i_no=:i_no";
    	nt.update(sql,getSqlParameterByModel(new CarInsurances(i_no)));
    }
    

}
