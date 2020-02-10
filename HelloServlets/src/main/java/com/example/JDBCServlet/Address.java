package com.example.JDBCServlet;


public class Address {
	
	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	/**
	 * 
	 */
	String address;
	
	/**
	 * 
	 */
	String city;
	
	/**
	 * 
	 */
	String state;
	
	/**
	 * 
	 */
	String zip;
	
	public Address(String address, String city, String state, String zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
