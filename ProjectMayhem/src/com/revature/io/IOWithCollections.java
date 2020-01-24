package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Person;

public class IOWithCollections {

	private static final String personFile = "person.txt";
	public static List<Person> personList = new ArrayList<Person>();

	// write method
	public static void writePersonFile() {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read method

	public static void readPersonFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(personFile));
			personList = (ArrayList<Person>) objectIn.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
