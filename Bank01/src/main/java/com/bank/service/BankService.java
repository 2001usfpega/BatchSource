package com.bank.service;

import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.bean.Employee;



public interface BankService {
	public void custLogin(String name, String pass) ;

	public void customerRegister(String name,String pass);
	public void customerAplication(String name,String email, String addres,String phone,String pass);
	public void customerLogin(String name, String password);
	public void viewAcoount(int account);
	public int get_balance();
	public void deposit(int amount,int account);
	public void withdraw(int account, Double amount);
	public List<Customer> getAllCustomer();
	
	public void adminLogin(String name, String pass);
	public void viewAllAccount();
	public void deleAccount(int accountNumber);
	public void createCustomer();
	public void getAccount(int id);
	
	
	
	
	
	
}
