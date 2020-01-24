package com.revature.user;

public abstract class User {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return fName + ":" + lName + ":" + address.toString() + ":" + phone + ":" 
					+ email + ":" + username + ":" + password + "\n";
	}
	
	
}
