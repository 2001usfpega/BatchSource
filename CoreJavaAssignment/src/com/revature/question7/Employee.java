package com.revature.question7;


/**
 * Is the class for question 7 of the assignment. Holds an employees name
 * Department and age.
 * 
 * @author Jacob Lail
 *
 */
public class Employee {
	private String name;

	private String department;

	private int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}
