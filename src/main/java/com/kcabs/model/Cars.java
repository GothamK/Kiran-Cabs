package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Cars 
{
	  public String registration_no  ;
	  public String company  ;
	  public Integer dist_travelled  ;
	  public Integer selling_price ;
	  public String model  ;
	  public String active ;
	  public Integer cost_price ; 
	  public String colour ; 
	  public Integer capacity ; 
	  public String purchase_date;  
	  public String fuel ;
	  
	  
	public Cars() {
		super();
	}
	public Cars(String registration_no) {
		// TODO Auto-generated constructor stub
		this.registration_no=registration_no;
	}
	public String getRegistration_no() {
		return registration_no;
	}
	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getDist_travelled() {
		return dist_travelled;
	}
	public void setDist_travelled(Integer dist_travelled) {
		this.dist_travelled = dist_travelled;
	}
	public Integer getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(Integer selling_price) {
		this.selling_price = selling_price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getCost_price() {
		return cost_price;
	}
	public void setCost_price(Integer cost_price) {
		this.cost_price = cost_price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	} 	
	  
	  

}
