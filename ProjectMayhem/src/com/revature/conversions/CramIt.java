package com.revature.conversions;

public class CramIt {
	
	
	
	static float f=32.876f;
	static double d;
	static float g;
	
	public static void main(String [] bettywhite) {
		
		//Widening
		d=f;
		
		//Narrowing
		g=(float)d;
		
		System.out.println(d);
		System.out.println(g);
		
		Object o;
		o = new String("YeeHaw");
		System.out.println(o);
		
	}


}
