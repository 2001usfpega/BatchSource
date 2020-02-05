package com.aj.service;

import java.util.ArrayList;
import java.util.List;

import com.aj.dao.AccDAO;
import com.aj.dao.AccDAOImpl;
import com.aj.models.Account;
import com.aj.models.User;

public class AccountServiceImpl implements AccountService {
	private AccDAO accDao = new AccDAOImpl();
	private List<Account> accList = new ArrayList<>();
	private Account currentAcc = new Account();
	
	@Override
	public List<Account> getAllAccounts() {
		accList = accDao.selectAllAccounts();
		return accList;
	}
	
	@Override
	public List<Account> getAccountByCustId(User user) {
		Long userId = Long.parseLong(user.getUser_id());
		accList = accDao.selectAccByCustId(userId);
		
		return accList;
	}

	@Override
	public Account getAccountById(Account account) {
		currentAcc = accDao.selectAccByAccId(account.getAcc_id());
		
		return currentAcc;
	}

	@Override
	public void createAccount(Account account) {
		accDao.createNewAcc(account);
		
	}

	@Override
	public void depositMoney(Account account, float amount) {
		float currBal = account.getBalance();
		
		float newBal = currBal + amount;
		
		account.setBalance(newBal);
		accDao.updateAccount(account);
	}

	@Override
	public boolean withdrawMoney(Account account, float amount) {
		
		float currBal = account.getBalance();
		
		if (currBal < amount) {
			return false;
		}
		float newBal = currBal - amount;
		
		account.setBalance(newBal);
		accDao.updateAccount(account);
		return true;
	}



}
