package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kcabs.model.EmergencyContacts;

@Transactional
@Repository
public class EmergencyContactsDao
{
	
	@Autowired
	JdbcTemplate jt;
	
	@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jt = jdbcTemplate;
    }
	
	public void add(String contact_no,String contact_name,String relation,Integer e_id) {
        String query = "insert into emergency_contacts values (?,?,?,?)";
        jt.update(query, contact_no, contact_name, relation, e_id);
    }
	
	public List<EmergencyContacts> findByE_id(Integer e_id)
	{
        String query = "select * from orders where user_id="+e_id;
        return jt.query(query, new RowMapper<EmergencyContacts>() {
            public EmergencyContacts mapRow(ResultSet r, int i) throws SQLException {
            	EmergencyContacts o = new EmergencyContacts();
                o.setE_id(r.getInt("e_id"));
                o.setContact_no(r.getString("contact_no"));
                o.setContact_name(r.getString("contact_name"));
                o.setRelation(r.getString("relation"));
                return o;
            }
        });
    }
	//Multiple Deletion
	public void deleteContactsByE_id( Integer e_id) {
        String query = "delete from emergency_contacts where e_id=?";
        jt.update(query, e_id);
    }
	
	// Singular Deletion
	public void delete(String contact_no) {
        String query = "delete from emergency_contacts where contact_no=? ";
        jt.update(query, contact_no);
    }
	
	public void update(EmergencyContacts e)
	{
		String sql="update emergency_contacts set contact_name=?,relation=?,e_id=? where contact_no =? ";
		jt.update(sql,e.getContact_name(),e.getRelation(),e.getE_id(),e.getContact_no());
	}


}
