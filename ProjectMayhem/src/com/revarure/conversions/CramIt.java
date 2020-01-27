package com.revarure.conversions;

public class CramIt {
	static float f = 32.876f;
	static double d;
	static float g;
	
	public static void main(String[] args) {
		//Widening
		d=f;
		System.out.println(d);
		
		//Narrowing
		g=(float)d;
		System.out.println(g);
		
		Object o;
		o=new String("YeeHaw");
		System.out.println(o);
	}

}
