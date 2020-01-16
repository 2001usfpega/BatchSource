package com.revature.wrappers;

public class Wrappers {
	
	
	static int myInt = 3;
	static Integer myInteger = 5;
	static Integer newInteger = 7;
	static Double myDouble = 45.32;
	
	public static void main (String[] args) {
		
		
		
	//Autoboxing - impliciit conversion from primitive to Wrapper
		
		System.out.println(addEmUp(myInteger.doubleValue(), myDouble));
		
		
		//Auto-unboxing
		
		System.out.println(addEmUp(myInteger, newInteger));
		
		//Number is a wrapper for all numeric types so the following will take any type of number.
		
		
		
		
	//boxing is expensive
		
		//Number - Wrapper for all numeric types
		
		
	}
	
	public static int addEmUp(int a, int b) {
		return a +b;
	}
	
	public static double addEmUp(Double a, Double b) {
		return a +b;
	}
	
	public static Double addEmUp1(Number a, Number b) {
		return a.doubleValue()
 + b.doubleValue();	}

}
