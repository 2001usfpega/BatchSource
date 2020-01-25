package com.revature.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Person;

public class IOWithCollections {
	private static final String PERSON_FILE = "person.txt";
	public static List<Person> personList = new ArrayList<>();
	
	//write method
	public static void writePersonFile() {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(PERSON_FILE));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch (IOException e) {
		}
	}
	
	//read method
	@SuppressWarnings("unchecked")
	public static void readPersonFile() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(PERSON_FILE));
			personList = (ArrayList<Person>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
