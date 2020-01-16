package com.revature.conversions;

public class CramIt {
	static float f=32.876f;
	static double d;
	static float g;
	
	public static void main(String [] args) {
		d = f; 
		System.out.println(d);
		g=(float) d;
		System.out.println(f);
	} 
}
