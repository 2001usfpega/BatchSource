package com.revature.io;

public class iodemo {
	public static void main(String[] args) {
		IO io = new IO();
		String a="roll tide";

		io.writeOut(a);
		
		System.out.println(io.readInput());
	}

}
