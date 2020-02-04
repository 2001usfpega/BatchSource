package com.revature.account;
//Created By Kyle Krug
public interface CustomerInterface {
	public void deposit(double a, double b);
	public void withdraw(double a, double b);
	public void transfer(Customer a,int id, double amount);
}
