package com.revature.bank;

public class Customer {
	
	int customerID;
	String firstName, lastName, customerUserName, customerPassword, customerAddress;
	Account customerAccount;
	
	public void Register(String fName, String lName, String cuName, String cAddress) {
		this.firstName= fName;
		this.lastName= lName;
		this.customerUserName = cuName;
		this.customerAddress = cAddress;
	}
	

}
