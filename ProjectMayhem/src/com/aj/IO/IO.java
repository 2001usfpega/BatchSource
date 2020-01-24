package com.aj.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {

	private static final String OUT_FILE = "output.txt";

	public void writeOutputStreamContents(String contents) {
		OutputStream out = null;
		File file = new File(OUT_FILE);

		try {
			out = new FileOutputStream(file, true);
			out.write(contents.getBytes());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File("person.txt");
		StringBuilder sB = new StringBuilder();
		try {
			is = new FileInputStream(file);
			int b = 0;
			while ((b = is.read()) != -1) {
				char c = (char) b;
				sB.append(c);
			}
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sB.toString();
	}

}
