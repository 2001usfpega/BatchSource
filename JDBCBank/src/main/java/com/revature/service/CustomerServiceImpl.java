package com.revature.service;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.model.Account;
import com.revature.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao cd = new CustomerDaoImpl();
	AccountService as = new AccountServiceImpl();
	AccountDao ad = new AccountDaoImpl();

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

	@Override
	public void deleteOnZeroBalance(Account account) {
		if(account.getAccountID() == 0) {
			ad.deleteAccount(account.getAccountID());
		} else {
			System.out.println("Cannot delete an account that has a balance greater than 0.");
		}
	}

}
