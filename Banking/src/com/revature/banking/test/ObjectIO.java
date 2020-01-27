package com.revature.banking.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public void writeObject(Object object, String file) {
		
		ObjectIO obj = new ObjectIO();
		obj.serializeObject(object, file);
	}
	
	public void serializeObject(Object object, String file) {
		
		// f out, file out, writes to a file
		FileOutputStream fout = null;
		// establishes the Object output stream
		ObjectOutputStream oos = null;
		
		try {
			
			fout = new FileOutputStream(file +".txt");// establishes which file to write to
			oos = new ObjectOutputStream(fout);// writes object to the f out file
			oos.writeObject(object);// writes object to the file
			oos.flush();
			System.out.println("Done");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		} finally {
			
			if (fout != null) {
				
				try {
					
					// closes file when done writing
					fout.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

			if (oos != null) {
				
				try {
					
					oos.close();// close object stream
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void serializeObjectJDK7(Object object, String file) {

		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream( file +".txt"))) {

			oos.writeObject(object);
			System.out.println("Done");

		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Object readObject(Object object, String file) {

		ObjectIO obj = new ObjectIO();

		object = obj.deserialzeObject(file+ ".txt");

		return object;

	}

	public Object deserialzeObject(String filename) {

		Object object = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			object = (Object) ois.readObject();

		} catch (Exception ex) {
			
			//ex.printStackTrace();
			System.out.println("Account does not exist");
			
		} finally {

			if (fin != null) {
				
				try {
					
					fin.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

			if (ois != null) {
				
				try {
					
					ois.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

		return object;

	}

	public Object deserialzeObjectJDK7(String filename) {

		Object object = null;

		try (ObjectInputStream ois 
			= new ObjectInputStream(new FileInputStream(filename))) {

			object = (Object) ois.readObject();

		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		return object;

	}
}