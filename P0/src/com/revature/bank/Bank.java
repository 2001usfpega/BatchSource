package com.revature.bank;

import java.io.IOException;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		boolean isContinue = true;
		boolean hasUser = false;
		Scanner scan = new Scanner(System.in);
				
		User currentUser = null;
		
		do {
			
			if(currentUser==null) {
				System.out.println("1 Login");
				System.out.println("2 Create New User");
				System.out.println("Q Quit");
				String selection = scan.next();
				switch(selection) {
				case "1":
					
					System.out.print("Enter your user name: ");
					String myName = scan.next();
					System.out.print("Enter your password: ");
					String myPW = scan.next();
					
					currentUser=User.getUser(myName, myPW);
					
					break;
				case "2":
					
					System.out.print("Enter your desired user name: ");
					String newName = scan.next();
					System.out.print("Enter your desired password: ");
					String newPW = scan.next();
					System.out.print("Retype your password: ");
					String newPW2 = scan.next();
					if(newPW.equals(newPW2)) {
						currentUser=new Customer(newName,newPW);
					}
					else {
						System.out.println("passwords didn't match");
					}
					
				break;
				case "Q":
				case "q":
					isContinue=false;
				default:
					System.out.println("Not an option!");
				}
				
			}
			else {
				currentUser.displayOptions();
			}
			
			
		}while(isContinue);
		
		//saveAll();

	}

}
