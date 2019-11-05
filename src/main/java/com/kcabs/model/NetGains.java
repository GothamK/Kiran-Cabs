package com.kcabs.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class NetGains 
{
	public String date;
	public Integer profit;
	
	
	public NetGains() {
		super();
	}
	public NetGains(String date) {
		// TODO Auto-generated constructor stub
		this.date=date;
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getProfit() {
		return profit;
	}
	public void setProfit(Integer profit) {
		this.profit = profit;
	}
	
	
}
