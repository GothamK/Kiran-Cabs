package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import org.springframework.stereotype.Repository;

import com.kcabs.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;




@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
      
      @Autowired
      JdbcTemplate jt;
      
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}
	 
	
	@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
    {
        this.jt = jdbcTemplate;
    }

	 public List<User> list() {
		  String sql = "SELECT * FROM users";
		  
		  List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
		 }
	 
   private SqlParameterSource getSqlParameterByModel(User user)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(user!= null)
	   {
		   paramSource.addValue("username", user.getUsername());
		   paramSource.addValue("e_id", user.getE_id());
		   paramSource.addValue("password",user.getPassword());
		   paramSource.addValue("role",user.getRole());
	   }
	   
	   return paramSource;   
   }
  
   
   
   public static final class UserMapper implements RowMapper<User>
   {
	   public User mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   User user=new User();
		   user.setUsername(rs.getString("username"));
		   user.setE_id(rs.getInt("e_id"));
		   user.setPassword(rs.getString("password"));
		   user.setRole(rs.getString("role"));
		   return user;
		   
	   }
   }

   
	@Override
	public void add(User user) {
		// 
		String sql="INSERT INTO users values (:username,:e_id,SHA1(:password),:role)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(user));
	}	

	@Override
	public void delete(String username) {
		// 
		String sql="DELETE FROM users WHERE username=:username";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new User(username)));
		
	}
	

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM users WHERE username=:username";
		User u =namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(username)),new UserMapper() );
		return u;
		
	}

	@Override
	public void update(String newp, String username, String password) 
	{
		String sql="UPDATE users set password = SHA1(?) where username = ? and password= SHA1(?) ";
		jt.update(sql,new Object[] {newp,username, password});
	}



	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


	

}
  