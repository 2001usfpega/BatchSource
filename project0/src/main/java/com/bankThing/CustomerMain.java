package com.bankThing;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankThing.Dao.CustomerDao;

public class CustomerMain {
	public static Scanner scan = new Scanner(System.in);

	
	public void customerMenu() {
		boolean flag;
		int num;

		
		do {
			flag = true;
			System.out.println("\n\n\nWelcome to the customer menu:\n");
			System.out.println("press 1 ~ to log in");
			System.out.println("press 2 ~ to register");
			System.out.println("press 0 ~ get back to main page");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			} catch (InputMismatchException a) {
				a.printStackTrace();
				num = 3;
			}

			if (2 < num || num < 0) {
				num = 3;
			}

			switch (num) {

			case 1:
				System.out.println("log in");
				break;
			case 2:
				System.out.println("customer register");
				customerRegister();
				break;
			case 3:
				System.out.println("Please choose a valid number");
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
	
	public static void customerRegister() {
		boolean flag;
		String firstTemp, lastTemp, pwTemp1, pwTemp2;
		int indecater = 0;

		do {
			flag = true;

			System.out.println("first name?");
			firstTemp = scan.nextLine();
			System.out.println("last name?:");
			lastTemp = scan.nextLine();
			System.out.println("please enter your password:");
			pwTemp1 = scan.nextLine();
			System.out.println("please confirm your password:");
			pwTemp2 = scan.nextLine();

			if (!pwTemp1.contentEquals(pwTemp2)) {
				System.out.println("your pass doesn't match~ ");
				continue;
			}


			CustomerDao customerDao = new CustomerDao();
			indecater = customerDao.insertCustomer(firstTemp, lastTemp, pwTemp1);
			flag = false;
		} while (flag);

		if (indecater == 1) {
			System.out.println("Customer account created.");

		} else {
			System.out.println("Customer account entered is not correct");
		}
	}
	
	
	
}
