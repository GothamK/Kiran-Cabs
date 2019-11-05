package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CarDocs 
{
	 public String registration_no  ;
	 public String poll_check ;
	 public String poll_expiry  ;
	 public String i_no  ;
	 
	public CarDocs(String registration_no) {
		super();
		this.registration_no=registration_no;
	}

	public CarDocs() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	public String getPoll_check() {
		return poll_check;
	}

	public void setPoll_check(String poll_check) {
		this.poll_check = poll_check;
	}

	public String getPoll_expiry() {
		return poll_expiry;
	}

	public void setPoll_expiry(String poll_expiry) {
		this.poll_expiry = poll_expiry;
	}

	public String getI_no() {
		return i_no;
	}

	public void setI_no(String i_no) {
		this.i_no = i_no;
	}
	
	

	 
}
