package com.aj.models;

public class User {

	private String user_id = null;
	private String fname, lname, uname, pw, role;
	
	public User() {
		
	}
	
	public User(String user_id, String fname, 
			String lname, String uname, String pw, String role) {
		this.user_id = null;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pw = pw;
		this.role = role;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "User [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pw=" + pw
				+ ", role=" + role + "]";
	}

}
