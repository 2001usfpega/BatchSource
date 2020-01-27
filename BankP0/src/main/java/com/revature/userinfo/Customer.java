package com.revature.userinfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.bankutil.BankUtil;

public class Customer extends User {

	// serial ID
	private static final long serialVersionUID = 3L;
	

	@SuppressWarnings("resource")
	private static Scanner scan = new Scanner(System.in);
	private boolean isApproved;
	protected static ArrayList<Customer> custList = new ArrayList<>();
	private ArrayList<Account> myAccounts = new ArrayList<>();

	/*
	 * Constructors
	 */
	public Customer(String name, String pw, String fName, String sName) {
		super(name, pw, fName, sName);
	
		isApproved=false;
		userID = "C" + userID;
		
		//setNextID();
		custList.add(this);
		BankUtil.saveAll();
	}

	public static void initalizeCustList(ArrayList<Customer> list) {
		custList=list;
	}

	//return customer given an id
	public static Customer searchCust(String custID) {
		custID=custID.toUpperCase();
		if (custList!=null) {
			for (Customer customer : custList) {
				//System.out.println("Looking for Customer:" + custID);
				if(customer.getUserID()!=null&&customer.getUserID().equals(custID))
				{
					System.out.println("FOUND");
					return customer;
				}
			}
		}		
//		System.out.println("Cannot find customer:"+custID);
		return null;
	}
	
	//return list of customers with a given first name
	public static ArrayList<Customer> searchCustFName(String custName) {
		ArrayList<Customer> resList = new ArrayList<>();
		for (Customer customer : custList) {
			if(customer.getFName().equals(custName))
				resList.add(customer);
		}
		return resList;
	}
	
	public ArrayList<Account> getCustAccount() {
		return this.myAccounts;
	}
	
	public static ArrayList<Customer> getCustList() {
		return custList;
	}
	
	//get list of customers that havent been aproved
	public static ArrayList<Customer> getNewCustList() {
		ArrayList<Customer> newCustList = new ArrayList<>();
		for (Customer customer : custList) {

			if (!customer.isApprove()) {
				newCustList.add(customer);
			}
		}
		return newCustList;
	}

	public void setApprove(boolean approve) {
		this.isApproved = approve;
		BankUtil.saveAll();
	}


//	public int accType(String custID) {
//		if (custID.charAt(0) == 'C') {
//			return 1;
//		} else if (custID.charAt(0) == 'E') {
//			return 2;
//		}
//		{
//			return 3;
//		}
//	}

	@Override
	public void displayOptions() {
		System.out.println("you are logged in as a user");
	}

	@Override
	public void userActions() {

		//customer has not been approved
		if(!isApproved) {
			System.out.println("This user account has not been aproved");
			return;
		}

		do {
			System.out.println();
			System.out.println("1 View Accounts / Transactions");
			System.out.println("2 Create New Account");
			System.out.println("3 Create Joint Account");
			System.out.println("B Back");

			switch (scan.nextLine()) {
			// view accounts
			case "1":
				doTransAct(this.myAccounts);
				break;
			// Create New Account
			case "2":
				System.out.println();
				System.out.println("Are you sure you want to open a new account?");
				System.out.print("(Y/N): ");
				if( scan.nextLine().toLowerCase().equals("y")) {
					String nAcc =createAccount();
					System.out.println("New Account "+nAcc+" Created");
				}
				break;
			// Create Joint Account
			case "3":
				System.out.println();
				System.out.println("Enter the username of the user you would like to share the account with:");
				String jName = scan.nextLine();
				System.out.println("Enter the password for that account:");

				//check if name is taken
				User jUser =User.getUser(jName, scan.nextLine());
				if(jUser ==null) {
					System.out.println("Username or password were incorrect");
				}
				//is valid account to join with
				else if (jUser instanceof Customer&&((Customer) jUser).isApprove()) {
					if(jUser!=this) {
						createJointAccount((Customer)jUser);
						System.out.println("New account created with "+jUser.getFName());
					}
					else {
						System.out.println("Cant join with yourself");
					}
				}
				else {
					System.out.println("This user can not be joined with");
				}
				break;
			case "b":
			case "B":
				return;
			default:
				System.out.println("Not an option!");
			}
		} while (true);
	}

