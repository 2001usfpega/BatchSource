package com.revature.service;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;

public interface EmployeeService {
	
	/**
	 * 
	 */
	public void createEmployee();
	
	/**
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
	
	/**
	 * 
	 * @param account
	 */
	public void deleteAccount(Account account);
	
	/**
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomers();
	
	/**
	 * 
	 * @return
	 */
	public List<Account> getAllAccounts();
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * 
	 */
	public void deleteEmployee();
	
}
