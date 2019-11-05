package com.kcabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kcabs.dao.UserDao;
import com.kcabs.model.User;

@Service
@Component
public class UserServiceImpl implements UserService
{

	UserDao userDao;
	
	
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userDao = userdao;
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
		
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		userDao.delete(username);
		
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUsername(username);
	}


	@Override
	public void update(String username, String password, String newp) {
		// TODO Auto-generated method stub
		userDao.update(username, password, newp);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		
	}
	

}
