package com.revature.bankingassignment;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		

		
		Scanner verificationScanner = new Scanner(System.in);
		Scanner loginScanner = new Scanner(System.in);
		
		System.out.println("Enter 1 to Create New Account, Enter 2 for LOGIN");
		int login = loginScanner.nextInt();

		
		switch(login) {
		
		case 1: 	
				Account account = new Account();
				account.createAccount();
		break;
		case 2:  	System.out.println("Enter 1 for CUSTOMER, Enter 2 for EMPLOYEE ");
					int verification = verificationScanner.nextInt();
		
					switch(verification) {

						case 1: Scanner usernameScanner = new Scanner(System.in);
								System.out.println("Please Enter UserID: ");	
								String UserID  = loginScanner.next();
								System.out.println("Please Enter Password: ");	
								String Password  = loginScanner.next();
								Customer identify = new Customer();
								identify.setUserID(UserID);
								identify.setPassword(Password);
								if(UserID == identify.getUserID() && Password ==identify.getPassword())
								{
									
									Scanner cusScanner = new Scanner(System.in);
									
									System.out.println("Enter 1 for withdrawl, Enter 2 for Deposit");
									int cusscan = cusScanner.nextInt();	
									
									switch(cusscan) {
									
									case 1: Customer a = new Customer();
									a.withdraw(cusscan);
									break;
										
									case 2:Customer b = new Customer();
											b.deposit(cusscan);
									break;
									
									case 3:Customer c = new Customer();
											c.getBalance();
									break;
										
									
								}
								}
								else
								{
									
									
									System.out.println("FAILED LOGIN ATTEMPT");
									
								}
								
								
						break;

						case 2: 
							
								Scanner EmpusernameScanner = new Scanner(System.in);
								System.out.println("Please Enter UserID: ");	
								String EmpUserID  = loginScanner.next();
								System.out.println("Please Enter Password: ");	
								String EmpPassword  = loginScanner.next();
								Employee worker = new Employee();
								worker.setEmployeeID(EmpUserID);
								worker.setEmployeePassword(EmpPassword);
								if(EmpUserID == worker.getEmployeeID() && EmpPassword == worker.getEmployeePassword())
								{
								
									Scanner empScanner = new Scanner(System.in);
									
									System.out.println("Enter 1 to view Employee Accounts, Enter 2 to Approve Accounts:");
									int empscan = empScanner.nextInt();	
									
									switch(empscan) {
									
									case 1: Employee e = new Employee();
											e.viewCustomerAccount();
										break;
									case 2: Employee g = new Employee();
											//g.approveAccounts
										break;
										

								
								
								}
								}
							
								else
								{
								
								
									System.out.println("FAILED LOGIN ATTEMPT");
								
								}
								break;

								default: System.out.println("INVALID ENTRY");
								break;
		
		
							}
		

		


		}	

	}
}

