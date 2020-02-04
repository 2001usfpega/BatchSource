package com.bank.dao;

import java.util.List;

import com.bank.account.Account;
import com.bank.user.Customer;

public interface AccountDao {
	//CREATE
	public boolean insertAccount(Customer a);
	public boolean insertAccount(Customer a,Customer b);
	//READ
	public List<Account> selectAllAccounts();
	public List<Account> selectAllAccountsForUser(Customer c);
	public Account selectByAccountId(int id);
	
	//UPDATE
	public boolean transferMoney(Account a, Account b);
	public boolean updateAccount(Account a);
	
	//DELETE
	public boolean deleteAccount(Account a);
}
