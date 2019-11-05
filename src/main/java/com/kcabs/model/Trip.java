package com.kcabs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Trip 
{
	@Id
	public Integer trip_id;
	public String customer_name;
	public String date;
	public Float dist;
	public Float duration;
	public Integer charges;
	public String registration_no;
	public Integer driv_no;
	public String pickup_point;
	public String drop_point;
	public Integer rating;
	public Integer payment_id;
	
	
	
	public String getPickup_point() {
		return pickup_point;
	}

	public void setPickup_point(String pickup_point) {
		this.pickup_point = pickup_point;
	}

	public String getDrop_point() {
		return drop_point;
	}

	public void setDrop_point(String drop_point) {
		this.drop_point = drop_point;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Trip(Integer trip_id) {
		super();
		this.trip_id = trip_id;
	}	
	
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Integer trip_id) {
		this.trip_id = trip_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getDist() {
		return dist;
	}

	public void setDist(Float dist) {
		this.dist = dist;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Integer getCharges() {
		return charges;
	}

	public void setCharges(Integer charges) {
		this.charges = charges;
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registraion_no) {
		this.registration_no = registraion_no;
	}

	public Integer getDriv_no() {
		return driv_no;
	}

	public void setDriv_no(Integer driv_no) {
		this.driv_no = driv_no;
	}


	

	
	
}


