package com.revature;

import java.util.List;

public interface User {
	
	public void getAccount(int a);
	
	public void getBalance(int b);
	
	public void withdraw(int a, int d);
	
	public void deposit(int a, int w);
	
	public void makeTransfer(int a, int b, int t);
	

}
