package com.revature.bank;

import java.util.ArrayList;

abstract class User{
	private static ArrayList<User> userList = new ArrayList<>();
	private String name;
	private String password;
	User(String name, String pw){
		this.name=name;
		this.password=pw;
		userList.add(this);
	}
	public void displayOptions() {
		System.out.println("you shouldnt see this");
	}

	
	public static User getUser(String name,String pw) {
		for(User u:userList) {
			if(u.name==name&&u.password==pw) {
				return u;
			}
		}
		return null;
	}
}