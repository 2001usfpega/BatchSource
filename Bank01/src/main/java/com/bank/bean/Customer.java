package com.bank.bean;

import java.util.ArrayList;
import java.util.List;

public class Customer  {

	
	
	private int cust_id;
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private int account_number;
	private String password;
	
	public Customer() {}
	public Customer(int cust_id, String name, String email, String address, String phoneNumber, 
			String password) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	
		this.password = password;
	}
	public Customer(int int1, String name2, String pass) {
		// TODO Auto-generated constructor stub
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", account_number=" + account_number + ", password=" + password
				+ "]";
	}
	
	
	
	
	

}
