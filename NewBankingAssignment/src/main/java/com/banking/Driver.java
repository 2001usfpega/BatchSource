package com.banking;

import java.util.Scanner;

import com.banking.Account;
import com.banking.Customer;
import com.banking.Employee;

public class Driver {

	public static void main(String[] args) {

		Scanner verificationScanner = new Scanner(System.in);
		Scanner loginScanner = new Scanner(System.in);

		System.out.println("==========\nWelcome to the Bank of Rob!!!\n==========\nEnter 1 to Create New Account:\nEnter 2 for Login:");
		int login = loginScanner.nextInt();

		switch (login) {

		case 1:
			Customer customer = new Customer();
			customer.createCustomer();
			break;
		case 2:
			System.out.println("==========\nWelcome to the Bank of Rob!!!\\n==========\\nEnter 1 for CUSTOMER\nEnter 2 for EMPLOYEE ");
			int verification = verificationScanner.nextInt();

			switch (verification) {

			case 1:

			{

				Scanner cusScanner = new Scanner(System.in);

				System.out.println("==========\\nWelcome to the Bank of Rob!!!\\n==========\\nEnter 1 for Withdrawl:\nEnter 2 for Deposit:\nEnter 3 to Check Balance:");
				int cusscan = cusScanner.nextInt();

				switch (cusscan) {

				case 1:
					Customer a = new Customer();
					a.withdraw(cusscan);
					break;

				case 2:
					Customer b = new Customer();
					b.deposit(cusscan);
					break;

				case 3:
					Customer c = new Customer();
					c.getBalance();
					break;

				}
			}

				break;

			case 2:

			{

				Scanner empScanner = new Scanner(System.in);

				System.out.println("==========\\nWelcome to the Bank of Rob!!!\\n==========\\nEnter 1 to View Customer Accounts");
				int empscan = empScanner.nextInt();

				switch (empscan) {

				case 1:
					Employee e = new Employee();
					e.verifyEmployee();
					e.viewAccount();
					break;

				}
			}

			}

		}

	}
}