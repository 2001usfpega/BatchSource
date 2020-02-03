package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();
	AccountService as = new AccountServiceImpl();

	@Override
	public Customer logIn(String u, String p) {
		if(checkUsernameAndPassword(u,p)) {
			Customer cust = cd.getCustomerByUsername(u);
			cust.setAccounts(as.fillAllAccounts(cust.getCustomerId()));
			return cust;
		} else {
			return null;
		}
	}

	@Override
	public boolean checkUsernameAndPassword(String u, String p) {
		Customer customer = cd.getCustomerByUsername(u);
		if(customer.getPassword().equals(p)) {
			return true;
		} else {
			System.out.println("Invalid Password");
			return false;
		}
	}

	@Override
	public void createCustomer(Customer customer) {
		cd.createCustomer(customer);
	}

	@Override
	public boolean deleteCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

}
