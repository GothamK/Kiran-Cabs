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

import com.kcabs.model.InterStatePermissions;


@Repository
@Transactional
public class InterStatePermissionsDao 
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
	
    public static final class ISPMapper implements RowMapper<InterStatePermissions>
    {
        public InterStatePermissions mapRow(ResultSet row, int i) throws SQLException {
        	InterStatePermissions u = new InterStatePermissions();

            u.setP_no(row.getInt("p_no"));
            u.setPlace1(row.getString("place1"));
            u.setPlace2(row.getString("place2"));
            u.setS_date(row.getString("s_date"));
            u.setP_tax(row.getInt("p_tax"));
            u.setE_date(row.getString("e_date"));
            u.setReg_no(row.getString("reg_no"));
           
            return u;
        }
    }

	private SqlParameterSource getSqlParameterByModel(InterStatePermissions a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("p_no", a.getP_no());
			   pS.addValue("place1",a.getPlace1());
			   pS.addValue("place1",a.getPlace2());
			   pS.addValue("s_date",a.getS_date());
			   pS.addValue("p_tax",a.getP_tax());
			   pS.addValue("e_date", a.getE_date());
			   pS.addValue("reg_no", a.getReg_no());			   
			   
		   }
		return pS;
	}
	
	public List<InterStatePermissions> listAll() 
    {
		  String sql = "SELECT * FROM interstate_permissions";
		  List<InterStatePermissions> list = nt.query(sql, getSqlParameterByModel(null), new ISPMapper());
		  return list; 
    }
	
	public void add(Integer p_no, String place1, String place2, String s_date, Integer p_tax, String e_date, String reg_no)	
    {
        String query = "insert into interstate_permissions values (?,?,?,?,?,?,?)";
        jt.update(query, p_no , place1,  place2,  s_date,  p_tax, e_date,  reg_no);
    }
    
    public List<InterStatePermissions> getActivePermissionsByDate (String date) 
    {
        String query = "select * from interstate_permissions where e_date >= " + date;
        List<InterStatePermissions> list = nt.query(query, getSqlParameterByModel(null), new ISPMapper());
        return list;
        
    }
	
    public List<InterStatePermissions> getPermissionsBetweenPlaces (String p1, String p2, String date) 
    {
        String query = "select * from interstate_permissions where e_date >= "+date +" and place1 = "+p1+" or "+p2+" and p2 = "+p1+ " or " +p2;
        List<InterStatePermissions> list = nt.query(query, getSqlParameterByModel(null), new ISPMapper());
        return list;
        
    }
    
    public void update(InterStatePermissions i)
    {
    	String sql="update interstate_permissions set place1=:place1, place2=:place2, s_date=:s_date,p_tax=:p_tax, e_date=:e_date,reg_no=:reg_no where p_no=:p_no";     
    	nt.update(sql,getSqlParameterByModel(i));
    }
    
    public void delete(Integer p_no)
    {
    	String sql="DELETE FROM interstate_permissions WHERE p_no=:p_no";
		nt.update(sql,getSqlParameterByModel(new InterStatePermissions(p_no)));
    }
	
    
	
	
	
	}