package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class InterStatePermissions 
{

	public Integer p_no  ;
	public String place1  ;
	public String  place2 ;
	public String  s_date ;
	public Integer   p_tax ;
	public String  e_date  ;
	public String  reg_no  ;
	
	
	
	public InterStatePermissions(Integer p_no) {
		super();
		this.p_no = p_no;
	}
	public InterStatePermissions() {
		super();
	}
	public Integer getP_no() {
		return p_no;
	}
	public void setP_no(Integer p_no) {
		this.p_no = p_no;
	}
	public String getPlace1() {
		return place1;
	}
	public void setPlace1(String place1) {
		this.place1 = place1;
	}
	public String getPlace2() {
		return place2;
	}
	public void setPlace2(String place2) {
		this.place2 = place2;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public Integer getP_tax() {
		return p_tax;
	}
	public void setP_tax(Integer p_tax) {
		this.p_tax = p_tax;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	
	
}
