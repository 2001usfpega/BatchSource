package com.revature.banking;

import java.util.Scanner;

public class MainDriver {
	private static Customer currCust;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loggedin = true;
		Admin admin = new Admin();
		while (loggedin) {
			System.out.println(
					"Hello, how can we help you today? Enter 1 to create a new user account.\n"
					+ " Enter 2 to log in to existing account. Enter any other number to exit.");
			int input = scan.nextInt();
			switch (input) {
			case 1:

				createUser();

				break;
			case 2:
				userlogin();
				if (currCust != null) {
					customerTransaction();
				}
				break;
//			case 3:
//				int username;
//				String password;
//				System.out.println("Please enter admin id.");
//				username = scan.nextInt();
//				System.out.println("Please enter admin password.");
//				password = scan.nextLine();
//				if(!(admin.adminid ==username && admin.password.equals(password))) {
//					System.out.println("Invalid admin log in information");
//				}
//				adminMenu();
//				break;
			default:
				loggedin = false;
				break;

			}

		}
	}

	public static void userlogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name");
		String username = scan.nextLine();
		currCust = DBCalls.getCustomer(username);
		System.out.println("Enter your password");
		String password = scan.nextLine();
		if (!currCust.getPword().equals(password)) {
			currCust = null;
			System.out.println("Invalid username or password");
		} else {
			System.out.println("Cuurently logged in");
			// System.out.println(currCust.getCustomerid());
		}

	}

	public static void createUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name");
		String username = scan.nextLine();
		System.out.println("Enter your password");
		String password = scan.nextLine();
		Customer newCust = new Customer(1, username, password);
		DBCalls.insertCustomer(newCust);
		System.out.println("Congratulations new user. Thank you for choosing Revature Bank.\n\nWe'll now return you to the main menu.\n\n");
	}

	public static void customerTransaction() {
		Scanner scan = new Scanner(System.in);
		boolean loggedin = true;
		while (loggedin) {
			System.out.println(
					"What is it you would like to do today? Enter 1 to create a new account. Enter 2 to deposit to an existing account. Enter 3 to withdraw from an existing account.\n"
					+ "Enter 4 to delete an account without a balance. Enter other number besides 1, 2, 3 or 4 to return to main menu.");
			int input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println(
						"To create an account you must have an initial deposit. How much would you like to initially deposit.");
				double initialDeposit = scan.nextDouble();
				DBCalls.createAccount(currCust, initialDeposit);
				break;
			case 2:
				System.out.println("Please enter the amount you would like to deposit");
				double deposit = scan.nextDouble();
				DBCalls.depositToAccount(currCust, deposit);
				break;
			case 3:
					System.out.println("Please enter the amount you would like to withdraw");
					double withdrawal = scan.nextDouble();
					DBCalls.withdrawFromAccount(currCust, withdrawal);
			case 4:
				DBCalls.deleteAccount(currCust);
				break;
				
			default:
				loggedin = false;
				break;
			}
		}
	}
//	public static void adminMenu() {
//		Scanner scan = new Scanner();
//		boolean loggedin =true;
//		Admin admin = new Admin();
//		System.out.println("Hello Admin, press 1 to view an account. Press 2 to update user account. \n"
//				+ "Press 3 to delete an account. Press any other key to return to main menu.");
//		int input = scan.nextInt();
//		switch(input) {
//		
//		case 1:
//			System.out.println("Please enter the username of the account you would like to view.");
//			String a = scan.nextLine();
//			admin =DBCalls.getCustomerForAdmin(a);
//			System.out.println("Customer id:"+admin.getCustomerid()+" Customer password: "+admin.getPword()+);
//		
//		
//		
//		}
////		
//		
//	}

}
