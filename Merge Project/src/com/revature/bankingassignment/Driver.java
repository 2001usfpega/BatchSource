package com.revature.bankingassignment;
import java.util.*;
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
									
									System.out.println("CUSTOMER MENU");
									
									
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
								
									System.out.println("Employee MENU");
								
								
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


