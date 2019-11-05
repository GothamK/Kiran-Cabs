package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class CarInsurances 
{

	@Id
	public String i_no  ;
	public String i_agent  ;
	public  Integer i_amount   ;
	public  String i_start ;
	public  String i_end  ;
	
	
	
	public CarInsurances() {
		super();
	}
	public CarInsurances(String i_no) {
		// TODO Auto-generated constructor stub
		this.i_no=i_no;
	}
	public String getI_no() {
		return i_no;
	}
	public void setI_no(String i_no) {
		this.i_no = i_no;
	}
	public String getI_agent() {
		return i_agent;
	}
	public void setI_agent(String i_agent) {
		this.i_agent = i_agent;
	}
	public Integer getI_amount() {
		return i_amount;
	}
	public void setI_amount(Integer i) {
		this.i_amount = i;
	}
	public String getI_start() {
		return i_start;
	}
	public void setI_start(String i_start) {
		this.i_start = i_start;
	}
	public String getI_end() {
		return i_end;
	}
	public void setI_end(String i_end) {
		this.i_end = i_end;
	}
	
	
	
}
