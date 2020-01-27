package com.revarure.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {

	private static final String outFile = "output.txt";
	private static final String inFile = "input.txt";
	
	//Write and reading stream
	public void writeOutputStreamContent(String contents) {
		OutputStream os = null;
		File file = new File("output.txt");
		try {
			os = new FileOutputStream(file,true);
			//If the file was not there, it create one
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
	
	
	public String readInputStreamContent() {
		InputStream is = null;
		
		File file = new File(inFile);
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
			int b = 0;
			//-1 is end of the stream
			while ((b=is.read())!=-1) {
				char c = (char) b;
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
