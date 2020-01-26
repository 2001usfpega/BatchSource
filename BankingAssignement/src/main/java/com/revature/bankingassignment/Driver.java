package com.revature.bankingassignment;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		

		
		Scanner verificationScanner = new Scanner(System.in);
		Scanner loginScanner = new Scanner(System.in);
		
		System.out.println("Enter 1 for CREATE ACCOUNT, Enter 2 for LOGIN");
		int login = loginScanner.nextInt();

		
		switch(login) {
		
		case 1: 	
				Account account = new Account();
				new Account();
							
						
						

		
		case 2:  	System.out.println("Enter 1 for CUSTOMER, Enter 2 for EMPLOYEE ");
					int verification = verificationScanner.nextInt();
		
					switch(verification) {

						case 1: Scanner usernameScanner = new Scanner(System.in);
								System.out.println("Please Enter UserID: ");	
								int UserID  = loginScanner.nextInt();
								System.out.println("Please Enter Password: ");	
								String Password  = loginScanner.next();
								
								if(UserID == Customer.getUserID() && Password == Customer.getPassword())
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
								int EmpUserID  = loginScanner.nextInt();
								System.out.println("Please Enter Password: ");	
								String EmpPassword  = loginScanner.next();
							
								if(EmpUserID == Employee.getEmployeeID() && EmpPassword == Employee.getEmployeePassword())
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
