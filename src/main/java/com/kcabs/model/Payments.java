package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Payments 
{
	  public Integer payment_id   ;
	  public Integer amount   ;
	  public String date  ;
	  public String type  ;
	  public String receiver  ;
	  
	  
	  
	public Payments(Integer payment_id) {
		super();
		this.payment_id = payment_id;
	}
	public Payments() {
		super();
	}
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
