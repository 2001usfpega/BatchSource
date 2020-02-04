package com.bankThing;

public class Employee {
	
	private long  employeeid;
	private String emp_first;
	private String emp_last;
	private String emp_pw;
	private boolean admin;
	
	public Employee(){};
	
	public Employee(long employeeid, String emp_first, String emp_last, String emp_pw,  boolean admin) {
		super();
		this.employeeid = employeeid;
		this.emp_first = emp_first;
		this.emp_last = emp_last;
		this.emp_pw = emp_pw;
		this.admin = admin;
	}
	
	public Employee(String emp_first, String emp_last, String emp_pw, boolean admin) {
		super();
		this.employeeid = 0;
		this.emp_first = emp_first;
		this.emp_last = emp_last;
		this.emp_pw = emp_pw;
		this.admin = admin;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmp_first() {
		return emp_first;
	}

	public void setEmp_first(String emp_first) {
		this.emp_first = emp_first;
	}

	public String getEmp_last() {
		return emp_last;
	}

	public void setEmp_last(String emp_last) {
		this.emp_last = emp_last;
	}

	public String getEmp_pw() {
		return emp_pw;
	}

	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", emp_first=" + emp_first + ", emp_last=" + emp_last
				+ ", emp_pw=" + emp_pw + ", admin=" + admin + "]";
	}

	

}
