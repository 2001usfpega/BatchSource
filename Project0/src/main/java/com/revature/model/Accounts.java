package com.revature.model;

public class Accounts {

	private Integer accountid;
	private String userid;
	private Double bal;

		
	public Accounts() {
		super();
		
	}

	public Accounts(Integer accountid, String userid, Double bal) {
		super();
		this.accountid = accountid;
		this.userid = userid;
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Accounts [accountid=" + accountid + ", userid=" + userid + ", bal=" + bal + "]";
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Double getBal() {
		return bal;
	}

	public void setBal(Double bal) {
		this.bal = bal;
	}

}
