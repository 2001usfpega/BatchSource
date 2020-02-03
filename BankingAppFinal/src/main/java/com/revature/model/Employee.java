package com.revature.model;

import java.util.List;

public class Employee {
	
	/**
	 * 
	 */
	private Integer employeeID;
	
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
	boolean adminFlag;
	
	/**
	 * 
	 */
	private List<Customer> customers;
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Employee() {
		
	}
	
	public Employee(Integer employeeID, String username, String password, String fName, String lName, Address address, String phone,
			String email, boolean adminFlag) {
		super();
		this.employeeID = employeeID;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.adminFlag = adminFlag;
	}

	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", username=" + username + ", password=" + password + ", fName="
				+ fName + ", lName=" + lName + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", adminFlag=" + adminFlag + "]";
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
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

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}
	
}
