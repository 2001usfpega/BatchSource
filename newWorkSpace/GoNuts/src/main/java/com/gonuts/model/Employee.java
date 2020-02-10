package com.gonuts.model;

public class Employee {

	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private int rank;
	
	
	public Employee(int id, String username, String firstName, String lastName, int rank) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
	}

	public int getId() { return id; }
	public String getUsername() { return username; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public int getRank() { return rank; }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", rank=" + rank + "]";
	}
	
	
}
