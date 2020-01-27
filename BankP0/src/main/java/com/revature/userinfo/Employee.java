package com.revature.userinfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.accounts.*;
import com.revature.bankutil.BankUtil;

public class Employee extends User{
	
	private boolean isAdmin;
	
	//serial ID
	private static final long serialVersionUID = 2L;
	private static Scanner scan = new Scanner(System.in);

	//private static ArrayList<Account> accountList = new ArrayList<Account>();


	public Employee(String name, String pw, String fName, String sName){
		super(name, pw, fName, sName);
		userID = "E" + userID;
		BankUtil.saveAll();
	}
	
	public Employee(String name, String pw, String fName, String sName,boolean isAdmin){
		super(name, pw, fName, sName);
		this.isAdmin=isAdmin;
		if(isAdmin) {
			userID = "A" + userID;
		}
		else {
			userID = "E" + userID;
		}
		BankUtil.saveAll();
	}
	
	
	@Override
	public void displayOptions() {
		System.out.println("you are logged in as a customer");	
	}
	
//	public static void addNewAccount(Account newAccount) {
//		//accountList.add(newAccount);
//		
//	}
	
	//Approve for a user become customer
//	public void accApprove(Customer newCust) {	
//		newCust.setApprove(true);
//	}
	
	
	//Add a new account for customer
	public void accAdd(Customer customer,String type) {
		Account account = new Account(type,0.0);
		customer.addAccount(account);
		BankUtil.saveAll();
	}
	
	//Searching for customer
//	public Customer getCust(ArrayList<Customer> custList, String custID) {
//		for (Customer customer : custList) {
//			if (customer.getUserID().equals(custID)) {
//				return customer;
//			}
//		}
//		return null;
//	}
	
	public void viewCustInfo() {
		
		ArrayList<Customer> custList = Customer.getCustList();
		for (Customer customer : custList) {
			System.out.println(customer.toString());;
		}
	}
	

	
//	public ArrayList<Customer> searchCustName(String custName){
//		ArrayList<Customer> custList = Customer.getCustList();
//		ArrayList<Customer> returnList = new ArrayList<>();
//		for (Customer customer : custList) {
//			if (.equals(custID)) {
//				return customer;
//			}
//		}
//		return null;
//	}
	
	@Override
	public void userActions() {
		//Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("1 View All Customers Information");
			System.out.println("2 Search for Customer with ID");
			System.out.println("3 Search by First Name");
			System.out.println("4 Approve new customer");
			if(isAdmin) {
				System.out.println("5 Admin View");
			}
			
			System.out.println("B Back");


			switch (scan.nextLine()) {
			//View all Customer Information
			case "1":
				ArrayList<Customer> custList = Customer.getCustList();
				System.out.println("The information of all customer:");

				for (Customer customer : custList) {
					System.out.println(customer.toString());
				}
				break;
			//Search Customer
			case "2":
				System.out.println("Please enter the customer ID:");
				String custID = scan.nextLine();
				//System.out.println("Start looking for :" + custID);
				Customer customer = Customer.searchCust(custID);
				if (customer!=null) {
					System.out.println(customer.toString());
				}else {
					System.out.println("Cannot find customer");
				}
				break;
			// Search by First Name
			case "3":
				System.out.println("Please enter the customer name to search:");
				String custName = scan.nextLine();
				ArrayList<Customer> resList = Customer.searchCustFName(custName);
				if (resList.size()!=0) {
					System.out.println("The result is");
					for (Customer customer2 : resList) {
						System.out.println(customer2.toString());
					}
				}else {
					System.out.println("Cannot find customer");
				}
				break;
				
			case "4":
				System.out.println("Approving process:");

				ArrayList<Customer> newCust = Customer.getNewCustList();
				for (Customer cust : newCust) {
					System.out.println("Do you want to approve for customer(Y/N):   Customer ID: "
							+cust.getUserID()+"   Customer Name: "+cust.getFName() +" "+cust.getSName());
					
					String approve = scan.nextLine();
					if (approve.equals("Y")||approve.equals("y")) {
						cust.setApprove(true);
						
						//add first account to customer
						if(cust.getCustAccount().size()==0) {
							cust.addAccount(new Account("A",0.0));
						}
						System.out.println("Approved");
					}
				}
				break;
			case "b":
			case "B":
				return;
			case "5":
				if(isAdmin) {
					doAdminStuff();
					break;
				}//else       V
			default:
				System.out.println("Not an option!\n");
			}
		} while (true);
	}
	
	//admin functions
	private void doAdminStuff() {
		do {

			System.out.println("\nChoose a user to view / edit");
			ArrayList<User> list = User.getUserList();
			//show all users
			BankUtil.printArrayListN(list);
			System.out.println("Z Edit Accounts");
			System.out.println("B Back");
	
			String next = scan.nextLine().toUpperCase();
			if(next.equals("B")) {
				return;
			}
			else if (next.equals("Z")) {
				Customer.doTransAct(Account.getAccountList());
			}
			
			User curAcc = null;
			int index = BankUtil.intGreaterThanZero(next)-1;
			//do i have this many users
			if (index >= 0 && index < list.size()) {
				curAcc = list.get(index);
				editAccount(curAcc);
			} else {
				System.out.println("Not an option!");
			}
		}while(true);
	}
	
	private void editAccount(User uu) {
		do {
			System.out.println();
			System.out.println(uu.toString());
			System.out.println("What would you like to change");
			System.out.println("1 Username");
			System.out.println("2 Password");
			System.out.println("3 First Name");
			System.out.println("4 Last Name");
			boolean isCust =uu instanceof Customer;
			if(isCust) {
				System.out.println("5 Deactivate Account");
			}
			System.out.println("B Back");
			
			String s;
		
			switch(scan.nextLine()) {
			//username
			case "1":
				System.out.print("Enter the new username: ");
				 s=scan.nextLine();
				if(!checkUsername(s)) {
					uu.setName(s);
					System.out.println("Username changed to: "+s);
				}
				else {
					System.out.println("Username already in use");
				}
				break;
			//password
			case"2":
				System.out.print("Enter the new password: ");
				s=scan.nextLine();
				uu.setPassword(s);
				System.out.println("New password set");
				break;
			//first
			case"3":
				System.out.print("Enter the new first name: ");
				s=scan.nextLine();
				uu.setFName(s);
				System.out.println("First name is now: "+s);
				break;
			//last
			case"4":
				System.out.print("Enter the new last name: ");
				s=scan.nextLine();
				uu.setSName(s);
				System.out.println("Last name is now: "+s);
				break;
			case"b":
			case"B":
				return;
			case"5":
				if(isCust) {
					((Customer)uu).setApprove(false);
					System.out.println("Unapproved");
					break;
				}//else       V
			default:
				System.out.println("Not an option!\n");					
			}
		} while(true);
	}
	
	@Override
	public String toString() {
		if(isAdmin) {
			return "ADMIN   :   " + super.toString();
		}else {
			return "EMPLOYEE:   " + super.toString();
		}
	}
	
}
