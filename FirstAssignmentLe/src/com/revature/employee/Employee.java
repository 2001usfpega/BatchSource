package com.revature.employee;

import java.util.Comparator;

public class Employee {
	public String emName;	//Employee's Name
	public int emDep;		// Assume the Department is a number (instead of String) which specify the department name
	public int emAge;		// Employee's Age
	public float workExp;
	public float evaluation;
	
	
	public Employee(String emName, int emDep, int emAge) {
		this.emName = emName;
		this.emDep = emDep;
		this.emAge = emAge;
	}
	
	public void setEmName(String emName) {
		this.emName = emName;
	}
	
	public void setEmDep(int emDep) {
		this.emDep = emDep;
	}
	
	public void setEmAge(int emAge) {
		this.emAge = emAge;
	}
	
	public void setWorkExp(float workExp) {
		this.workExp = workExp;
	}
	
	public void setEvaluation(float evaluation) {
		this.evaluation = evaluation;
	}
	
	public String getEmName() {
		return this.emName;
	}
	
	public Integer getEmDep() {
		return this.emDep;
	}
	
	public Integer getEmAge() {
		return this.emAge;
	}
	
	public Float getWorkExp() {
		return this.workExp;
	}
	
	public Float getEvaluation() {
		return this.evaluation;
	}
	
	@Override
	public String toString() {
		return "Employee's Name:" + this.getEmName() + " Department: " + this.getEmDep() +
				" Age: " + this.getEmAge();
	}
	
}


