package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class EmployeeInsurance 
{
	public Integer ins_no   ;
	public String  ins_provider  ;
	public String   beneficiary  ;
	public  String  relation  ;
	public  String  ins_type ;
	public Integer ins_amount   ;
	public  Integer emp_id   ;
	
	
	
	public EmployeeInsurance() {
		super();
	}
	public Integer getIns_no() {
		return ins_no;
	}
	public void setIns_no(Integer ins_no) {
		this.ins_no = ins_no;
	}
	public String getIns_provider() {
		return ins_provider;
	}
	public void setIns_provider(String ins_provider) {
		this.ins_provider = ins_provider;
	}
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getIns_type() {
		return ins_type;
	}
	public void setIns_type(String ins_type) {
		this.ins_type = ins_type;
	}
	public Integer getIns_amount() {
		return ins_amount;
	}
	public void setIns_amount(Integer ins_amount) {
		this.ins_amount = ins_amount;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	
}
