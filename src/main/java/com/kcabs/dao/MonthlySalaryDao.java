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

import com.kcabs.model.MonthlySalary;


@Repository
@Transactional
public class MonthlySalaryDao 
{
	
	@Autowired
    JdbcTemplate jt;
	
	@Autowired
	 NamedParameterJdbcTemplate nt;
	
	@Autowired
	PaymentsDao pd;
	
	@Autowired
	EmployeeDao e;

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
    
    public static final class MSMapper implements RowMapper<MonthlySalary>
    {
        public MonthlySalary mapRow(ResultSet row, int i) throws SQLException {
        	MonthlySalary u = new MonthlySalary();

            u.setSal_id(row.getInt("sal_id"));
            u.setCalculated_amount(row.getInt("calculated_amount"));
            u.setDate(row.getString("date"));
            u.setEmp_id(row.getInt("emp_id"));
            u.setPayment_id(row.getInt("payment_id"));
           
            return u;
        }
    }

	private SqlParameterSource getSqlParameterByModel(MonthlySalary a) {
		MapSqlParameterSource pS =new MapSqlParameterSource();
		if(a!= null)
		   {
			   pS.addValue("sal_id", a.getSal_id());
			   pS.addValue("calculated_amount",a.getCalculated_amount());
			   pS.addValue("date",a.getDate());
			   pS.addValue("emp_id",a.getEmp_id());	
			   pS.addValue("payment_id",a.getPayment_id());			   
		   }
		return pS;
	}
	
	public List<MonthlySalary> listAll() 
    {
		
		  String sql = "SELECT * FROM monthly_salary";
		  List<MonthlySalary> list = nt.query(sql, getSqlParameterByModel(null), new MSMapper());
		  return list; 
    }
	
	public void add( Integer calculated_amount, String date, Integer emp_id)	
    {
		String k = e.getEmpById(emp_id).getE_name();
		Integer payment_id = pd.add(-1*calculated_amount, date, "Salary", k);
        String query = "insert into monthly_salary(calculated_amount, date, emp_id,payment_id) values (?,?,?,?)";
        jt.update(query,calculated_amount, date, emp_id,payment_id);
    }
    
    public List<MonthlySalary> getSalaryByEmp_id (Integer emp_id) 
    {
        String query = "select * from monthly_salary where emp_id = " + emp_id;
        List<MonthlySalary> list = nt.query(query, getSqlParameterByModel(null), new MSMapper());
        return list;
        
    }
	
    public List<MonthlySalary> getSalariesByDate (String date) 
    {
        String query = "select * from monthly_salary where date = "+date ;
        List<MonthlySalary> list = nt.query(query, getSqlParameterByModel(null), new MSMapper());
        return list;
        
    }
	
    public void update(MonthlySalary m)
    {
    	String sql="update monthly_salary set calculated_amount=:calculated_amount, date=:date, emp_id=:emp_id,payment=:payment_id where sal_id=:sal_id";     
    	nt.update(sql,getSqlParameterByModel(m));
    }
    
    public void delete(Integer sal_id)
    {
    	String sql="DELETE FROM monthly_salary WHERE sal_id=:sal_id";
		nt.update(sql,getSqlParameterByModel(new MonthlySalary(sal_id)));
    }
	
	
	}