package com.bank.user;

import java.util.List;

import com.bank.BankUtil;

public class Employee extends User{
	private boolean isAdmin;

	public Employee(int id,String uname, String pw, String fName, String sName,boolean isAdmin){
		super(id,uname, pw, fName, sName);
		this.isAdmin=isAdmin;
	}
	
	
	public void viewCustInfo() {
		
		List<Customer> custList =customerDao.selectAllCustomers();
		for (Customer customer : custList) {
			System.out.println(customer.toString());;
		}
	}
	
	@Override
	public void userActions() {
		do {
			System.out.println();
			System.out.println("1 View All Customers Information");
//			System.out.println("2 Search for Customer with ID");
//			System.out.println("3 Search by First Name");
//			System.out.println("4 Approve new customer");
			if(isAdmin) {
				System.out.println("5 Admin View");
			}
			
			System.out.println("B Back");


			switch (scan.nextLine()) {
			//View all Customer Information
			case "1":

				List<Customer> custList=customerDao.selectAllCustomers();
				System.out.println("The information of all customer:");

				for (Customer customer : custList) {
					System.out.println(customer.toString());
				}
				break;
			//Search Customer
//			case "2":
//				System.out.println("Please enter the customer ID:");
//				String custID = scan.nextLine();
//				//System.out.println("Start looking for :" + custID);
//				//////////////////////////////////////////////////////////////////////////server
//				Customer customer = Customer.searchCust(custID);
//				if (customer!=null) {
//					System.out.println(customer.toString());
//				}else {
//					System.out.println("Cannot find customer");
//				}
//				break;
			// Search by First Name
//			case "3":
//				System.out.println("Please enter the customer name to search:");
//				String custName = scan.nextLine();
//				List<Customer> resList = Customer.searchCustFName(custName);
//				//////////////////////////////////////////////////////////////////////////server
//				if (resList.size()!=0) {
//					System.out.println("The result is");
//					for (Customer customer2 : resList) {
//						System.out.println(customer2.toString());
//					}
//				}else {
//					System.out.println("Cannot find customer");
//				}
//				break;
				
//			case "4":
//				System.out.println("Approving process:");
//
//				List<Customer> newCust = Customer.getNewCustList();
//				for (Customer cust : newCust) {
//					System.out.println("Do you want to approve for customer(Y/N):   Customer ID: "
//							+cust.getUserID()+"   Customer Name: "+cust.getFName() +" "+cust.getSName());
//					
//					String approve = scan.nextLine();
//					if (approve.equals("Y")||approve.equals("y")) {
//						cust.setApprove(true);
//						
//						//add first account to customer
//						if(cust.getCustAccount().size()==0) {
//							cust.addAccount(new Account("A",0.0));
//						}
//						System.out.println("Approved");
//					}
//				}
//				break;
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
			List<User> list = User.getUserList();
			//show all users
			BankUtil.printArrayListN(list);
			System.out.println("Z Edit Accounts");
			System.out.println("B Back");
	
			String next = scan.nextLine().toUpperCase();
			//System.out.println(next);
			if(next.equals("B")) {
				//System.out.println("why");
				return;
			}
			else if (next.equals("Z")) {
				Customer.doTransAct(accountDao.selectAllAccounts());
				continue;
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
//			boolean isCust =uu instanceof Customer;
//			if(isCust) {
				System.out.println("5 Delete User");
//			}
			System.out.println("B Back");
			
			String s;
		
			switch(scan.nextLine()) {
			//username
			case "1":
				System.out.print("Enter the new username: ");
				 s=scan.nextLine();
				if(!checkUsername(s)) {
					uu.setUserName(s);
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
				uu.setFirstName(s);
				System.out.println("First name is now: "+s);
				break;
			//last
			case"4":
				System.out.print("Enter the new last name: ");
				s=scan.nextLine();
				uu.setLastName(s);
				System.out.println("Last name is now: "+s);
				break;
			case"b":
			case"B":
				return;
			case"5":
//				if(isCust) {
					//customerDao.deleteUser(uu);
					if(uu.deleteUser()) {
						System.out.println("Deleted");
						return;
					}
					break;
//				}//else       V
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
