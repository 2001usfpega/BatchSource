package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.account.Account;

public class CustomerInfo {

	private Integer customerid;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	private String email;
	
	private List<Accounts> accounts;

	public CustomerInfo() {
		super();
	}

	public CustomerInfo(Integer customerid, String username, String password, String fname, String lname,
			String address, String city, String state, String zipcode, String phone, String email) {
		super();
		this.customerid = customerid;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
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

	@Override
	public String toString() {
		return "CustomerInfo [customerid=" + customerid + ", username=" + username + ", password=" + password
				+ ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", phone=" + phone + ", email=" + email + "]";
	}
	
	public void setAccnt(List<Accounts> accounts) {
	
	}

	public List<Accounts> getAccounts() {
		
		return accounts;
	}

}
