package com.ers.model;

public class Employee {
	
	private int userid;
	
	private String username;
	
	private String password;
	
	private String fName;
	
	private String lName;
	
	/**
	 * 0 means that the employee is just a regular employee, 1 means 
	 * that the employee is a finance manager
	 */
	private int FinanceManager;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int userid, String username, String password, String fName, String lName, int financeManager) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		FinanceManager = financeManager;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getFinanceManager() {
		return FinanceManager;
	}

	public void setFinanceManager(int financeManager) {
		FinanceManager = financeManager;
	}

	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", FinanceManager=" + FinanceManager + "]";
	}
	
	
}
