package com.revature.maven.bankapp.groupbankapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Driver {

	public static void main(String[] args) {
		
		BankAccount cust12 = null;

		File newFile = new File("BankCustomer");
		if (newFile.exists()) {
			try {
				ObjectInputStream newStream = new ObjectInputStream(new FileInputStream(newFile));
				cust12 = (BankAccount) newStream.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			cust12 = new BankAccount("acctNum");
		}

		cust12.showCustomerMenu();

		try {
			newFile.delete();
			newFile.createNewFile();
			ObjectOutputStream newStream = new ObjectOutputStream(new FileOutputStream(newFile));
			newStream.writeObject(cust12);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
