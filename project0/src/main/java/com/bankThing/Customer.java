package com.bankThing;

public class Customer {

	private long customerid;
	private String first1;
	private String last1;
	private String pw1;
	private long accountid;
	
	public Customer() {}

	public Customer(long customerid, String first1, String last1, String pw1, long accountid) {
		super();
		this.customerid = customerid;
		this.first1 = first1;
		this.last1 = last1;
		this.pw1 = pw1;
		this.accountid = accountid;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getFirst1() {
		return first1;
	}

	public void setFirst1(String first1) {
		this.first1 = first1;
	}

	public String getLast1() {
		return last1;
	}

	public void setLast1(String last1) {
		this.last1 = last1;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public long getAccountid() {
		return accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", first1=" + first1 + ", last1=" + last1 + ", pw1=" + pw1
				+ ", accountid=" + accountid + "]";
	};
	
	
}
