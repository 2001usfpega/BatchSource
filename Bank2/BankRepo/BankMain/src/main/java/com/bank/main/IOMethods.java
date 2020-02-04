package com.bank.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class IOMethods {
	
	private static final File CUSTFILE = new File("customerList.txt");
	
	private static final File PendingFile=new File("pendingReguest.txt");
	
	private static final File EMPLOYEEFILE = new File("employeeList.txt");
	private static final File ADMINFILE=new File("adminList.txt");
	private static final File ACCOUNTFILE = new File("accountFile.txt");
	
	
	//CUSTOMER SECTION
	//-----------------------------------------------------------------

	public static void writeCustomerFile() {
		ObjectOutputStream objectOut;
		
		
			try {
				objectOut = new ObjectOutputStream(new FileOutputStream(CUSTFILE));
				objectOut.writeObject(Customer.custList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	
	public static void readCustFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(CUSTFILE));
			Customer.custList = (ArrayList<Customer>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Employee section
	//---------------------------------------------------------------------------
	//
	
	public static void readEmployeefile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(EMPLOYEEFILE));
			Employee.empList = (ArrayList<Employee>)objectIn.readObject();
			
			//System.out.println(objectIn.readObject());
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writePendinFile() {
		//System.out.println("Hello from write pending file");
		
		ObjectOutputStream obj;
		try {
			Customer.pendingList.add(Driver.curCustomer);
			obj = new ObjectOutputStream(new FileOutputStream(PendingFile));
			obj.writeObject(Customer.pendingList);
			//System.out.println(Customer.pendingList.get(Customer.pendingList.size()-1));
			obj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Your application has been received");
			
		}
	
	public static void removePendingCustomer() {
		ObjectOutputStream obj;
		try {
			
			obj = new ObjectOutputStream(new FileOutputStream(PendingFile));
			obj.writeObject(Customer.pendingList);
			obj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Customer Processed");
			
		}
	
	public static void readPending() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(PendingFile));
			Customer.pendingList = (ArrayList<Customer>)objectIn.readObject();
			
			
			//System.out.println(Customer.pendingList.get(0).toString());
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeEmployeeList() {
		ObjectOutputStream obj;
		
			try {
				obj = new ObjectOutputStream(new FileOutputStream(EMPLOYEEFILE));
				obj.writeObject(Employee.empList);
				obj.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
		
	//----------------------------------------------------------------
	//ADMIN LIST
	
	
	public static void writeAdminList() {
		ObjectOutputStream obj;
			try {
				obj = new ObjectOutputStream(new FileOutputStream(ADMINFILE));
				obj.writeObject(Admin.adList);
				obj.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void readAdminfile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(ADMINFILE));
			Admin.adList= (ArrayList<Admin>)objectIn.readObject();
			//System.out.println(objectIn.readObject());
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//ACCOUNTS SECTION
	//------------------------------------------------------------------
	
	public static void writeAccountFile() {
		ObjectOutputStream objectOut;
		
		
			try {
				objectOut = new ObjectOutputStream(new FileOutputStream(ACCOUNTFILE));
				objectOut.writeObject(Account.accountList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	
	}

