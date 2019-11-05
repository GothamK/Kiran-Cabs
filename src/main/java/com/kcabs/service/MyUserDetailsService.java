package com.kcabs.service;
import com.kcabs.model.User;
import com.kcabs.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao UserDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User User = UserDao.findUserByUsername(username);
		if(User == null) {
			throw new UsernameNotFoundException("User 404");
		}
		return new UserPrinciple(User);
	}

}
