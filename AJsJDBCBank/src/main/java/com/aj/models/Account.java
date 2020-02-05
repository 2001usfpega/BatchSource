package com.aj.models;

public class Account {
	private String acc_id = null;
	private String type, cust_id;
	private float balance;


	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", type=" + type + ", balance=" + balance + ", cust_id=" + cust_id
				+ "]";
	}

}
