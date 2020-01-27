package com.revature.banking.test;

import java.io.Serializable;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Customer extends Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double balance = 0.0;
	private boolean approved = false;
	private boolean disabled = false;
	private String fileloc = Paths.get("").toAbsolutePath().toString() +"\\Customer\\";
	//Used to display the balance to the second decimal place
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public void loginCustomer(){
		
		Customer customer = new Customer();
		
		try { 
			Scanner in = new Scanner(System.in);
			String id = null;
			boolean t= false;
			while(t == false) {
				
			System.out.println("Enter your ID number: ");
			id = in.nextLine();
			t= customer.checkNull(id);
			}
			
			String pass= null;
			boolean w = false;
			
			while(w == false) {
				System.out.println("Enter your password: ");
				pass = in.nextLine();
				w= customer.checkNull(pass);
			}
			
			Login check = new Login();
			ObjectIO robj = new ObjectIO();
			
			customer = (Customer) robj.readObject(customer,getFileloc()+id);
			String password = customer.getPassword();
			
			if(customer.isDisabled() == false) {
				
				if(customer.isApproved() == true) {
					
					if(check.login(pass, password) == true) {
						
						in.close();
						menu(customer);
						
					}else{
						System.out.println("Failed to log in, try again");
						loginCustomer();					
					}
				}else{
					System.out.println("The account has not been approved");
					System.out.println("It will be approved shortly!");
				}
			}else{
				System.out.println("Your account has been disabled");
				System.out.println("Please see a bank admin");
			}
		}catch (Exception ex) {
			loginCustomer();
			
		}
	}

	public void menu(Customer customer) {
		
		ObjectIO save = new ObjectIO();
		System.out.println("###########################################################################");
		System.out.println("Welcome back " + customer.getFirst_name());
		System.out.println("Your current balance is : $"+ df.format(customer.getBalance()));
		
		System.out.println("Enter a (D) to Deposit an amount into your balance");
		System.out.println("Enter a (W) to Withdraw an amount from your balance");
		System.out.println("Enter a (T) to Transfer an amount to another member");
		System.out.println("Enter a (E) to Exit Your account");
		
		try (Scanner in = new Scanner(System.in)) {
			
			String c = in.nextLine();
			
					if( c != null) {
						
						if( c.equalsIgnoreCase("D")) {
							
							System.out.println("Enter the amount you wish to depoit");
							double amount = in.nextDouble();
							
							customer.deposit(customer.getBalance(), amount);
							save.writeObject(customer, getFileloc()+customer.getId());
							menu(customer);
							
						}else if (c.equalsIgnoreCase("T")) {
							
							System.out.println("Enter the ID of the member you wish to transfer funds to: ");
							String tCID = in.nextLine();
							System.out.println("Enter the amount you wish to transfer: ");
							double amount = in.nextDouble();
							customer.transfer(tCID, customer.getId(), amount, customer);
							save.writeObject(customer, customer.getId());
							menu(customer);
							
						}else if (c.equalsIgnoreCase("W")) {
							
							System.out.println("Enter the amount you with to withdraw");
							double amount = in.nextDouble();
							customer.withdraw(customer.getBalance(), amount);
							save.writeObject(customer,getFileloc()+ customer.getId());
							menu(customer);
							
						}else if(c.equalsIgnoreCase("E")) {
							
						}else{
							
							System.out.println("Invalid entry");
							menu(customer);
						}
					}else {
						
						System.out.println("Invalid entry");
						menu(customer);
					}
					
					in.close();
		}
	}
	
	
	public void transfer(String tCID, String cID, double amount, Customer transferer) {
		
		// transfers money from one account to another
		//tcid is the transferee id 
		
		Customer transferee = new Customer();
		ObjectIO robj = new ObjectIO();
		ObjectIO wobj = new ObjectIO();
		
		transferee =(Customer) robj.readObject(transferee,tCID);
		transferee.deposit(transferee.getBalance(), amount);
		transferer.withdraw(transferer.getBalance(), amount);
		
		wobj.writeObject(transferee, getFileloc()+ transferee.getId());
		wobj.writeObject(transferer, getFileloc()+transferer.getId());
	}


	public void setBalance(double b) {
		this.balance = b;
	}
	
	public double getBalance() {
		return balance;
	}

	public void withdraw(double d, double amount) {
		
		// subtracts the amount from a user's balance
		double newbalance;
		
		if (amount > 0){
			
			if( amount < d) {
				
			newbalance = d - amount;
			setBalance(newbalance);
			
			}else {
				
				System.out.println("Withdraw is more than you have in your account");
			}
			
		}else {
			
			System.out.println("You cannot withdraw a negative number");
		}
	}
		
	public void deposit(double d, double amount) {
		
		// adds amount to the users balance
		double newbalance;
		newbalance = d + amount;
		setBalance(newbalance);
		
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getFileloc() {
		return fileloc;
	}

	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}

}