package com.revature.model;

public class Employee {
	
	private String empID;
	private String empUserName;
	private String empPassWord;
	private int empType;
	private String empFirstName;
	private String empLastName;
	
	public Employee() {
		super();
	}

	public Employee(String empID, String empUserName, String empPassWord, int empType, String empFirstName,
			String empLastName) {
		super();
		this.empID = empID;
		this.empUserName = empUserName;
		this.empPassWord = empPassWord;
		this.empType = empType;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empUserName=" + empUserName + ", empPassWord=" + empPassWord
				+ ", empType=" + empType + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName + "]";
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPassWord() {
		return empPassWord;
	}

	public void setEmpPassWord(String empPassWord) {
		this.empPassWord = empPassWord;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}


	
	
	
	

	
	
	

}
