package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao extends DaoDao{
	
	/**
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomers();
	
	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public Customer getCustomerByUsername(String username);
	
	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public boolean deleteCustomer(Integer customerID);
	
	/**
	 * 
	 * @param customer
	 */
	public void createCustomer(Customer customer);
	
}
