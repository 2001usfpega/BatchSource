package com.bank.dao.interfaces;

import java.util.List;

import com.bank.bean.Customer;

public interface CustomerDao {

	public void insertCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(Customer cust);
	public List<Customer> selectAllcustomer();
	public Customer selectCustomerById(int cust_Id);

	
	
	
}
