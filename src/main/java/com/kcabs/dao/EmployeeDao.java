package com.kcabs.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kcabs.model.Employee;  

@Transactional
@Repository
public class EmployeeDao 
{  
		@Autowired
		JdbcTemplate template;  

		public void setTemplate(JdbcTemplate template) {  
		    this.template = template;  
		}  
		public int add(Employee p){  
		    String sql="insert into employee(e_id,e_name,salary,address,phone_no,dl_no,designation,dob,start_date,no_of_ratings,avg_rating) values("+p.getE_id()+",'"+p.getE_name()+"',"+p.getSalary()+",'"+p.getAddress() +"',"+p.getPhone_no() +",'"+p.getDl_no() +"',"
		    		+ " '"+p.getDesignation() +"','"+p.getDob() +"','"+p.getStart_date() +"')";  
		    return template.update(sql);  
		}  
		public int update(Employee p){  
		    String sql="update employee set e_name=?, salary=?,designation=?,address=?,phone_no=? , dl_no =?, dob =?,no_of_ratings=?,avg_rating=? where e_id=?"
		    		+ "";  
		    return template.update(sql,p.getE_name(),p.getSalary(),p.getDesignation(),p.getAddress(),p.getPhone_no(),p.getDl_no(),p.getDob(),p.getNo_of_ratings(),p.getAvg_rating(),p.getE_id());  
		}  
		public int delete(int id){  
		    String sql="delete from employee where e_id=?";  
		    return template.update(sql);  
		}  
		public Employee getEmpById(Integer e_id){  
		    String sql="select * from employee where e_id=?";  
		    return template.queryForObject(sql, new Object[]{e_id},new BeanPropertyRowMapper<Employee>(Employee.class));  
		}  
		public List<Employee> getEmployees(){  
		    return template.query("select * from employee",new RowMapper<Employee>(){  
		        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
		            Employee e=new Employee(); 
		            e.setE_id(rs.getInt("e_id"));  
		            e.setE_name(rs.getString("e_name"));  
		            e.setDesignation(rs.getString("designation"));  
		            e.setAddress(rs.getString("address"));
		            e.setDob(rs.getString("dob"));
		            e.setSalary(rs.getInt("salary"));
		            e.setStart_date(rs.getString("start_date"));
		            e.setPhone_no(rs.getString("phone_no"));
		            e.setDl_no(rs.getString("dl_no"));
		            e.setAvg_rating(rs.getFloat("avg_rating"));
		            e.setNo_of_ratings(rs.getInt("no_of_ratings"));
		            
		            return e;  
		        }  
		    });  
		}  
} 


