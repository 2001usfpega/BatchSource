package com.revature.service;

import com.revature.model.Account;
import com.revature.model.Customer;

public interface CustomerService {
	
	public Customer logIn(String u, String p);
	
	public boolean checkUsernameAndPassword(String u, String p);
	
	public void createCustomer(Customer customer);
	
	public boolean deleteCustomer();
	
	public void deleteOnZeroBalance(Account account);
}
