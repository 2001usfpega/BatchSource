package com.bank.bean;

import java.util.List;

public class Employee  {
	
	
	private int employee_id;
	private String name;
	private String password;
	private int admi_id;
	
	public Employee() {}
	public Employee(int employee_id, String name, String password, int admi_id) {
		super();
		this.employee_id = employee_id;
		this.name = name;
	
		this.password = password;
		this.admi_id = admi_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAdmi_id() {
		return admi_id;
	}
	public void setAdmi_id(int admi_id) {
		this.admi_id = admi_id;
	}
	

	
}
