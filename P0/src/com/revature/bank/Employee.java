package com.revature.bank;

import java.util.ArrayList;

public class Employee extends User{
	private static ArrayList<Account> pendingAccounts = new ArrayList<>();

	Employee(String name, String pw){
		super(name,pw);
	}
	
}
