package com.bank.user;
import java.util.List;

import com.bank.dao.CustomerDaoImpl;

public abstract class User{
	protected static CustomerDaoImpl customerDao=new CustomerDaoImpl();
	protected int userID;
	protected String username;
	protected String password;
	protected String firstname;
	protected String lastname;
	
	

	public User(int id,String name, String pw, String fName, String sName){
		this.userID=id;
		this.username=name;
		this.password=pw;
		this.firstname=fName;
		this.lastname=sName;
	}

	public int getUserID() {
		return userID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	
	public void setFirstName(String fName) {
		//server stuff
		firstname = fName;
	}
	
	public void setLastName(String sName) {
		//server stuff
		lastname = sName;
	}
	
	public void setUserName(String name) {
		//server stuff
		username = name;
	}
	
	public void setPassword(String pw) {
		//server stuff
		password = pw;
	}
	
	public static List<User> getUserList(){
		//server stuff
		return null;
	}
	
	
	//Checking if username is exist
	public static boolean checkUsername(String name) {
		//User u = customerDao.selectByUserNameAndPassword(name);

		
		//server stuff
		return false;
	}
	
	//Find user with matching name and password
	public static User getUser(String name,String pw) {
		User u = customerDao.selectByUserNameAndPassword(name, pw);
		if(u!=null) {
			return u;			
		}
		//System.out.println("The password is not correct!!!");
		return null;
	}
	
	public static User getUser(int custID) {
		//get user from server
		return null;
	}
	
	public abstract void userActions();
	
	//File saving supporting
	@Override
	public String toString() {
		return "ID: "+userID+"   USERNAME: "+username+" \tFULLNAME: "+firstname+" "+lastname;
	}	
}
