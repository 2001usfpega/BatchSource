package com.bankThing;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankThing.Dao.EmployeeDao;

public class EmployeeMain {
	public static Scanner scan = new Scanner(System.in);




	public void employeeMenu() {
		boolean flag;
		int num;


		do {
			num = 0;
			flag = true;
			count(3);
			System.out.println("\n\n\n\n\nWelcome to the Employee menu:\n");
			System.out.println("press 1 ~ to login");
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
				empLogIn();
				break;
			case 2:
				System.out.println("employee register");
				empRegister();
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



	public static void empRegister() {
		boolean flag, yesOrNo;
		String firstTemp, lastTemp, pwTemp1, pwTemp2, blTemp;
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


			System.out.println("Is this a admin account ?    (Y/N)");
			blTemp = scan.nextLine();

			if (blTemp.toUpperCase().contentEquals("YES") || blTemp.toUpperCase().contentEquals("Y")) {
				yesOrNo = true;
			} else {
				yesOrNo = false;
			}

			if (!pwTemp1.contentEquals(pwTemp2)) {
				System.out.println("your pass doesn't match~ ");
				continue;
			}

			//			String str = "sdffvbhkbfkhabflhbvafv";
			//			byte[] Blob = str.getBytes();
			//			String s = new String (b);


			EmployeeDao employeeDao = new EmployeeDao();
			indecater = employeeDao.insertEmployee(  new Employee(firstTemp, lastTemp, pwTemp1, yesOrNo)  );
			flag = false;
		} while (flag);

		if (indecater == 1) {
			System.out.println("Employee account created.");

		} else {
			System.out.println("Employee accunt entered is not correct");
		}
	}


	public static void empLogIn(){
		Employee employee1 = new Employee();
		boolean flag;
		long id_in;
		String pw_in;
		int indecater = 0;

		do {
			flag = true;
			System.out.println("please enter your employee id");
			try {
				id_in = Long.parseLong(scan.nextLine());
			} catch (NumberFormatException ex) {
				id_in = 1;
			}
	
			EmployeeDao ed = new EmployeeDao();
			employee1 = ed.selectEmployeeById(id_in);
		} while (false);
		
		
		do {
			flag = true;
			System.out.println("please enter your password");
			try {
				pw_in = scan.nextLine();
			} catch (NumberFormatException ex) {
				pw_in = "";
			}
			if (employee1.getEmp_pw().contains(pw_in) ) {
				flag = false;
				if (employee1.isAdmin()) {
					System.out.println("to admin");
				} else {
					System.out.println("to employee");
				}
				
			} else {
				
				System.out.println("pass word not correct");
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
