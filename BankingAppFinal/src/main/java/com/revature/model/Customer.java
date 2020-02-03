package com.revature.model;

import java.util.List;

public class Customer {
	
	/**
	 * 
	 */
	private Integer customerId;
	
	/**
	 * The username of the user
	 */
	String username;
	
	/**
	 * The password of the user
	 */
	String password;
	
	/**
	 * 
	 */
	String fName;
	
	/**
	 * 
	 */
	String lName;

	/**
	 * 
	 */
	Address address;
	
	/**
	 * 
	 */
	String phone;
	
	/**
	 * 
	 */
	String email;
	
	/**
	 * 
	 */
	private List<Account> accounts;
	
	public List<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}



	public Customer() {
		
	}
	
	

	public Customer(Integer customerId, String username, String password, String fName, String lName, Address address,
			String phone, String email) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", fName="
				+ fName + ", lName=" + lName + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
