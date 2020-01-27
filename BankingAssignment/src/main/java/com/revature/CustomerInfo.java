package com.revature;

import java.util.ArrayList;

public class CustomerInfo {
	
	
	private int CustomerID;
	private String CUserName;
	private String CPassword;
	private ArrayList<Account> myAccounts =new ArrayList<Account>();

	
	public int getCustomerID() {
		return CustomerID;
	}


	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}


	public String getCUserName() {
		return CUserName;
	}


	public void setCUserName(String cUserName) {
		CUserName = cUserName;
	}


	public String getCPassword() {
		return CPassword;
	}


	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}


	public CustomerInfo(int customerID, String CUserName, String CPassword) {
		
		this.CustomerID = customerID;
		this.CUserName = CUserName;
		this.CPassword = CPassword;
		
	
		
	}
	
	public void createNewAccount() {
		Account a=new Account();
		myAccounts.add(a);
	}
	
	
	@Override
	public String toString() {
		return "CustomerInfo [CustomerID=" + CustomerID + ", CustomerName=" + CUserName + ", CustomerPassword="
				+ CPassword + "]";
	}
	

}
	
