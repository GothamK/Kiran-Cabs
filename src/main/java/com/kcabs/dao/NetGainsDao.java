package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kcabs.model.EmployeeInsurance;
import com.kcabs.model.NetGains;



@Transactional
@Repository
public class NetGainsDao 
{
	@Autowired
    JdbcTemplate jt;
	
	@Autowired
	NamedParameterJdbcTemplate nt;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jt = jdbcTemplate;
    }
    
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.nt= namedParameterJdbcTemplate ;
}
    private static final class GainMapper implements RowMapper<NetGains>
    {
	    public NetGains mapRow(ResultSet row, int i) throws SQLException {
	        NetGains ng = new NetGains();
	        ng.setDate(row.getString("date"));
	        ng.setProfit(row.getInt("profit"));
	        
	        return ng;
	    }
    }
    
	   private SqlParameterSource getSqlParameterByModel(NetGains ng) {
			MapSqlParameterSource paramSource =new MapSqlParameterSource();
			   if(ng!= null)
			   {
				   paramSource.addValue("ng_id", ng.getProfit());
				   paramSource.addValue("date", ng.getDate());
				 
			   }
			return paramSource;
		}
		public NetGains findProfitByDate(String date) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM net_gains WHERE date=?";
		return	nt.queryForObject(sql, getSqlParameterByModel(new NetGains(date)),new GainMapper() );
			
		}
		
	    public void update(NetGains n)
	    {
	    	String sql="update net_gains set profit=:profit where date=:date";     
	    	nt.update(sql,getSqlParameterByModel(n));
	    }
	    
	    public void delete(String date)
	    {
	    	String sql="DELETE FROM net_gains WHERE date=:date";
			nt.update(sql,getSqlParameterByModel(new NetGains(date)));
	    }
	    
	    public void add(NetGains n)
	    {
	    	String sql="Insert into net_gains values(:date,:profit)";
	    	nt.update(sql,getSqlParameterByModel(n));
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
