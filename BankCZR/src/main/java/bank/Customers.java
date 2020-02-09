package bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class Customers{
	
	public String id, password, name;
	public int ssn;
	public ArrayList<String> arrayAcc; 
	final static Logger logger = Logger.getLogger(Customers.class);
	
	public Customers() {
		
	}
	
	public Customers(String id, String password, String name, int ssn){
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.arrayAcc = new ArrayList<>();
	}
	
	HashMap<String, Accounts> withdrawCustomer(HashMap<String, Accounts> hashMapAcc, String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		if (hashMapAcc.get(cust_acc).getStatus().equals("approved")) {
			amount = MainDriver.checkInputDouble();
			if (hashMapAcc.get(cust_acc).getBalance() >= amount) {
				hashMapAcc.get(cust_acc).balance -= amount;
				System.out.println(" Withdrwal complete. The account balance is now: $" + hashMapAcc.get(cust_acc).balance);
				logger.info(" Account "+cust_acc + ": withdrawed $" + amount);
			} else {
				System.out.println(" Insufficient funds. The account balance is: $" + hashMapAcc.get(cust_acc).balance);
			}
		} else {
			System.out.println(" The status of the account is: " + hashMapAcc.get(cust_acc).getStatus() );
		}
		return hashMapAcc; 
	}
	
	HashMap<String, Accounts> depositCustomer(HashMap<String, Accounts> hashMapAcc, String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		if (hashMapAcc.get(cust_acc).getStatus().equals("approved")) {
			amount = MainDriver.checkInputDouble();
			hashMapAcc.get(cust_acc).balance += amount;
			System.out.println(" Deposit complete. The account balance is now: $" + hashMapAcc.get(cust_acc).balance);
			logger.info(" Account " + cust_acc + ": deposited $" + amount);
			return hashMapAcc; 
		}else {
			System.out.println(" The status of the account is: " + hashMapAcc.get(cust_acc).getStatus() );
		}
		return hashMapAcc; 
	}
	
	HashMap<String, Accounts> transferCustomer(HashMap<String, Accounts> hashMapAcc, String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		String transferAcc; 
		if (hashMapAcc.get(cust_acc).getStatus().equals("approved")) {
			amount = MainDriver.checkInputDouble();
			System.out.println(" What is the account number?");
			transferAcc = sc.nextLine();
			if (hashMapAcc.containsKey(transferAcc)==true && hashMapAcc.get(transferAcc).getStatus().equals("approved")) {
				if (hashMapAcc.get(cust_acc).balance >= amount) {
					hashMapAcc.get(cust_acc).balance -=  amount; 
					hashMapAcc.get(transferAcc).balance += amount; //transfer account balance
					System.out.println(" Withdrwal complete. The account balance is now: $" + hashMapAcc.get(cust_acc).balance);
					logger.info("Account " + cust_acc + ": transferred $" + amount + " to " + "account " + transferAcc);
				} else {
					System.out.println(" Insufficient funds. The account balance is: $" + hashMapAcc.get(cust_acc).balance);
				}
			} else {
				System.out.println(" This account number does not exist or has a pending status.");
			}
		} else {
			System.out.println(" The status of the account is: " + hashMapAcc.get(cust_acc).getStatus() );
		}
		return hashMapAcc;
	}
	
	public String toString() {
		return "[ID: "+id + "] [Password: "+password + "] [Name: "+name + "] [SSN: "+ssn +  "] [Accounts: " + arrayAcc+"]"; 
	}
	
	public static void printCustInfo(Customers cust) {
		System.out.println("Customer Info" );
		System.out.println(cust);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public ArrayList<String> getArrayAcc() {
		return arrayAcc;
	}
	public void setArrayAcc(ArrayList<String> arrayAcc) {
		this.arrayAcc = arrayAcc;
	}
}