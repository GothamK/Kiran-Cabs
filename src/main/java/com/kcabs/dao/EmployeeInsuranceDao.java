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


import com.kcabs.model.EmployeeInsurance;


@Repository
@Transactional
public class EmployeeInsuranceDao
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
    
    public static final class EIMapper implements RowMapper<EmployeeInsurance>
    {
        public EmployeeInsurance mapRow(ResultSet row, int i) throws SQLException {
        	EmployeeInsurance u = new EmployeeInsurance();
            u.setIns_no(row.getInt("ins_no"));
            u.setIns_provider(row.getString("ins_provider"));
            u.setBeneficiary(row.getString("beneficiary"));
            u.setRelation(row.getString("relation"));
            u.setIns_type(row.getString("ins_type"));
            u.setIns_amount(row.getInt("ins_amount"));
            u.setEmp_id(row.getInt("emp_id"));
            return u;
        }
    }
    	
    

	private SqlParameterSource getSqlParameterByModel(EmployeeInsurance a) {
		MapSqlParameterSource paramSource =new MapSqlParameterSource();
		if(a!= null)
		   {
			   paramSource.addValue("ins_no", a.getIns_no());
			   paramSource.addValue("ins_provider", a.getIns_provider());
			   paramSource.addValue("ins_amount",a.getIns_amount());
			   paramSource.addValue("ins_type ",a.getIns_type());
			   paramSource.addValue("emp_id ",a.getEmp_id());
			   paramSource.addValue("relation", a.getRelation());
			   paramSource.addValue("beneficiary",a.getBeneficiary());
			   
		   }
		return paramSource;
	}
	public List<EmployeeInsurance> listAll() 
    {
		  String sql = "SELECT * FROM e_insurance";
		  List<EmployeeInsurance> list = nt.query(sql, getSqlParameterByModel(null), new EIMapper());
		  return list; 
    }
	
	public void add(Integer ins_no,String ins_provider,String beneficiary, String relation,String ins_type,Integer ins_amount,Integer emp_id)	
    {
        String query = "insert into e_insurance values (?,?,?,?,?,?,?)";
        jt.update(query,  ins_no, ins_provider,beneficiary,  relation, ins_type, ins_amount, emp_id);
    }
    
    public List<EmployeeInsurance> getInsurancesByI_no (String ins_no) 
    {
        String query = "select * from e_insurance where i_no="+ins_no;
        List<EmployeeInsurance> list = nt.query(query, getSqlParameterByModel(null), new EIMapper());
        return list;  
    }
    
    public void update(EmployeeInsurance ei)
    {
    	String sql="update e_insurance set ins_provider=?,beneficiary=?,relation=?,ins_type=?,ins_amount=?, emp_id=? where ins_no=?";
    	jt.update(sql,ei.getIns_provider(),ei.getBeneficiary(),ei.getRelation(),ei.getIns_type(),ei.getIns_amount(),ei.getEmp_id(),ei.getIns_no());
    }
    
    public void delete(Integer ins_no)
    {
    	String sql="delete from e_insurance where ins_no=?";
    	jt.update(sql,ins_no);
    }
    

}
