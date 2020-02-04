package com.bankThing.Dao;

import java.util.List;

import com.bankThing.Customer;
import com.bankThing.Employee;

public interface CustomerDaoInterface {
	
	
	//CREATE
	public int insertCustomer(String first1, String last1, String pw1);
	//READ
	public List<Customer> selectAllCustomer();
	public Customer selectCustomerById(int id);
	public Customer selectCustomerByName(String name);
	//UPDATE
	public boolean updateCustomer(long customerID, long accountID);
	//DELETE
	public boolean deleteCustomer(Customer customer);

}
