package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	private static final String OUTFILE = "output.txt";
	private static final String INFILE = OUTFILE;//"input.txt";
	
	
	//write
	public void writeOut(String cont) {
		OutputStream os=null;
		File file = new File(OUTFILE);
	
		try {
			os =  new FileOutputStream(file,true);
			os.write(cont.getBytes());
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		if(os!=null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public String readInput() {
		InputStream is = null;
		File file = new File(INFILE);
		StringBuilder s =new StringBuilder();
		try {
			is = new FileInputStream(file);
			int b = 0;
			while((b=is.read())!=-1) {
				char c=(char) b;
				s.append(c);
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.toString();
	}

}
