package com.bank.user;
import java.util.List;
import java.util.Scanner;

import com.bank.BankUtil;
import com.bank.dao.AccountDaoImpl;
import com.bank.dao.CustomerDaoImpl;

public abstract class User{
	protected static CustomerDaoImpl customerDao=new CustomerDaoImpl();
	protected static AccountDaoImpl accountDao=new AccountDaoImpl();
	protected static Scanner scan =BankUtil.getScanner();
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
		firstname = fName;
		this.updateUser();
	}
	
	public void setLastName(String sName) {
		lastname = sName;
		this.updateUser();
	}
	
	public void setUserName(String name) {
		username = name;
		this.updateUser();
	}
	
	public void setPassword(String pw) {
		password = pw;
		this.updateUser();
	}
	
	public static List<User> getUserList(){
		return customerDao.selectAllUsers();
	}
	
	
	//Checking if username is exist
	//returns true if taken
	public static boolean checkUsername(String name) {
		if(customerDao.selectByUsername(name)!=null) {
			return true;
		}
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
	
	public static User getUser(int uid) {
		User user=customerDao.selectByUserId(uid);
		if(user==null) {
			//user=customerDao.selectByUserID(uid);
		}
		return user;
	}
	
	public abstract void userActions();
	
	public boolean deleteUser() {
		return customerDao.deleteUser(this);
	}
	
	
	public void updateUser() {
		customerDao.updateUser(this);//new Customer(1141,"zen","123","Zen","Budah"));
	}
	
	
	//File saving supporting
	@Override
	public String toString() {
		return "ID: "+userID+"   USERNAME: "+username+" \tFULLNAME: "+firstname+" "+lastname;
	}	
}
