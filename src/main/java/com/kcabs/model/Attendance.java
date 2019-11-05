package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Attendance 
{
	//primary key (date, emp_id)
	public String  date ;
	public  Integer emp_id   ;
	public  Integer  leaves_taken ;
	
	public Attendance() {
		super();
	}

	

	public Attendance(Integer emp_id) {
		super();
		this.emp_id = emp_id;
	}



	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public Integer getLeaves_taken() {
		return leaves_taken;
	}
	public void setLeaves_taken(Integer leaves_taken) {
		this.leaves_taken = leaves_taken;
	}

}
