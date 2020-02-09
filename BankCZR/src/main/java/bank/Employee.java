package bank;

import java.util.Scanner;

public class Employee {
	
	static String password = "p4ssw0rd"; 
	static String id = "employee";
	
	HashMaps getEmpMenu(HashMaps hashMaps) {
		boolean logout = false; 
		Scanner sc = new Scanner(System.in);
		while (logout == false) {
			System.out.println("   View All Accounts[1], View Account Info[2], View Customer Info[3]");
			System.out.println("         Approve Accounts[4], Deny Accounts[5],  Exit[6]");
			System.out.println(" Type available command:");
			String userInput = sc.nextLine();
			if (userInput.equals("1")) {
				empViewAllAcc(hashMaps);
			}else if(userInput.equals("2")) {
				empViewAcc(hashMaps);
			}else if(userInput.equals("3")) {
				empViewCust(hashMaps);	
			}else if(userInput.equals("4")) {
				hashMaps = empApproveAcc(hashMaps);	
			}else if(userInput.equals("5")) {
				hashMaps = empDenyAcc(hashMaps);	
			}else if(userInput.equals("6")) {
				logout = true;
				break; 
			}else {
				System.out.println(" Invalid input");
			}
		}
		return hashMaps; 
	}
	
	void empViewAllAcc(HashMaps hashMaps){
		System.out.println(" All Accounts");
		System.out.println(hashMaps.hashMapAcc); 
	}
	
	HashMaps empApproveAcc(HashMaps hashMaps){
		Scanner sc = new Scanner(System.in);
		System.out.println(" Account number to be approved?");
		String custAccNum = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println(" Account number not found.");
		}else {
			//updating account object
			System.out.println(" The account status was: " + hashMaps.hashMapAcc.get(custAccNum).status);
			hashMaps.hashMapAcc.get(custAccNum).status = "approved";
			System.out.println(" The account status is now: 'approved'");
		}
		return hashMaps; 
	}
	
	HashMaps empDenyAcc(HashMaps hashMaps){
		Scanner sc = new Scanner(System.in);
		System.out.println(" Account number to be denied?");
		String custAccNum = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println(" Account number not found.");
		}else {
			//updating account object
			System.out.println(" The account status was: " + hashMaps.hashMapAcc.get(custAccNum).status);
			hashMaps.hashMapAcc.get(custAccNum).status = "denied";
			System.out.println(" The account status is now: 'denied'");
		}
		return hashMaps; 
	}
	
	void empViewAcc(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Account number?");
		String custAcc = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAcc);
		if (accFound==false) {
			System.out.println(" Account number not found.");
		}else {
			Accounts acc = hashMaps.hashMapAcc.get(custAcc);
			Accounts.printAccInfo(acc);
		}
	}
	
	void empViewCust(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Customer ID?");
		String custId = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapCust.containsKey(custId);
		if (accFound==false) {
			System.out.println(" Customer ID number not found.");
		}else {
			Customers cust = hashMaps.hashMapCust.get(custId);
			Customers.printCustInfo(cust);
		}
	}	
	
	static void verifyEmployee() {
		boolean correct = false;
		Scanner sc = new Scanner(System.in);
		String id;
		while (correct == false) {
			System.out.println(" Account ID?");
			id = sc.nextLine();
			System.out.println(" Account Password?");
			String employeePswd = sc.nextLine();
			if (id.equals(Employee.id )&& employeePswd.equals(Employee.password)) {
				correct=true;
				break;
			}else {
				System.out.println(" Access denied. Please try again.");
			}
		}
		System.out.println(" Sign in success.");
	}

}