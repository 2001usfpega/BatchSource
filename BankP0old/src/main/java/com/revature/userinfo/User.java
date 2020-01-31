package com.revature.userinfo;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.bankutil.BankUtil;

//import javax.lang.model.element.NestingKind;

/*
 * User store username and password of the user
 * Used for logging process
 * 
 */
public abstract class User implements Serializable{
	
	//serial ID
	private static final long serialVersionUID = 1L;
	private static int nextID =1000;
	
	private static ArrayList<User> userList = new ArrayList<User>();

	protected String name;
	protected String password;
	protected String fName;
	protected String sName;
	protected String userID;

	/*
	 * Getter and Setter Area
	 */
	public String getFName() {
		return this.fName;
	}
	
	public String getSName() {
		return this.sName;
	}
	
	//get username
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean isPassword(String test) {
		return password.equals(test);
	}
	
	public void setFName(String fName) {
		this.fName = fName;
		BankUtil.saveAll();
	}
	
	public void setSName(String sName) {
		this.sName = sName;
		BankUtil.saveAll();
	}
	
	public void setName(String name) {
		this.name = name;
		BankUtil.saveAll();
	}
	
	public void setPassword(String password) {
		this.password = password;
		BankUtil.saveAll();
	}
	
	//pull existing user list
	public static void initalizeList(ArrayList<User> uList) {
		userList=uList;
	}

	public static void setNextID(int x) {
		nextID=x;
	}

	public static int getNextID() {
		return nextID;
	}
	
	public static ArrayList<User> getUserList(){
		return userList;
	}
	
	public String getUserID() {
		return userID;
	}
	
	/*
	 * User look up
	 */
	//Checking if username is exist
	public static boolean checkUsername(String name) {
		if (userList!=null) {
			for(User u:userList) {
				if(u.getName().equals(name)) {
					return true;
				}
			}
		}	
		return false;
	}
	
	//Find user with matching name and password
	public static User getUser(String name,String pw) {
		for(User u:userList) {
			if(u.getName().equals(name)) {
				//username found but password incorrect
				if (!u.isPassword(pw)) {
					//System.out.println("The password is not correct!!!");
					return null;
				}else {
					return u;
				}				
			}
		}
		return null;
	}
	
	public static User getUser(String custID) {
		StringBuilder sb = new StringBuilder(custID);
		String userID = sb.deleteCharAt(0).toString();
		
		for (User user : userList) {
			if (user.getUserID().equals(userID)) {
				return user;
			}
		}
		return null;
	}
	
	/*
	 * Constructor
	 */
	public User(String name, String pw, String fName, String sName){
		this.name=name;
		this.password=pw;
		this.fName = fName;
		this.sName = sName;
		
		//give user a unique id
		userID=nextID+"";
		nextID++;

		userList.add(this);
	}
	
	public abstract void displayOptions();
	
	public abstract void userActions();
	
	//File saving supporting
	@Override
	public String toString() {
		return "ID: "+userID+"   USERNAME: "+name+" \tFULLNAME: "+fName+" "+sName;
	}	
}
