package com.revature.bankutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.accounts.Account;
import com.revature.userinfo.Customer;
import com.revature.userinfo.Employee;
import com.revature.userinfo.User;

//because user input is dumb
public abstract class BankUtil {
	
	//return -1 if input is bad
	public static double numGreaterThanZero(String s) {
		try {
			double ret = Double.parseDouble(s);
			if (ret > 0) {
				return ret;
			}
		} catch(NumberFormatException e) {}
		return -1.0;
	}
	public static int intGreaterThanZero(String s) {
		try {
			int ret = Integer.parseInt(s);
			if (ret > 0) {
				return ret;
			}
		} catch(NumberFormatException e) {}
		return -1;
	}
	
	
	
	//print list of objects
	public static void printArrayList(ArrayList<?> list) {
		for (Object a : list) {
			System.out.println(a.toString());
		}
	}

	//print list of ojbects with index
										//dont forget the offset index
	public static void printArrayListN(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " " + list.get(i).toString());
		}
	}
	
	
	/*
	 * 
	 * 
	 * Save/load
	 * 
	 * 
	*/	
	
	
	//save all to file
	public static void saveAll() {//BankUtil.saveAll();
		try {
	         FileOutputStream fileOut = new FileOutputStream("user.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         //write user list
	         out.writeObject(User.getUserList());
	         
	         //write account list
	         out.writeObject(Account.getAccountList());
	         
	         //write customer List
	         out.writeObject(Customer.getCustList());
	         
	         //write account numgenerator
	         out.writeObject(Account.getNextAccId());
	         
	         //write user numgenerator
	         out.writeObject(User.getNextID());	         
	         
	         out.close();
	         fileOut.close();

	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	//load all from file
	@SuppressWarnings("unchecked")
	public static void loadAll() {
		try {
			FileInputStream fileIn = new FileInputStream("user.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			//load user list
			ArrayList<User> uList = (ArrayList<User>) in.readObject();
			User.initalizeList(uList);
			
			//load account list
			ArrayList<Account> aList = (ArrayList<Account>) in.readObject();
			Account.initalizeAccoutList(aList);
			
			//load customer list
			ArrayList<Customer> cList = (ArrayList<Customer>) in.readObject();
			Customer.initalizeCustList(cList);
			
			
			//load account id generTOR
			int acID = (int) in.readObject();
			Account.setNextAccId(acID);
			
			int uID = (int) in.readObject();
			User.setNextID(uID);
			
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
	  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//create test list
	public static void createTestCases() {
		//Scanner sc=new Scanner(System.in);
		ArrayList<User> list = new ArrayList<>();

		list.add(new Employee("admin","password","Bobby","Homes",true));
		list.add(new Employee("matt","456","Jason","Knighten"));

		Customer t =new Customer("tod","123","Todd","Emert");
		t.setApprove(true);
		t.createAccount();
		t.createAccount();

		list.add(t);
		list.add(new Customer("jeff","456","jeff","get"));
		list.add(new Customer("monkeyKan333","5555","nic","knack"));

		list.add(new Employee("zach","456","zach","bell"));
		
		User.initalizeList(list);
	}
	
}


