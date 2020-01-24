package com.aj.corejava;

public class Employee {
	
	private String name, department;
	private String age;
	
	public Employee(String name, String department, String age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + "\n   Department: " + this.department + "\n   Age: " + this.age + "\n"; 
	}
}

