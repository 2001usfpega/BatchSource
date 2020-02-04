package com.revature.service;

import java.util.List;

import com.revature.model.Account;

public interface AccountService {
	/**
	 * Allows the user to deposit into the specified account with the 
	 * given amount. The should be within the constraints declared in the 
	 * service implementation.
	 * @param amount The given amount to be withdrawn
	 * @param account The specified account from which the user will perform a withdraw
	 * @return The amount of money withdrawn, also will print their new balance to the console.
	 */
	public double withdraw(double amount, Account account);
	
	/**
	 * 
	 * @param amount
	 * @param accountNum
	 * @return
	 */
	public boolean deposit(double amount, Account account);
	
	/**
	 * 
	 * @param accountID
	 * @return
	 */
	public Account getAccount(Account account);
	
	/**
	 * 
	 * @param customerId
	 */
	public void createAccount(int customerId);
	
	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public List<Account> fillAllAccounts(int customerID);
	
	
}
