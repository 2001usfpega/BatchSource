package com.aj.service;

import java.util.List;

import com.aj.models.Account;
import com.aj.models.User;

public interface AccountService {
	public List<Account> getAllAccounts();
	public List<Account> getAccountByCustId(User user);
	public void createAccount(Account account);
	public void depositMoney(Account account, float amount);
	public boolean withdrawMoney(Account account, float amount);
	public Account getAccountById(Account account);

	
}
