package com.revature.io;

import java.io.File;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IO {
	
	private static final String outFile="output"; 
	//write method
	public void writeOuputStreamConstens(String contents) {
		
		OutputStream os=null;
		File file=new File("output.txt");
		try {
			os=new FileOutputStream(file,true);
			os.write(contents.getBytes());
			
=======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	private static final String outFile="output.txt";
	private static final String inFile="input.txt";
	//write method
	public void writeOutputStreamContents(String contents) {
		OutputStream os=null;
		File file= new File(outFile);
		try {
			os= new FileOutputStream(file,true);
			os.write(contents.getBytes());
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		if (os!=null) {
=======
		if(os!=null) {
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
	}
	public String readInputStreamContents(String constents) {
		
		
		
	}
	

}
=======
		
	}
	public String readInputStreamContents() {
		InputStream is= null;
		File file = new File(inFile);
		StringBuilder s= new StringBuilder();
		try {
			is= new FileInputStream(file);
			int b=0;
			while((b=is.read())!=-1) {
				char c=(char) b;
				s.append(c);
			}
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.toString();
		
	}
	}
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8
