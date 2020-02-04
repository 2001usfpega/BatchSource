package com.bank.main;

import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Customer;
import com.bank.bean.Employee;
import com.bank.dao.interfaces.BankDao;
import com.bank.dao.interfaces.CustomerDao;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;
import com.bank.service.Menu;
import com.bankdao.interfaces.impl.BankDaoImpl;
import com.bankdao.interfaces.impl.CustomerDaoImpl;


public class BankDriver {
	
	
private static String url=System.getenv("BANK_DB_URL");
     public static Customer cust;
	private static String username1=System.getenv("BANK_DB_USERNAME"); 
	private static String password1=System.getenv("BANK_DB_PASSWORD");
	public static List<Customer> custList=new ArrayList<Customer>();

	
      //static Employee emp= new Employee();
	public static void main(String[] args) {
		
	    
		BankService banServ=new BankServiceImpl();
		BankDao mydao=new BankDaoImpl();
		
		//mydao.insertCustomer(cust);
		//banServ.getAllCustomer();
		//System.out.println(Customer.custList.get(0).toString());
		
		
		Menu menu=new Menu();
		menu.startMenu();
		

		
		
		
		
		
		
		
		/*emp.setEmployee_id(1);
		emp.setName("Maria");
		emp.setPassword("password");
		
		
		banServ.newEmployee(emp);
		
		System.out.println(emp.getName());*/
		
		
		
		
		
		/*System.out.println(url);
		System.out.println(username1);
		System.out.println(password1);
		
		BankService bankserv= new BankServiceImpl();
		
		List<Employee> empl= bankserv.getAllEmployee();
		
		System.out.println("Printing all employee "+ empl);
		
		for (Employee A : empl) {
			System.out.println(A);
			
		}

		Customer cust=new Customer();
		
		cust.setName("Maria");
		cust.setLastname("Perez");
		try {
			CustomerDao cDao=new CustomerDaoImpl();
			cDao.insertCustomer(cust);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		
	}

}		

	


