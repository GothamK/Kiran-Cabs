
package com.kcabs.dao;

import java.util.List;
import com.kcabs.model.User;

public interface UserDao {
	public List<User> list();
	
	public void add(User user); 
	
	public void delete(String username);
	
	public User findUserByUsername(String username);
	
	public void update(String username, String password, String newp) ;

	public void update(User user);
	
	
	

}
