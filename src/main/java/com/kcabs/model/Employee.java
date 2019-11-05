package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Employee
{
	  public Integer e_id ;
	  public String e_name  ;
	  public Integer salary  ;
	  public Integer no_of_ratings   ;
	  public Float avg_rating  ;
	  public String address  ;
	  public String phone_no  ;
	  public String dl_no  ;
	  public String designation  ;
	  public String dob  ;
	  public String start_date  ;
	  
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getNo_of_ratings() {
		return no_of_ratings;
	}
	public void setNo_of_ratings(Integer no_of_ratings) {
		this.no_of_ratings = no_of_ratings;
	}
	public Float getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(Float avg_rating) {
		this.avg_rating = avg_rating;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getDl_no() {
		return dl_no;
	}
	public void setDl_no(String dl_no) {
		this.dl_no = dl_no;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	  
	  
	  
}
