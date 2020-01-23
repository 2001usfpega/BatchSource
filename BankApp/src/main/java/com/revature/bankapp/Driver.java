package com.revature.bankapp;

import java.util.HashMap;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

public class Driver implements java.io.Serializable {
	
	Map<String, Customer> customerMap;
	Main()
	{
		customerMap = new HashMap<String, Customer>();
	}

	public static void mian(String[] BettyWhite) {
		Scanner scanner = new Scanner(System.in);
		Customer customer;
		String username;
		String password;
		double amount;
		
		Main bank = new Main();
		int choice;
		outer: while(true) {
			System.out.println("BANK OF REVATURE");
			System.out.println("Please choose one:");
			System.out.println("1. Register Account.");
			System.out.println("2. Login.");
			System.out.println("3. Update Accounts.");
			System.out.println("4. Login as Bank Employee.");
			System.out.println("5. Exit.");
			choice =scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter First Name: ");
				String fName = scanner.nextLine();
				System.out.println("Enter Last Name: ");
				String lName = scanner.nextLine();
				System.out.println("Enter address: ");
				String address = scanner.nextLine();
				System.out.println("Enter City: ");
				String City = scanner.nextLine();
				System.out.println("Enter ZIP: ");
				String zip = scanner.nextLine();
				System.out.println("Enter State: ");
				String state = scanner.nextLine();
				System.out.println("Enter Phone: ");
				String phone = scanner.nextLine();
				System.out.println("Enter e-mail: ");
				String email = scanner.nextLine();
				System.out.println("Set Username: ");
				username = scanner.next();
				while(bank.customerMap.containsKey(username)) {
					System.out.println("Username already exists.  Please set a different username: ");
					username = scanner.next();
				}
				System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
				password = scanner.next();
				while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}")))) {
					System.out.println("Invalid password condition.  Please set again: ");
					password = scanner.next();
				}
				System.out.print("Enter initial deposit: ");
				amount = scanner.nextDouble();
				customer = new Customer(username, password, fName, lName, address, city, zip, phone, email, new Date());
				bank.customerMap.put(username, customer);
				break;
				
			case 2:
				System.out.println("Enter username: ");
				username = scanner.next();
				System.out.println("Enter password: ");
				password = scanner.next();
				if(bank.customerMap.containsKey(username));{
					customer=bank.customerMap.get(username);
					if(customer.password.equals(password)) {
						while(true) {
							System.out.println("WELCOME back to the Bank of Revature!!");
							System.out.println("Please enter your choice.");
							System.out.println("1.Deposit.");
							System.out.println("2. Transfer.");
							System.out.println("3. Last 5 transactions.");
							System.out.println("4 User Information.");
							System.out.println("5. Log out.");
							switch(choice) {
							case 1:
								System.out.println("Enter amount: ");
								while(!scanner.hasNextDouble()) {
									System.out.println("Invalid amount.  Enter again: ");
									scanner.nextLine();		
								}
								amount = scanner.nextDouble();
								scanner.nextLine();
								customer.deposit(amount,  new Date());
								break;
							case 2:
								System.out.println("Enter payee username: ");
								username = scanner.next();
								System.out.println("Enter amount: ");
								while(!scanner.hasNextDouble()) {
									System.out.println("Invalid amount. Enter again: ");
									scanner.nextLine();
								}
								amount = scanner.nextDouble();
								scanner.nextLine();
								if(amount >30000) {
									System.out.println("Transfer limit exceeded.  Contact Manager for Bank of Revature.");
								break;
								}
								if(bank.customerMap.containsKey(username)) {
									Customer payee = bank.customerMap.get(username);
									payee.deposit(amount,  new Date());
									customer.withdraw(amount,  new Date());
								} else {
									System.out.println("Username not on file.");
								}
								break;
							case 3:
								for(String transactions : customer.transactions) {
									System.out.println(transactions);
								}
								break;
							case 4:
								System.out.println("Accountholder name: "+customer.fName+" "+customer.lName);
								System.out.println("Accountholder address: "+customer.addres);
								System.out.println(customer.city+", "+customer.state+" "+customer.zip);
								System.out.println("Customer Phone: "+customer.phone+" Customer email: "+customer.email);
								break;
							case 5:
								continue outer;
								default;
								System.out.println("Please make another selection.");
							}
						}
					}
					else {
						System.out.println("Incrrect username/password combination.");
					}
				}else {System.out.println("Incorrect username/password combination.");
			} break;
			case 4:
				System.out.println("Enter username: ");
				username = scanner.next();
				System.out.println("Enter password: ");
				password = scanner.next();
				scanner.nextLine();
				if(username.equals("emp") && password.equals("1234")) {
					while(true) {
						System.out.println("WELCOME to the Bank of Revature");
						System.out.println("1.See account information of all the customers.");
						System.out.println("2. Log out");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Customers information");
							System.out.println("username name address pohone balance");
							for(Customer v : bank.customerMap.values()) {
								System.out.println(v.username+" "+v.name+" "v.address+" "v.phone+" "v.balance);
							}
							break;
						case 2:
							continue outer;
						}
						}
					} 
				break;
			case 5: 
				String filename = "information.txt";
				try {
					FileOutputStream files = new FileOutputStream(filename);
					ObjectOubputStream out = new ObjectOutputStream(rile);
					out.writeObject(bank);
					out.close();
					file.close();
					System.out.println("Object has been serialized");
				}
				
				catch (IOException ex) {
					
				}
				System.out.println("Thank you for choosing the Bank of Revature.");
				System.exit(1);
				break;
				default:
					System.out.println("Please make another selection.");
				}
		}
		
	}
	
	
}
