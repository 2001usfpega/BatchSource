package com.revature.conversions;

public class CramIt {
	static float f = 32.876f;
	static double d;
	static float g;
	static int i;
	
	public static void main(String[] args) {
		d=f;
		System.out.println(d);
		
		g=(float)d;
		System.out.println(g);
		
		i=(int)f;
		System.out.println(i);
		
		Object o = new String("YeeHaw");
		System.out.println(o);
	}
	

}
