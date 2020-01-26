package com.revature.bankingassignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Writer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public void objectCreationWrite(Object obj, String files)
	{
		
		Writer myObject = new Writer();
		myObject.serializeObjectOutput(obj, files);
		
		
	}

	public void serializeObjectOutput(Object obj, String files) {
		
		FileOutputStream output = null;
		ObjectOutputStream output2 = null;
		
		

		try {
			
			output = new FileOutputStream(files +".txt");
			output2 = new ObjectOutputStream(output);
			output2.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public Object readObject(Object obj, String files) 
	{

		Writer myObject = new Writer();
		obj = myObject.unserialzeObjectOutput(files + ".txt");
		return myObject;

	}
	
	public Object unserialzeObjectOutput(String fname)
	{
		Object myObject2 = null;
		FileInputStream fStream = null;
		ObjectInputStream oStream = null;
		
		try {
			fStream = new FileInputStream(fname);
			oStream = new ObjectInputStream(fStream);
			myObject2 = (Object) oStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return fname;
		
		
		
		
	}
	
	

}
