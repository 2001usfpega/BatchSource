package com.revature.io;

import java.io.File;
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (os!=null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String readInputStreamContents(String constents) {
		
		
		
	}
	

}
