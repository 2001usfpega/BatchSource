package com.revature.user;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8744566485330734799L;
	
	protected ArrayList<Customer> customers; 

	public Employee(String username, String password, String fName, String lName,
			Address address, String phone, String email, ArrayList<Customer> cust) {
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		customers = cust;
	}
	
	public Employee() {
		
	}
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
}
