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

import com.kcabs.model.Cars;



@Repository
@Transactional
public class CarsDao 
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
    
    public static final class CarMapper implements RowMapper<Cars>
    {
        public Cars mapRow(ResultSet row, int i) throws SQLException {
        	Cars u = new Cars();
            u.setRegistration_no(row.getString("registration_no"));
            u.setCompany(row.getString("company"));
            u.setDist_travelled(row.getInt("dist_travelled"));
            u.setSelling_price(row.getInt("selling_price "));
            u.setModel(row.getString("model"));
            u.setActive(row.getString("active"));
            u.setCost_price(row.getInt("cost_price"));
            u.setColour(row.getString("colour"));
            u.setCapacity(row.getInt("capacity"));
            u.setPurchase_date(row.getString("purchase_date"));
            u.setFuel(row.getString("fuel"));
            return u;
        }
    }

	public SqlParameterSource getSqlParameterByModel(Cars a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("registration_no", a.getRegistration_no());
			   pS.addValue("company",a.getCompany());
			   pS.addValue("dist_travelled",a.getDist_travelled());
			   pS.addValue("selling_price",a.getSelling_price());
			   pS.addValue("model",a.getModel());
			   pS.addValue("active", a.getActive());
			   pS.addValue("cost_price", a.getCost_price());
			   pS.addValue("colour", a.getColour());
			   pS.addValue("capacity",a.getCapacity());
			   pS.addValue("purchase_date", a.getPurchase_date());
			   pS.addValue("fuel", a.getFuel());			   
			   
		   }
		return pS;
	}
	
	public List<Cars> listAll() 
    {
		  String sql = "SELECT * FROM cars";
		  List<Cars> list = nt.query(sql, getSqlParameterByModel(null), new CarMapper());
		  return list; 
    }
	
	public void add(String registration_no,String company,Integer dist_travelled, Integer selling_price, String model, String active, Integer cost_price, String colour, Integer capacity, String purchase_date, String fuel)	
    {
        String query = "insert into cars values (?,?,?,?,?,?,?,?,?,?,?)";
        jt.update(query,registration_no,company, dist_travelled,  selling_price, model, active, cost_price,  colour,  capacity,  purchase_date,  fuel);
    }
    
    public List<Cars> getCarByRegNo (String registration_no) 
    {
        String query = "select * from cars where registration_no="+registration_no;
        List<Cars> list = nt.query(query, getSqlParameterByModel(null), new CarMapper());
        return list;
     	  
    }
	
    public List<Cars> getActiveCars (String active) 
    {
        String query = "select * from cars where active="+active;
        List<Cars> list = nt.query(query, getSqlParameterByModel(null), new CarMapper());
        return list;
        
    }
    
    public void update(Cars ci)
    {
    	String sql="update cars set company=:company, dist_travelled=:dist_travelled, selling_price=:selling_price,model=:model, active=:active,cost_price=:cost_price,colour=:colour,capacity=:capacity,purchase_date=:purchase_date,fuel=:fuel where registration_no=:registration_no";     
    	nt.update(sql,getSqlParameterByModel(ci));
    }
    
    public void delete(String registration_no)
    {
    	String sql="DELETE FROM cars WHERE registration_no=:registration_no";
		nt.update(sql,getSqlParameterByModel(new Cars(registration_no)));
    }
	
	
	
	}