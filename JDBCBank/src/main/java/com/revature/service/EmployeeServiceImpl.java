package com.revature.service;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	CustomerDao cd = new CustomerDaoImpl();
	EmployeeDao ed = new EmployeeDaoImpl();
	AccountDao ad = new AccountDaoImpl();

	@Override
	public void createEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(Customer customer) {
		cd.deleteCustomer(customer.getCustomerId());

	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllAccounts(int customerId) {
		ad.deleteAccountsByCustomerId(customerId);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return cd.getAllCustomers();
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your username > ");
		String u = scan.nextLine();
		Employee emp = ed.getEmployeeByUsername(u);
		System.out.println("Please enter your password > ");
		String p = scan.nextLine();
		if (emp != null) {
			if (p.equals(emp.getPassword())) {
				emp.setCustomers(cd.getAllCustomers());
				return emp;
			}
		}
		return null;

	}

	@Override
	public void updateCustomer(Customer customer) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new username > ");
		String newUser = scan.nextLine();
		System.out.println("Enter a new password > ");
		String newPass = scan.nextLine();
		customer.setUsername(newUser);
		customer.setPassword(newPass);
		cd.updateCustomer(customer);

	}

}
