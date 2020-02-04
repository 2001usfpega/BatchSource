package com.bankThing;

import java.util.Scanner;

import com.bankThing.Dao.EmployeeDao;

public class BankThingMainDrive {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean flag;
		int num;
		EmployeeDao ed = new EmployeeDao();
		System.out.println(ed.selectAllEmployee());
		
		do {
			flag = true;
			num = 0;
			
			count(3);
			System.out.println("\n\n\n\nWelcome to use OnePiece bank service");
			System.out.println("\n");
			System.out.println("press 1 ~ for users");
			System.out.println("press 2 ~ for employees");
			System.out.println("press 0 ~ shut down the system");
			
			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			}
			
			switch (num) {
			case 1:
				System.out.println("you entered 1");
				CustomerMain customerMain = new CustomerMain();
				customerMain.customerMenu();
				
				break;
			case 2:
				System.out.println("u entered 2 ");
				EmployeeMain employeeMain = new EmployeeMain();
				employeeMain.employeeMenu();
				
				break;
			case 3:
				count(3);
				System.out.println("Please enter a valid number");
				break;
				
				
			case 0:
				flag = false;
				System.out.println("System shut down \n\n");
				break;
			}
		} while (flag);	
	}

	
	
	public static void count(int count) {

		for (int i = 0; i < count; i++) {

			try {
				Thread.sleep(200);
				System.out.print(" .");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	}
}
