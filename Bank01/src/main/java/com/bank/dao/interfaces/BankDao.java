package com.bank.dao.interfaces;

import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Admin;
import com.bank.bean.Customer;
import com.bank.bean.Employee;

public interface BankDao {
	public void insertcustNamePass(String name,String pass);
	public void selectCustomerInfo(String name,String pass);
	public void selectCustomerAccount(String name);
	public int selectCustomerId(Customer cust) ;

	/*public int get_balance();
	public void deposit(int amount,int account);
	public int withdraw(int amount,int account);

	public void adminLogin();
	public void viewAllAccount();
	public void deleAccount(int accountNumber);
	public void createCustomer();*/
	public void insertCustomer(Customer cust);
	public void updateCustomer(String name,String email, String addres,String phone,String pass);
	public void deleteCustomer(Customer cust);
	public List<Customer> selectAllcustomer();
	public void updateAccBalance(int cust_id,int amount);
	public Double selectCustomerbalance(int cust_Id);
	public  void insertAccount(int acc_num,int balance,int cust_id);
	public void updateBalanceAfterWithdraw(int cust_id,Double amount);

	
	
}
