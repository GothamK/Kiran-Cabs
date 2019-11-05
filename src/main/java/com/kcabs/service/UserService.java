package com.kcabs.service;

import java.util.List;
import com.kcabs.model.User;


public interface UserService {
	public List<User> list();
	
	public void add(User user);
	
	public void delete(String username);

	public User findUserByUsername(String username);

	public void update(User user);
	
	public void update(String username, String password, String newp) ;

}
