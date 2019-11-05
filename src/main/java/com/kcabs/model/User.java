package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class User {

	private String username;
	private Integer e_id;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getE_id() {
		return e_id;
	}

	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
}
