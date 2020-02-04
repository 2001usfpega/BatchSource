package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDao extends DaoDao{
	
	/**
	 * 
	 * @return
	 */
	public List<Account> getAccounts();
	
	/**
	 * 
	 * @return
	 */
	public List<Account> getAccountsByID(int customerID);
	
	/**
	 * 
	 * @param customerID
	 */
	public void createAccount(int customerID);
	
	/**
	 * 
	 * @param account
	 * @return
	 */
	public boolean updateAccount(Account account);
	
	/**
	 * 
	 * @param accountNum
	 * @return
	 */
	public Account getAccount(int accountNum);
	
	/**
	 * 
	 * @param accountNum
	 * @return
	 */
	public boolean deleteAccount(int accountNum);
	
	public void deleteAccountsByCustomerId(int CustomerId);
	
}
