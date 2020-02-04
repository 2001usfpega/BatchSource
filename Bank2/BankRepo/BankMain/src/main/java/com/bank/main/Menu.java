package com.bank.main;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.bank.connection.ConnectionMethods;

public class Menu {

	public static Customer curCustomer = null;

	public static void startMenu() {

		System.out.println("Welome to our banking app!");
		System.out.println("If you are a customer type login if not type register");

		System.out.println("If you're an employee or administrator type employee or admin");

		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();

		switch (option) {
		case "login":
			System.out.println("Enter your name");
			String name = scan.nextLine();
			System.out.println("Enter your password");
			String password = scan.nextLine();
			AccountManagment.login(name, password);
			menu2();
			break;
		case "register":
			System.out.println("Enter your name");
			name = scan.nextLine();
			System.out.println("Enter your password");
			password = scan.nextLine();
			AccountManagment.register(name, password);
			menu2();
			break;
		case "employee":
			System.out.println("Enter your name");
			String empName = scan.nextLine();
			System.out.println("Enter your password");

			String empPassword = scan.nextLine();
			AccountManagment.empLogin(empName, empPassword);
			
			
			menu3();
			break;
		case"admin":
			System.out.println("Enter your name");
			String adName=scan.nextLine();
			System.out.println("Enter your password");
			String adpassword=scan.nextLine();
			AccountManagment.adlogin(adName, adpassword);
			menu4();
			break;
		case "quit":
			startMenu();
			break;
		default:
			System.out.println("choose an option");
			startMenu();
		}

	}
	
	public static void menu2() {
		System.out.println("You are logged in!");
		

		
		if (Driver.curCustomer.getAccountEnabled()==0) {
			System.out.println("You want to apply for a account or quit");

			Scanner scan = new Scanner(System.in);
			String option2 = scan.nextLine();
			switch (option2) {
			case "apply":
				int apply = 1;
				int approved = 0;
				System.out.println("Enter your email");
				String email = scan.nextLine();
				System.out.println("Enter your address");
				String address = scan.nextLine();
				System.out.println("Enter your phone number");
				String phone = scan.nextLine();
				Driver.curCustomer.setEmail(email);
				Driver.curCustomer.setAddress(address);
				Driver.curCustomer.setPhoneNumber(phone);
				System.out.println("Your application as been receieved you must wait for your application to be approve");
//				AccountManagment.updateAccount();
//				IOMethods.writePendinFile();
//				IOMethods.writeCustomerFile();
				ConnectionMethods.applyForAccount(email, address, phone, apply, approved, Driver.curCustomer.getIdNum());
				startMenu();
				break;
			case "quit":
				System.out.println("Goodbye");
			default:System.out.println("What do you want to do?");
				startMenu();
				break;
			}

		} else {

			System.out.println("What would you like to do?  view balance, deposit, withdraw or quit");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			switch (choice) {
			case "deposit":
				System.out.println("Enter the amount ");
				Double amount = scan.nextDouble();
				//AccountManagment.deposit(amount);
				int cusId = Driver.curCustomer.getIdNum();
				ConnectionMethods.deposit(amount,  cusId);
				Menu.menu2();
				break;
			case "withdraw":
				System.out.println("Enter the amount ");
				Double amount1 = scan.nextDouble();
				//AccountManagment.withdraw(amount1);
				int custId = Driver.curCustomer.getIdNum();
				ConnectionMethods.withdraw(amount1, custId);
				Menu.menu2();
				break;
			case "view balance":
				//AccountManagment.viewCustBalance();
				int custI = Driver.curCustomer.getIdNum();
				ConnectionMethods.viewBalance(custI);
				System.out.println("Your current balance is: " + Driver.acctBalance);
				Menu.menu2();
				break;
			case "quit":
				ConnectionMethods.getCustomers();
				Menu.startMenu();
				break;
			default:
				System.out.println("Hey type correctly");
				Menu.menu2();
				break;
				
			}
		}
	}

	public static void menu3() {
		System.out.println("What would you like to do?");
		System.out.println("view customers or approve pending enter view or quit");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
		case "approve":
			
			ConnectionMethods.approveAccounts();
			AccountManagment.appoveAccounts();
			break;
		case "view":
			System.out.println("Enter Customer Name");
			String name = scan.nextLine();
			AccountManagment.viewCustAcc(name);
			break;
		case "quit":
			ConnectionMethods.getCustomers();
			startMenu();
			break;
		default:
			System.out.println("Whatup!");
		}
	}

	
	public static void menu4() {
		System.out.println("What would you like to do?");
		System.out.println("view, edit accounts or quit");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
				
		case "edit": System.out.println("Enter Customer Name");
			String name = scan.nextLine();
			AccountManagment.editCustAcc(name);
			break;
		case "view":
			System.out.println("Enter Customer Name");
			String name1 = scan.nextLine();
			AccountManagment.viewCustAccAd(name1);
			break;
		case "quit":
			ConnectionMethods.getCustomers();
			startMenu();
			break;
		default:
			System.out.println("Whatup!");
		}
	}
	
	public static void menu5() {
		System.out.println("What would you like to do, edit account, create account or delete account");
		System.out.println("Type edit, create or delete");
		Scanner scan = new Scanner(System.in);
		String editChoice = scan.nextLine();
	}
}
