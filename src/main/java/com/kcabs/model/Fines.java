package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Fines 
{

	public Integer fine_id   ;
	public String  offence ;
	public Integer fined_amount   ;
	public String consequences  ;
	public String  regn_no  ;
	public String  date  ;
	public Integer driv_id   ;
	public Integer payment_id;
	
	
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public Fines() {
		super();
	}
	public Integer getFine_id() {
		return fine_id;
	}
	public void setFine_id(Integer fine_id) {
		this.fine_id = fine_id;
	}
	public String getOffence() {
		return offence;
	}
	public void setOffence(String offence) {
		this.offence = offence;
	}
	public Integer getFined_amount() {
		return fined_amount;
	}
	public void setFined_amount(Integer fined_amount) {
		this.fined_amount = fined_amount;
	}
	public String getConsequences() {
		return consequences;
	}
	public void setConsequences(String consequences) {
		this.consequences = consequences;
	}
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getDriv_id() {
		return driv_id;
	}
	public void setDriv_id(Integer driv_id) {
		this.driv_id = driv_id;
	}
	public Fines(Integer fine_id) {
		super();
		this.fine_id = fine_id;
	}
	
	
	
}
