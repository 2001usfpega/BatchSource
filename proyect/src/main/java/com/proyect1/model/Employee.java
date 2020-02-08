package com.proyect1.model;

public class Employee {
	
	private  int emp_id;
	private String emp_username;
	private String emp_pass;
	private String firstname;
	private String lastname;
	public Employee() {}
	
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_username=" + emp_username + ", emp_pass=" + emp_pass
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}


	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_username() {
		return emp_username;
	}
	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Employee(int emp_id, String emp_username, String emp_pass, String firstname, String lastname) {
		super();
		this.emp_id = emp_id;
		this.emp_username = emp_username;
		this.emp_pass = emp_pass;
		this.firstname = firstname;
		this.lastname = lastname;
	}

}
