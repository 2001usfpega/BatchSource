package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewBankAppSwitch {

	public static void showCustomerMenu() {

		char option = '\0';
		int choice = 0;

		Scanner scanner = new Scanner(System.in);

		do {

			Employee employee = new Employee();
			Customer customer = new Customer();

			System.out.println("Welcome to the Bank of Revature.");
			System.out.println("Please choose from one of the following options:");
			System.out.println("A. I am a customer");
			System.out.println("B. I am an employee");
			System.out.println("C. Exit");

			try {
				option = scanner.nextLine().charAt(0);
			} catch (InputMismatchException e) {
			} catch (StringIndexOutOfBoundsException e) {
			}

			switch (option) {

			case 'A':

				System.out.println("Please enter a Customer ID");
				int custAccntID = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please enter a Customer User Name");
				String custName = scanner.nextLine();
				System.out.println("Please enter a password");
				String custPwrd = scanner.nextLine();
				customer.customerLogin(custAccntID, custName, custPwrd);
				do {
					System.out.println("Hello, customer!! What a fine day at Revature Bank!");
					System.out.println("How can we serve you today?:");
					System.out.println("1. Retrieve my Account information");
					System.out.println("2. Get current balance");
					System.out.println("3. Make a deposit");
					System.out.println("4. Make a withdrawal");
					System.out.println("5. Transfer between accounts");
					System.out.println("6. Exit to the Main Menu");

					try {
						choice = scanner.nextInt();
					} catch (InputMismatchException e) {
					}
					scanner.nextLine();

					switch (choice) {

					case 1:
						System.out.println("Enter your account ID");
						int acctID = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Your account information is: ");
						customer.getAccount(acctID);
						break;

					case 2:
						System.out.println("Enter your account ID");
						int balID = scanner.nextInt();
						scanner.nextLine();
						customer.getBalance(balID);
						break;

					case 3:
						System.out.println("Enter an account ID to make a deposit");
						int acctid = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter a deposit amount");
						int deposit = scanner.nextInt();
						scanner.nextLine();
						customer.deposit(acctid, deposit);
						break;

					case 4:
						System.out.println("Enter an account ID to make a withdrawal");
						int accntID = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter an amount to withdraw");
						int withdraw = scanner.nextInt();
						scanner.nextLine();
						customer.withdraw(accntID, withdraw);
						break;

					case 5:
						System.out.println("Enter an account ID to make the deposit");
						int txfrAccntID = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter an account ID from which to withdraw");
						int txfrAccntID2 = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Select an amount to transfer");
						int txfr = scanner.nextInt();
						scanner.nextLine();
						customer.makeTransfer(txfrAccntID, txfrAccntID2, txfr);
						break;

					case 6:
						System.out.println("Thank you for choosing Revature Bank for your banking needs");
						break;
					default:
						System.out.println("Please make a valid choice");
						break;
					}
				} while (choice != 6);
				break;
			case 'B':
				System.out.println("Please enter an Employee ID");
				int empAccntID = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please enter an Employee12 User Name");
				String empName = scanner.nextLine();
				System.out.println("Please enter a password");
				String empPwrd = scanner.nextLine();
				employee.employeeLogin(empAccntID, empName, empPwrd);
				do {
					System.out.println("Welcome, Employee!  It is a wonderful day at Revature Bank!");
					System.out.println("Plese select from the following to perform your work tasks:");
					System.out.println("Select 1 to get a list of all accounts");
					System.out.println("Select 2 to create a new account");
					System.out.println("Select 3 to delete an old account");
					System.out.println("Select 4 to create a new customer");
					System.out.println("Select 5 to see a list of current customers");
					System.out.println("Select 6 to get a list of all employees");
					System.out.println("Select 7 to create a new employee entry");
					System.out.println("Select 8 to get a balance on an account");
					System.out.println("Select 9 to make a deposit");
					System.out.println("Select 10 to make a withdrawal");
					System.out.println("Select 11 to make a transfer");
					System.out.println("Select 12 to exit employee portal");

					try {
						choice = scanner.nextInt();
					} catch (InputMismatchException e) {
					}
					scanner.nextLine();

					switch (choice) {

					case 1:
						System.out.println("Enter the number 1");
						int newAcctID = scanner.nextInt();
						scanner.nextLine();
						System.out.print("The list of accounts at Revature Bank: ");
						employee.getAccount(newAcctID);
						break;
					case 2:
						System.out.println("Enter an Account Name");
						String newAccntName = scanner.nextLine();
						System.out.println("Enter a 12 digit account number");
						long newAccntNum = scanner.nextLong();
						scanner.nextLine();
						System.out.println("Enter a beginning balance");
						int openBalance = scanner.nextInt();
						scanner.nextLine();
						employee.insertAccount(newAccntName, newAccntNum, openBalance);
						break;
					case 3:
						System.out.println("Enter an Acct ID to delete");
						int delAccnt = scanner.nextInt();
						scanner.nextLine();
						employee.deleteAccnt(delAccnt);
						break;
					case 4:
						System.out.println("Enter a UserName");
						String custUName = scanner.nextLine();
						System.out.println("Enter a numerical password");
						int custPassWord = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter the employee's first name");
						String custFName = scanner.nextLine();
						System.out.println("Enter the employee's last name");
						String custLName = scanner.nextLine();
						employee.createCustomer(custUName, custPassWord, custFName, custLName);
						break;
					case 5:
						employee.getCustomer();
						break;
					case 6:
						employee.getEmployee();
						break;
					case 7:
						System.out.println("Enter a UserName");
						String empUName = scanner.nextLine();
						System.out.println("Enter a numerical password");
						int empPassWord = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter the employee's first name");
						String empFName = scanner.nextLine();
						System.out.println("Enter the employee's last name");
						String empLName = scanner.nextLine();
						employee.insertEmp(empUName, empPassWord, empFName, empLName);
						break;
					case 8:
						System.out.println("Enter an account ID from which to retrieve the balance");
						int custBal = scanner.nextInt();
						scanner.nextLine();
						customer.getBalance(custBal);
						break;
					case 9:
						System.out.println("Enter an account ID to make a deposit");
						int custAcctID = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Ener a deposit amount");
						int custDeposit = scanner.nextInt();
						scanner.nextLine();
						customer.deposit(custAcctID, custDeposit);
						break;
					case 10:
						System.out.println("Enter an accout ID to make a withdrawal");
						int custAccnt = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter an amount to withdraw");
						int custWithdraw = scanner.nextInt();
						scanner.nextLine();
						customer.withdraw(custAccnt, custWithdraw);
						break;
					case 11:
						System.out.println("Enter an accout ID to make the deposit.");
						int custTxfrAccntID = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter an account ID from which to withdraw");
						int custTxfrAccntID2 = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Select an amount to transfer");
						int custTxfr = scanner.nextInt();
						scanner.nextLine();
						customer.makeTransfer(custTxfrAccntID, custTxfrAccntID2, custTxfr);
						break;
					case 12:
						System.out.println("Please stay productive during working hours");
						break;
					default:
						System.out.println("Please make a valid choice");
						break;
					}
				} while (choice != 12);
			case 'C':
				System.out.println("Thank you for banking at the Bank of Revature.  See you soon!!");
				break;
			default:
				System.out.println("Invalid choice; Please enter again.");
				break;
			}
		} while (option != 'C');
	}
}
