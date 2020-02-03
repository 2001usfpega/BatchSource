package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.model.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao ad = new AccountDaoImpl();

	@Override
	public double withdraw(double amount, Account account) {
		if (amount > 0 && amount < account.getBalance()) {
			account.modifyBalance(-amount);
			ad.updateAccount(account);
			return amount;
		} else {
			System.out.println("Invalid amount. Please enter positive amount.");
			return 0;
		}
	}

	@Override
	public boolean deposit(double amount, Account account) {
		if (amount > 0) {
			account.modifyBalance(amount);
			ad.updateAccount(account);
			return true;
		} else {
			System.out.println("Invalid amount. Please enter positive amount.");
			return false;
		}
	}

	@Override
	public Account getAccount(Account accountID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccount(int customerId) {
		ad.createAccount(customerId);
		
	}

	@Override
	public List<Account> fillAllAccounts(int customerID) {
		return ad.getAccountsByID(customerID);
	}

}
