package com.revature.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.revature.account.Account;

public class Customer extends User{
	/**
	 * Stores all of the accounts that the customer has opened
	 */
	private ArrayList<Account> accounts;
	
	
	private static final String OUT_FILE = "PendingCustomers.txt";
	
	

	public Customer(String username, String password, String fName, String lName,
			Address address, String phone, String email) {
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		accounts = new ArrayList<Account>();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public void printToFile() {
		OutputStream os = null;
		File file = new File(OUT_FILE);
		String out = this.toString();
		try {
			os = new FileOutputStream(file, true);
			os.write(out.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account act) {
		accounts.add(act);
	}
}
