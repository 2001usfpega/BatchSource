package com.bank.service;

import java.util.Scanner;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.interfaces.BankDao;
import com.bankdao.interfaces.impl.*;


public class Menu {
 static   BankService bankser=new BankServiceImpl();
 static BankDao myDao=new BankDaoImpl();
 public static  Customer customer=new Customer();

 
 static String user_name;
 static String user_pass;

 public static int current_id;
	public static void startMenu() {

		System.out.println("Wellcome to our banking app!");
		System.out.println("If you are a customer type login if not type register");

		System.out.println("If you're an administrator  admin");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();

		switch (option) {
		case "login":
			System.out.println("Enter your name");
			String name= scan.nextLine();
			System.out.println("Enter your password");
			String pass = scan.nextLine();
			System.out.println(current_id);
			//bankser.getAccount(current_id);
			bankser.custLogin(name, pass);
			System.out.println(current_id);
			
			menu3();
			break;
		case "register":
			System.out.println("Enter your name");
			String names = scan.nextLine();
			System.out.println("Enter your password");
			String password = scan.nextLine();
			bankser.customerRegister(names, password);
			
			System.out.println(current_id);
			bankser.getAccount(current_id);
			System.out.println("your are register");
			//startMenu();
			menu2();
			break;
		
		case"admin":
			System.out.println("Enter your name");
			String adName=scan.nextLine();
			System.out.println("Enter your password");
			String adpassword=scan.nextLine();
			//AccountManagment.adlogin(adName, adpassword);
			//menu4();
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
		
		
		 
			System.out.println("You want to apply for a account or quit");

			Scanner scan = new Scanner(System.in);
			String option2 = scan.nextLine();
			switch (option2) {
			case "apply":
				  Account account=new Account();
				System.out.println("Enter again your name  please ");
                String name=scan.nextLine();
                System.out.println("And your password");
                String pass=scan.nextLine();
				System.out.println("Enter your email");
				String email = scan.nextLine();
				System.out.println("Enter your address");
				String address = scan.nextLine();
				System.out.println("Enter your phone number");
				String phone=scan.nextLine();
				System.out.println();
				bankser.customerAplication(name, email, address, phone, pass);
				System.out.println("Your applications has been receive and aprove your account number is"+current_id);
				menu3();
				

						break;
				
				default:
					System.out.println("Hey type correctly");
					break;
				}
			}
	
			
		
	public static void menu3() {
		
		System.out.println("What would you like to do?  view balance, deposit , withdraw, or quit");
	Scanner	 scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
		case "deposit":
			System.out.println("Enter the amount ");
			int amount = scan.nextInt();
			bankser.deposit(current_id, amount);
            menu3();
			break;
		case "withdraw":
			System.out.println("Enter the amount ");
			int amount1 = scan.nextInt();
			//AccountManagment.withdraw(amount1);

			break;
		case "view balance":
			System.out.println(current_id);
		bankser.viewAcoount(current_id);
            menu3();
            
			break;
		case "quit":
			System.out.println("byeee");
			startMenu();
			break;
			default:
				System.out.println("type again ");
				
				break;
		
	}		
			
	}
}


			
			
				
				
				
			
			
				
			
	    

		

		/*	System.out.println("What would you like to do?  view balance, deposit or withdraw");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			switch (choice) {
			case "deposit":
				System.out.println("Enter the amount ");
				Double amount = scan.nextDouble();
				

				break;
			case "withdraw":
				System.out.println("Enter the amount ");
				Double amount1 = scan.nextDouble();
				

				break;
			case "view balance":
				

				break;
			default:
				System.out.println("Hey type correctly");
				break;
			}
		}
	

	/*public static void menu3() {
		System.out.println("What would you like to do?");
		System.out.println("view customers or approve pending enter view or quit");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
		case "approve":
			AccountManagment.appoveAccounts();
			break;
		case "view":
			System.out.println("Enter Customer Name");
			String name = scan.nextLine();
			AccountManagment.viewCustAcc(name);
			break;
		case "quit":
			startMenu();
			break;
		default:
			System.out.println("Whatup!");
		}
	}

	
	public static void menu4() {
		System.out.println("What would you like to do?");
		System.out.println(" view , edit  accounts or quit");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
		case "edit":
			break;
		case "view":
			System.out.println("Enter Customer Name");
			String name = scan.nextLine();
			AccountManagment.viewCustAccAd(name);
			break;
		
			
		case "quit":
			startMenu();
			break;
		default:
			System.out.println("Whatup!");
		}
	}*/
	

