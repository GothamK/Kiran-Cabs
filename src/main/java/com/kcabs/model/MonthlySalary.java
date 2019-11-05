package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class MonthlySalary 
{
	 public Integer sal_id ;
	 public Integer calculated_amount  ;
	 public String date;
	 public Integer emp_id  ;
	 public Integer payment_id;
	 
	 public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	 
	 
	 
	public MonthlySalary(Integer sal_id) {
		super();
		this.sal_id = sal_id;
	}
	public MonthlySalary() {
		super();
	}
	public Integer getSal_id() {
		return sal_id;
	}
	public void setSal_id(Integer sal_id) {
		this.sal_id = sal_id;
	}
	public Integer getCalculated_amount() {
		return calculated_amount;
	}
	public void setCalculated_amount(Integer calculated_amount) {
		this.calculated_amount = calculated_amount;
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
}
