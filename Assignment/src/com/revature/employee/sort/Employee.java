package com.revature.employee.sort;

public class Employee {
	String name;
	int dept;
	int age;
	

	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee(String name, int dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

}
