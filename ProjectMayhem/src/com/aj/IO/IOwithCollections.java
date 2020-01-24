package com.aj.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Person;

public class IOwithCollections {
	private static final String personFile = "person.txt";
	public static List<Person> personList = new ArrayList<Person>();

	// write method
	public static void writeToFile() {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objOut.writeObject(personList);
			objOut.close();

		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void readFromFile() {
		ObjectInputStream objIn;
		try {
			objIn = new ObjectInputStream(new FileInputStream(personFile));
			personList = (ArrayList<Person>) objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
