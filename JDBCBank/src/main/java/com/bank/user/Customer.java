package com.bank.user;

import java.util.ArrayList;
import java.util.List;

import com.bank.BankUtil;
import com.bank.account.Account;

public class Customer extends User {

	private List<Account> myAccounts = new ArrayList<>();


	/*
	 * Constructors
	 */
	public Customer(int id,String uname, String pw, String fName, String sName) {
		super(id,uname, pw, fName, sName);
		this.updateMyAccounts();
	}
	public Customer(int id,String uname, String pw, String fName, String sName,List<Account> myaccs) {
		super(id,uname, pw, fName, sName);
		myAccounts=myaccs;
	}
	
	public static void createNewCustomer(String uname, String pw, String fName, String sName) {
		//create a new customer on the server
		customerDao.insertNewUser(uname, pw, fName, sName,0);
		//should probably check for errors but...
	}
	
	//return customer given an id
//	public static Customer searchCust(int custID) {
//		return customerDao.selectByUserId(custID);
//	}

//	//return list of customers with a given first name
//	public static List<Customer> searchCustFName(String custName) {
//		return customerDao.se;
//	}
	
	public List<Account> getMyAccounts() {
		return myAccounts;
	}
//	
//	public static ArrayList<Customer> getCustList() {
//		return custList;
//	}
	

	public void createAccount() {
		accountDao.insertAccount(this);
		updateMyAccounts();
	}
	
	public void createJointAccount(Customer c) {
		accountDao.insertAccount(this,c);
		updateMyAccounts();
	}
	
	public void updateMyAccounts() {
		myAccounts=accountDao.selectAllAccountsForUser(this);
	}	
	
	@Override
	public boolean deleteUser() {
		if(myAccounts.size()>0) {
			System.out.println("Cannot delete a customer with open accounts");
			return false;
		}
		return customerDao.deleteUser(this);
	}


	@Override
	public void userActions() {
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
					createAccount();
					System.out.println("New Account Created");
				}
				break;
			// Create Joint Account
			case "3":
				System.out.println();
				System.out.println("Enter the username of the user you would like to share the account with:");
				String jName = scan.nextLine();
				if(username.equals(jName)) {
					System.out.println("Cant join with yourself");
					break;
				}
				System.out.println("Enter the password for that account:");

				//check if name is taken
				User jUser =User.getUser(jName, scan.nextLine());
				if(jUser ==null) {
					System.out.println("Username or password were incorrect");
				}
				//is valid account to join with
				else if (jUser instanceof Customer) {
					createJointAccount((Customer)jUser);
					System.out.println("New account created with "+jName);
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

	
		
	public static void doTransAct(List<Account> list){
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
				System.out.println("4 Delete Account");
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
						}
						else {
							System.out.println("Insufficient funds");									
						}
					} 
					else {
						System.out.println("Not a valid number");
					}
					break;
				case "4":

					System.out.println();
					if(curAcc.getBalance()>0) {
						System.out.println("Balance must be zero");
						break;
					}
					System.out.println("Are you sure you want to delete this account?");
					System.out.print("(Y/N): ");
					if( scan.nextLine().toLowerCase().equals("y")) {		
						accountDao.deleteAccount(curAcc);
						list.remove(curAcc);
						
						System.out.println("Account Deleted");
						return;
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
	
	
	@Override
	public String toString() {
		String s = "CUSTOMER:   " + super.toString();
		for (Account a : myAccounts) {
			s += "\n\t" + a.toString();
		}
		return s;
	}
}
