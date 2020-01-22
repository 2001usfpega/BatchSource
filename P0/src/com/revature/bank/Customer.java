package com.revature.bank;
import java.util.ArrayList;

public class Customer extends User {
	Customer(String name, String pw) {
		super(name, pw);
	}

	private ArrayList<Account> myAccounts= new ArrayList<>();
	
	@Override
	public void displayOptions() {
		System.out.println("you are logged in as a user");
	}
	public void createAccount() {
		Account newAcc = new Account();
		myAccounts.add(newAcc);
	}
	
	//create joint account
	public void createJointAccount(Customer buddy) {
		Account newAcc = new Account();
		myAccounts.add(newAcc);
		buddy.myAccounts.add(newAcc);
	}
	public void addAccount(Account acc) {
		myAccounts.add(acc);
	}

}
