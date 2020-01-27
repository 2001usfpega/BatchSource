package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revarture.bean.Person;

public class IOWIthColletions 
{
	private static final String personFile = "person.txt";
	public static List <Person> personList = new ArrayList<Person>();
	
	//write
	public static void writePersonFile() 
	{
		ObjectOutputStream objectOut;
		try 
		{
			objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readPersonFile() 
	{
		ObjectInputStream objectIn;
		try 
		{
			objectIn = new ObjectInputStream(new FileInputStream(personFile));
			personList = (ArraryList<Person>)objectIn.readObject();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
