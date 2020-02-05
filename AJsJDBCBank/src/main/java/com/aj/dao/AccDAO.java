package com.aj.dao;

import java.util.List;

import com.aj.models.Account;

public interface AccDAO {

	//CREATE
	public void createNewAcc(Account acc);
	
	//READ
	public List<Account> selectAllAccounts();
	public Account selectAccByAccId(String string);
	public List<Account> selectAccByCustId(Long userId);
	
	//UPDATE
	public void updateAccount(Account acc);
	
	//DELETE
	public void deleteAccount(int acc_id);
}
