package com.bankThing.Dao;


import java.util.List;

import com.bankThing.BankAccount;

public interface BankAccountDaoInterface {
	
	
	//CREATE
	public int insertBankAccount( );
	//READ
	public List<BankAccount> selectAllBankAccount();
	public BankAccount selectBankAccountById(long id);
	public BankAccount selectBankAccountByName(String name);
	//UPDATE
	public boolean updateBankAccount(BankAccount bankAccount);
	//DELETE
	public boolean deleteBankAccount(BankAccount bankAccount);

}
