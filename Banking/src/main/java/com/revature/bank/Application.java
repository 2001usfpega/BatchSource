package com.revature.bank;

import java.util.*;

public class Application {

	public static void main(String[] args) {

		Scanner c = new Scanner(System.in);
		int select = c.nextInt();

		do {
			// display menu to user
			// ask user for his choice and validate it (make sure it is between 1 and 6)
			System.out.println("Where Would You like To Be ?");
			System.out.println("1) Customer");
			System.out.println("2) Employee");
			System.out.println("3) Administrator");
			System.out.println("4) None");
			System.out.println();
			System.out.print("Enter choice [1-4]: ");
			select = c.nextInt();
			switch (select) {
			case 1:
				System.out.println("Enter a customer name");

				break;
			case 2:
				System.out.println("Enter a account number");
				break;
			case 3:
				System.out.println("Enter a account number");
				break;
			case 4:
				System.exit(0);
				break;
			}
		} while (select >= '5');

	}

}
