package com.revature.corejavaassignment;

import java.util.*;

public class ComparatorQuestion {

	//private variables
	private String name;
	private String dept;
	private int age;

	//public methods - getters and setters	
	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept() {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge() {
		this.age = age;
	}
	
	//class constructor initializing variables
	public ComparatorQuestion(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	//0verriding toString() to set parameters for printing
	@Override
	public String toString() {
		return name+" "+dept+" "+age;
	}
	
	
	
}
