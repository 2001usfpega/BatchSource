package com.revature.banking.test;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Scanner scanningStan = new Scanner(System.in);

	public static void main(String [] args) {
		menu();
	}
	
	public static void menu() {

		
		Customer customer = new Customer();
		Employee employee = new Employee();
		Admin admin = new Admin();
		ObjectIO wObj = new ObjectIO();
		
			
			System.out.println("Hello and welcome to Kyle and Alia's Bank!\n\nAre you a:\n");
			System.out.println("1. New customer?");
			System.out.println("2. Returning customer?");
			System.out.println("3. Employee?");
			System.out.println("4. Administrator?");
			
			String userType = scanningStan.nextLine();
			
			
			switch(userType) {
			
				case "1":

					String choices;
					System.out.println("\nWelcome valued new customer!");
					System.out.println("Would you like to:");
					System.out.println("1. Create an account?");
					System.out.println("2. Go away?");
					choices = scanningStan.nextLine();
					
					if(choices.equals("1")) {
											
						customer.NewAccount();

						wObj.writeObject(customer, "Banking/Customer/" + customer.getId());
						
						System.out.println("Your account application is being processed! We'll get back to you shortly! Have a nice day!");
						menu();
					}else {
						
						System.out.println("\nBye!");
						menu();
						
					}
					
					break;
					
				case "2":
					
					System.out.println("\nWelcome valued returning customer!");
					customer.loginCustomer();
					menu();
					break;
					
				case "3":

					System.out.println("Welcome to the Employee Menu");
					employee.employeeLogin();
					menu();
					break;
					
				case "4":
					
					System.out.println("\nWelcome valued administrator!");
					admin.adminLogin();
					menu();
					break;
				case "closer":
					System.out.println("Thank you for Banking with us");
					System.out.println("Shutting down...");
					System.exit(0);
					
				default:
					menu();
					break;
			}
	}
}
		