	public String createAccount() {
		Account newAcc = new Account("A", 0.0);
		myAccounts.add(newAcc);
		BankUtil.saveAll();
		return newAcc.getAccNum();
	}
	
	public void createJointAccount(Customer c) {
		Account newAcc = new Account("J", 0.0);
		myAccounts.add(newAcc);
		c.addAccount(newAcc);
		BankUtil.saveAll();
	}


	public void addAccount(Account acc) {
		this.myAccounts.add(acc);
	}
	
	
	public boolean isApprove() {
		return this.isApproved;
	}
	
	public static void doTransAct(ArrayList<Account> list){
		do {

			System.out.println();
			//display all 
			System.out.println("Choose Accout");
			BankUtil.printArrayListN(list);
			System.out.println("B Back");
	
			Account curAcc = null;
			String next = scan.nextLine().toUpperCase();
			if(next.equals("B")) {
				return;
			}
			
			int index = BankUtil.intGreaterThanZero(next)-1;
			//do i have this many accounts
			if (index >= 0 && index < list.size()) {
				curAcc = list.get(index);
			} 
			else {
				System.out.println("Not an option!");
				continue;
			}
			
			accAccess: do {
				System.out.println();
				System.out.println(curAcc.toString());
				System.out.println("1 Withdraw");
				System.out.println("2 Deposit");
				System.out.println("3 Transfer");
				System.out.println("B Back");
				double amount = 0.0;
				switch (scan.nextLine()) {
				// Withdraw
				case "1":
					System.out.println();
					System.out.println("How much would you like to withdraw: ");
	
					amount = BankUtil.numGreaterThanZero(scan.nextLine());
					if (amount > 0) {
						if(curAcc.balanceUpdate(-amount)) {
							System.out.println("Your balance is now: $"+curAcc.getBalance());
							//BankUtil.saveAll();
						}
						else {
							System.out.println("Insufficient funds");									
						}
					} 
					else {
						System.out.println("Not a valid number");
					}
					break;
				// Deposit
				case "2":
					System.out.println();
					System.out.println("How much would you like to deposit: ");
	
					amount = BankUtil.numGreaterThanZero(scan.nextLine());
					if (amount > 0) {
						curAcc.balanceUpdate(amount);
						System.out.println("Your balance is now: $"+curAcc.getBalance());
						//BankUtil.saveAll();
					} 
					else {
						System.out.println("Not a valid number");
					}
					break;
				// Transfer
				case "3":
					System.out.println();
					System.out.println("Which account would you like to transfer funds to:");
					BankUtil.printArrayListN(list);
	
					//what = scan.nextLine();
	
					Account tAcc = null;
					
					index = BankUtil.intGreaterThanZero(scan.nextLine()) - 1;
					//do i have this many accounts
					if (index >= 0 && index < list.size()) {
						tAcc = list.get(index);
						if(tAcc==curAcc) {
							System.out.println("Cant transfer into the same account");
							continue;
						}
						
					} else {
						System.out.println("Not an option!");
						continue;
					}
					
					System.out.println("How much would you like to transfer: ");
					amount = BankUtil.numGreaterThanZero(scan.nextLine());
					if (amount > 0) {
						if(curAcc.transferTo(tAcc, amount)) {
							System.out.println("Transfer Complete");
							BankUtil.saveAll();
						}
						else {
							System.out.println("Insufficient funds");									
						}
					} 
					else {
						System.out.println("Not a valid number");
					}
					break;
				case "b":
				case "B":
					break accAccess;
				default:
					System.out.println("Not an option!");
				}
			} while (true);
		}while(true);
	}
	
//	public static ArrayList<Customer> getNewUser() {
//		ArrayList<Customer> newCustList = new ArrayList<>();
//		for (Customer cus : custList) {
//			if (!cus.isApprove()) {
//				newCustList.add(cus);
//			}
//		}
//		return newCustList;
//	}
	
	@Override
	public String toString() {
		String s = "CUSTOMER:   " + super.toString();
		if(!isApproved) {
			s+="   (Unapproved)";
		}
		for (Account a : myAccounts) {
			s += "\n\t" + a.toString();
		}
		return s;
	}
}
