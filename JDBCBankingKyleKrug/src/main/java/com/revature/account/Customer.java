package com.revature.account;
//Created By Kyle Krug
import java.text.DecimalFormat;

import com.revature.database.DatabaseAccess;

public class Customer extends Account implements CustomerInterface {
	 double balance;
	 int balance_id;
	static DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public void deposit(double a, double b) {
		a = a +b;
		setBalance(a);
		System.out.println("Desposit Successful");
	}

	@Override
	public void withdraw(double a, double b) {
		if (a> b) {
			a  = a -b;
			setBalance(a);
			System.out.println("Withdraw successful");
		}else {
			System.out.println("You cannot withdraw more than what is in your account");
		}
	}

	@Override
	public void transfer(Customer a, int id, double amount) {
		DatabaseAccess db = new DatabaseAccess();
		Customer b = db.employeeGetCustomer(id);
		if(b.getFirstname() != null) {
			if(amount > a.getBalance()) {
				System.out.println("Invalid Funds");
				if(b.isApproved() == false ) {
					System.out.println("Person is not approved cannot transfer");
				}else {
					a.withdraw(a.getBalance(),amount);
					b.deposit(b.getBalance(), amount);
					db.updateCustomer(b);
				}
			}else {
				System.out.println("Person does not exisit");
			}
		}


	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBalance_id() {
		return balance_id;
	}

	public void setBalance_id(int balance_id) {
		this.balance_id = balance_id;
	}

	public String toString() {
		return "===========Customer information==========="
				+ "Id : " + getId() +"\n"
				+"Balance: "+ df.format(getBalance())+"\n"
				+"Username: " + getUsername()+"\n"
				+ "Password: " + getPassword() + "\n"
				+"First name: " + getFirstname() + "\n"
				+ "Last name: " + getLastname() + "\n"
				+ "Age: " + getAge() + "\n"
				+ "Gender: " + getGender()+ "\n"
				+"SSN: " + getSsn() +"\n"
				+"Additional Info: "+ getAdditionalInfo() +"\n"
				+"Approved: " + isApproved();
		
	}
}
