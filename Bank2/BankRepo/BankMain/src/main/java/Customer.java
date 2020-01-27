import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	public static final long serialVersionUID = -470081244094378942L;
	public static ArrayList<Customer> custList = new ArrayList<Customer>();
	public static ArrayList<Customer>pendingList = new ArrayList<Customer>();
	private String name;
	private String password;
	private String email;
	private String address;
	private String phoneNumber;
	private double balance;
	double accountNumber = 0;
	boolean accountEnabled = false;
	Customer(){};
	
	Customer(String name, String password){
		this.name = name;
		this.password = password;
	}
	Customer(String name, String password, String email, String address, String phoneNumber, double balance){
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}
	
	public void setEnabledTrue() {
		this.accountEnabled = true;
	}
	public boolean getAccountEnabled() {
		return accountEnabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void deposit(Double amount) {
		this.balance+=amount;
	}
	public void withdraw(Double amount) {
		if(this.balance-amount<0) {
			System.out.println("You have insufficient funds");
		}else {
			this.balance -=amount;
		}
}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [name=" + name + ", password=" +password + ", email=" + email+ ", address=" + address + 
				"phone number=" + phoneNumber + "Enabled: " +"]";
	}
	
	
}
