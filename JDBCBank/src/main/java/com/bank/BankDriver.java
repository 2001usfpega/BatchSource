package com.bank;

import java.util.Scanner;

import com.bank.user.Customer;
import com.bank.user.User;

public class BankDriver {
	private static Scanner scan=BankUtil.getScanner();

	public static void main(String[] args) {
		boolean isContinue = true;	
		User currentUser = null;
				
		//one of these
		//BankUtil.loadAll();
		//BankUtil.createTestCases();
		
		System.out.println("Thank you for choosing Awesome Bank!");
		System.out.println("How may we help you today?");
		
		do {
			
			//not logged in
			if(currentUser==null) {
				System.out.println();
				System.out.println("1 Login");
				System.out.println("2 Create New User");
				System.out.println("Q Quit");


				//System.out.println(currentUser);
				switch(scan.nextLine()) {
				
				//login
				case "1":
					System.out.println();
					System.out.print("Enter your user name: ");
					String myName = scan.nextLine();
					System.out.print("Enter your password: ");
					currentUser=User.getUser(myName,scan.nextLine());
					if(currentUser==null) {
						System.out.println("Username or password were incorrect");
					}
					break;
					
				//create new user
				case "2":
					//keep trying till customer is created
					do {
						System.out.println();
						System.out.print("Enter your desired username: ");
						String newUserName = scan.nextLine();
						
						//check if name is taken
						if(User.checkUsername(newUserName)) {
							System.out.println("This name is already in use\n");
							break;
						}
						System.out.print("Enter your desired password: ");
						String newPW = scan.nextLine();
						System.out.print("Retype your password: ");

						//same password twice
						if(newPW.equals(scan.nextLine())) {
							System.out.print("Enter your first name: ");
							String newFName=scan.nextLine();
							System.out.print("Enter your last name: ");
							String newSName=scan.nextLine();
							Customer.createNewCustomer(newUserName,newPW,newFName,newSName);
							break;
						}
						else {
							System.out.println("passwords didn't match");
						}
						
						
					}while(true);
					break;
				case "Q":
				case "q":
					isContinue=false;
					break;
				default:
					System.out.println("Not an option!\n");
				}
				
			}
			else {
				currentUser.userActions();
				currentUser=null;
			}
		}while(isContinue);
		
//
//		System.out.println("\nCurrent Users");
//		for(User u: User.getUserList()) {
//			System.out.println(u.toString());
//		}
//		
//		System.out.println("\nCurrent Accounts");
//		BankUtil.printArrayList(Account.getAccountList());
//		
		System.out.println("Good bye!");
		//BankUtil.saveAll();
		scan.close();

	}//main
}

