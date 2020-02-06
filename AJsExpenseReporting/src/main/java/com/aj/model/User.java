package com.aj.model;

public class User {
	private Integer u_id = null;
	private String fname, lname, uname, pw, role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer u_id, String fname, String lname, String uname, String pw, String role) {
		this.u_id = null;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pw = pw;
		this.role = role;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pw=" + pw
				+ ", role=" + role + "]";
	}
}
