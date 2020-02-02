package com.bank.user;
import java.util.List;

public abstract class User{
	protected int userID;
	protected String username;
	protected String password;
	protected String firstname;
	protected String lastname;
	
	

	public User(int id,String name, String pw, String fName, String sName){
		this.userID=id;
		this.username=name;
		this.password=pw;
		this.firstname = fName;
		this.lastname = sName;
	}

//	public boolean isPassword(String test) {
//		return password.equals(test);
//	}
	
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
	
	public int getUserID() {
		return userID;
	}
	
	//Checking if username is exist
	public static boolean checkUsername(String name) {
		//server stuff
		return false;
	}
	
	//Find user with matching name and password
	public static User getUser(String name,String pw) {
		//server stuff
//		for(User u:userList) {
//			if(u.getName().equals(name)) {
//				//username found but password incorrect
//				if (!u.isPassword(pw)) {
//					//System.out.println("The password is not correct!!!");
//					return null;
//				}else {
//					return u;
//				}				
//			}
//		}
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
