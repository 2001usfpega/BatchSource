package com.revature.banking;

import java.util.Scanner;

public class MainDriver {
	private static Customer currCust;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loggedin = true;
		Admin admin = new Admin();
		while (loggedin) {
			System.out.println("Hello, how can we help you today? Enter 1 to create a new user account.\n"
					+ " Enter 2 to log in to existing account. Enter 3 to sign into admin account. Enter any other number to exit.");
			int input = Integer.parseInt(scan.nextLine());

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
			case 3:

				System.out.println("Please enter admin id number.");
				int username = Integer.parseInt(scan.nextLine());
				// scan.nextLine();
				System.out.println("Please enter admin password.");
				String password = scan.nextLine();
				if (!(admin.adminid == username || admin.password.equals(password))) {
					System.out.println("Invalid admin log in information");
				} else {
					adminMenu();
				}
				break;
			default:
				loggedin = false;
				break;

			}

		}
	}

	public static void userlogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
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
		System.out.println(
				"New user created. Thank you for choosing Revature Bank.\n\nWe'll now return you to the main menu.\n\n");
	}

	public static void customerTransaction() {
		Scanner scan = new Scanner(System.in);
		boolean loggedin = true;
		while (loggedin) {
			System.out.println(
					"What is it you would like to do today? Enter 1 to create open a new bank account. Enter 2 to deposit to an existing account. Enter 3 to withdraw from an existing account.\n"
							+ "Enter 4 to delete an account without a balance. Enter other number besides 1, 2, 3 or 4 to return to main menu.");
			int input = Integer.parseInt(scan.nextLine());
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

	public static void adminMenu() {

		Scanner scan = new Scanner(System.in);
		boolean loggedin = true;
		System.out.println("Hello Admin, press 1 to view an account. Press 2 to update user account. \n"
				+ "Press 3 to delete an account. Press any other key to return to main menu.");
		int input = Integer.parseInt(scan.nextLine());
		while (loggedin) {
			switch (input) {
			case 1:
				System.out.println("Please enter the username of the account you would like to view.");
				String a = scan.nextLine();
				Admin admin = new Admin();
				admin = DBCalls.getCustomerForAdmin(a);
				System.out.println("Customer id:" + admin.getCustomerid() + " Customer password: " + admin.getPword());
				System.out.println("Next we'll get the customer balance.");
				Account currAccount = DBCalls.getAccount(admin.getCustomerid());
				System.out.println("Here is the account ID: " + currAccount.getAccountid()
						+ " and here is the balance: " + currAccount.getBalance());
				break;

			case 2:
				System.out.println(
						"Please enter a 1 to create a new user. Enter a 2 to deposit to an account. Enter a 3 to withdraw from and account.\n"
								+ "Enter a 5 or greater to return to admin menu.  ");
				// System.out.println("Please select what what you would like to do. Enter 1 to
				// create an Account. "
				// + "\nEnter 2 to update an existing aaccount. Enter any other number to return
				// to return to admin menu options");
				int choice = Integer.parseInt(scan.nextLine());
				boolean inlogged = true;
				while (inlogged = true) {
					switch (choice) {
					case 1:
						System.out.println("Enter the username of the account you would like to create.");
						String username = scan.nextLine();
						System.out.println("Enter the password for the account you would like to create.");
						String password = scan.nextLine();
						Customer newCust = new Customer(1, username, password);
						DBCalls.insertCustomer(newCust);
						inlogged = false;
						break;
					case 2:
						System.out.println("Please enter the account ID to the account you would like to update.");
						int myInt = Integer.parseInt(scan.nextLine());
						System.out.println("Please enter the amount you would like to deposit.");
						double deposit = Double.parseDouble(scan.nextLine());
						DBCalls.adminDeposit(myInt, deposit);
						inlogged = false;
						break;
					case 3:
						System.out
								.println("Please enter the account id of the account you would like to withdraw from.");
						int acid = Integer.parseInt(scan.nextLine());
						System.out.println("Please enter the amount you would like to withdraw.");
						double withdrawal = Double.parseDouble(scan.nextLine());
						DBCalls.adminWithdrawal(acid, withdrawal);
						inlogged = false;
						break;
					default:
						inlogged = false;
						break;

					}
				}
			case 3:
				System.out.println("Please enter the customer ID of the account you would like to delete.");
				int cid = Integer.parseInt(scan.nextLine());
				DBCalls.adminDelete(cid);
				loggedin = false;
				break;
			default:
				loggedin = false;

			}
		}

	}

}
