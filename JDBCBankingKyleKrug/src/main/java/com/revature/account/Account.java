/**
 * 
 */
package com.revature.account;
//Created By Kyle Krug
import java.util.Scanner;

/**
 * @author KyleKrug
 *
 */
public class Account {
	 int id;
	 String password;
	 String username;
	 String firstname;
	 String lastname;
	 String gender;
	 String additionalInfo;
	 boolean approved = false;
	 boolean disabled = false;
	 boolean jointacc;
	 int age;
	 int ssn;
	
	public static Scanner in = new Scanner(System.in);
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
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
	public boolean isJointacc() {
		return jointacc;
	}
	public void setJointacc(boolean jointacc) {
		this.jointacc = jointacc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void newAccount() {
		String firstName ="", lastName ="", userName ="",
				password = "", additionalInfo ="";
		int age = 0, ssn = 0;
		String gender = "";
		
		while(userName=="") {
			System.out.println("Enter a username: ");
			userName =in.nextLine();
		}
		setUsername(userName);
	
		while(password=="") {
			System.out.println("Enter a password: ");
			password =in.nextLine();
		}
		setPassword(password);
		while(firstName == "") {
			System.out.println("Enter your firstname: ");
			firstName =in.nextLine();
		}
		setFirstname(firstName);
		
		while(lastName == "") {
			System.out.println("Enter your lastname: ");
			lastName =in.nextLine();
		}
		setLastname(lastName);
		while(gender == "") {
			System.out.println("Enter gender as show on official ID: ");
			gender =in.nextLine();
		}
		setGender(gender);
		
		while(age == 0) {
			System.out.println("Enter your age: ");
			age =in.nextInt();
		}
		setAge(age);
		
		while(ssn == 0) {
			System.out.println("Enter your ssn: ");
			ssn =in.nextInt();
		}
		setSsn(ssn);
		while(additionalInfo == "") {
			System.out.println("Enter an addition info: ");
			additionalInfo =in.nextLine();
		}
		setAdditionalInfo(additionalInfo);
			
	}
	
}
