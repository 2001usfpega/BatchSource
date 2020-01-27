package com.revature.Driver;

public class Employee {

	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() 
    { 
        return this.name + " " + this.department + 
                           " " + this.age; 
    } 
}
