package com.revature.conversions;

public class CramIt {

	static float f = 32.876f;
	static double d;
	static float g;
	public static void main (String [] args) {
		
		//widening
		d = f;
		
		
		//narrowing
		g = (float) d;
		
		Object o;
		
		o = new String("YeeHaw");
		
	
		
		System.out.println(d);
		System.out.println(g);
	}
}
