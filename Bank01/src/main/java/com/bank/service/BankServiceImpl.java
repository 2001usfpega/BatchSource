package com.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.bean.Employee;
import com.bank.dao.interfaces.BankDao;
import com.bank.dao.interfaces.EmployeeDao;
import com.bank.main.BankDriver;
import com.bankdao.interfaces.impl.BankDaoImpl;
import com.bankdao.interfaces.impl.EmployeeDaoImpl;

public class BankServiceImpl implements BankService {
	
	
	 private EmployeeDao daoEmployee=new EmployeeDaoImpl();
	 private BankDao  myDao = new BankDaoImpl();

	public List<Customer> getAllCustomer() {
		
		List<Customer> list1=new ArrayList<Customer>();
	     list1=myDao.selectAllcustomer();
		
	     for (Customer cust : list1) {
	    	 System.out.println(list1);
			
		}
		//List<Employee> all_emp=myDao.selectAllEmployee();
		return list1;
	}


	@Override
	public void customerRegister(String name ,String pass) {
		System.out.println("in customer registr");
		  myDao.insertcustNamePass(name, pass);
		
	}

	@Override
	public void customerAplication(String name,String email, String addres,String phone,String pass) {
		System.out.println("in my bankser ");
		myDao.updateCustomer( name,email,  addres, phone,pass);
		
		
	}

	@Override
	public void customerLogin(String name, String password) {
		int cont = 0;
		List<Customer> list=myDao.selectAllcustomer();
				while (list.size()-1 >cont && (list.get(cont).getName().equals(name) != true
				|| list.get(cont).getPassword().equals(password) != true)) {
			
			cont++;
		}
			if(cont==list.size()-1 &&(list.get(cont).getName().equals(name) != true
					|| list.get(cont).getPassword().equals(password) != true) ) {
				System.out.println("You're username or password was not found");
				Menu.startMenu();
			}
	
			System.out.println("good");
			//BankDriver.cust=BankDriver.custList.get(cont);
		
		}
	

	@Override
	public void viewAcoount(int account) {
		
	Double bal=	myDao.selectCustomerbalance(account);
		//System.out.println(bal);
		
	}

	@Override
	public int get_balance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deposit(int account,int amount) {
		
				myDao.updateAccBalance(amount, account);
	}

	@Override
	public void withdraw(int account, Double amount) {
		
		if (amount<=myDao.selectCustomerbalance(account)) {
			myDao.updateBalanceAfterWithdraw(account, amount);
			
		}
		
	
	}

	@Override
	public void adminLogin(String name,String pass) {
	

	
		
	}

	@Override
	public void viewAllAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void custLogin(String name, String pass) {
		myDao.selectCustomerInfo(name, pass);
	}


	@Override
	public void getAccount(int id) {
		int account_num=(int)(Math.random()*100);
	System.out.println(account_num);
		int balance=0;
		
       myDao.insertAccount(account_num, balance,id);		
	}


	@Override
	public void createCustomer() {
		// TODO Auto-generated method stub
		
	}

}
