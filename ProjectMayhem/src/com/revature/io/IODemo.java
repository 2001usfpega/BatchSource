package com.revature.io;

public class IODemo {

	public static void main(String[] args) {
		IO io = new IO();
//		String a = "Roll Tide";
//		io.writeOutputStreamContents(a + "Lady Gaga");
		
		System.out.println(io.readInputStreamContents());
	}

}
