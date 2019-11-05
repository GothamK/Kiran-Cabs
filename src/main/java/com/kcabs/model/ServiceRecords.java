
package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class ServiceRecords 
{
	public Integer  ser_id  ;
	public String s_center  ;
	public Integer   s_cost ;
	public String s_type  ;
	public String reg_no  ;
	public String date;
	public Integer payment_id;
	
	
	
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public ServiceRecords(Integer ser_id) {
		super();
		this.ser_id = ser_id;
	}
	public ServiceRecords() {
		super();
	}
	public Integer getSer_id() {
		return ser_id;
	}
	public void setSer_id(Integer ser_id) {
		this.ser_id = ser_id;
	}
	public String getS_center() {
		return s_center;
	}
	public void setS_center(String s_center) {
		this.s_center = s_center;
	}
	public Integer getS_cost() {
		return s_cost;
	}
	public void setS_cost(Integer s_cost) {
		this.s_cost = s_cost;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public void setDate(String date) {
		// TODO Auto-generated method stub
		this.date=date;
	}
	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
	
}
