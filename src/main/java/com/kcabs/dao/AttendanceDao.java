package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kcabs.model.Attendance;


@Repository
@Transactional

public class AttendanceDao 
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
    
    public static final class AtMapper implements RowMapper<Attendance>
    {
        public Attendance mapRow(ResultSet row, int i) throws SQLException {
        	Attendance u = new Attendance();
            u.setEmp_id(row.getInt("emp_id"));
            u.setDate(row.getString("date"));
            u.setLeaves_taken(row.getInt("leaves_taken"));
            return u;
        }
    }
    	
    

	public SqlParameterSource getSqlParameterByModel(Attendance a) {
		MapSqlParameterSource paramSource =new MapSqlParameterSource();
		if(a!= null)
		   {
			   paramSource.addValue("date", a.getDate());
			   paramSource.addValue("emp_id", a.getEmp_id());
			   paramSource.addValue("leaves_taken",a.getLeaves_taken());
			   
		   }
		return paramSource;
	}
	
    public List<Attendance> listAll() 
    {
		  String sql = "SELECT * FROM attendance";
		  List<Attendance> list = nt.query(sql, getSqlParameterByModel(null), new AtMapper());
		  return list; 
    }
    
    public void add(String date,Integer emp_id,Integer leaves_taken)	
    {
        String query = "insert into attendance values (?,?,?)";
        jt.update(query, date, emp_id, leaves_taken);
    }
    
    public void delete(String date, Integer emp_id) 
    {
        String query = "delete from attendance where date=? and emp_id=?";
        jt.update(query, date, emp_id);
    }
    
    public List<Attendance> getAttendanceByEmp_id (int emp_id) 
    {
        String query = "select * from attendance where user_id="+emp_id;
        List<Attendance> list = nt.query(query, getSqlParameterByModel(new Attendance(emp_id)), new AtMapper());
        return list;
        
    }
    
   public void update(Attendance a)
   {
	   String query="update attendance set leaves_taken=:leaves_taken where emp_id=:emp_id and date=:date";
	   nt.update(query, getSqlParameterByModel(a));
   }
    

}
