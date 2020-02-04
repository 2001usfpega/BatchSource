package com.revature.model;

import java.util.List;

public class Accounts {

	private Integer accountid;
	private String userid;
	private Double bal;
	private int customerid;

	private List<Accounts> accounts;
		
	public Accounts() {
		super();
		
	}

	public Accounts(Integer accountid, Integer customerid, Double bal) {
		super();
		this.accountid = accountid;
		this.customerid = customerid;
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Accounts [customerid=" + customerid + ", accountid=" + accountid + ", bal=" + bal + "]";
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Integer getCustomerid() {
		return customerid;
	}


	public Double getBal() {
		return bal;
	}
	

	public void setBal(Double bal) {
		this.bal = bal;
	}
	
public List<Accounts> getAccounts() {
		
		return accounts;
	}

}
