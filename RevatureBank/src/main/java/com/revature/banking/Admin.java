package com.revature.banking;

public class Admin {
	int adminid =1;
	String password = "password";
	int customerid;
	String uname;
	String pword;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public Admin(int customerid, String uname, String pword) {
		super();
		this.customerid = customerid;
		this.uname = uname;
		this.pword = pword;
	}
	public Admin() {
		
	}

}
