package com.revarure.wrapperz;

public class FunWithWrapperz {
	/*
	 * Wrappers.
	 * Wraps around primitive and allows it to be treated as an object
	 * Character
	 * Boolean
	 * Byte
	 * Short
	 * Integer
	 * Double
	 * Long Float
	 * 
	 * Upper case at the first letter
	 * Why Wrappers?
	 * 	Good for their utility methods
	 *  Used when we NEED an object
	 */
	
	static int myInt = 3;
	static Integer myInteger = 5;
	static Integer newInteger = 7;
	static Double myDouble = 45.32;
	
	
	public static void main(String[] args) {
		//myInteger.byteValue();
		//Autoboxing - implicit conversion from primitive to Wrapper
		System.out.println(addEmUp(myInteger.doubleValue(), myDouble));
		//Boxing is expensive!!!
		
		//Auto-unboxing - implicit conversion from Wrapper to primitive
		System.out.println(addEmUp(myInteger, newInteger));
		
		//Number - Wrapper for all numeric types
		System.out.println(addEmUp1(myInt, newInteger));
	}
	
	public static int addEmUp(int a, int b) {
		System.out.println("Using int");
		return a+b;
	}
	
	public static double addEmUp(Double a, Double b) {
		System.out.println("Using DOUBLE");
		return a+b;
	}
	
	public static Double addEmUp1(Number a, Number b) {
		System.out.println("Using NUMBER");
		return a.doubleValue()+b.doubleValue();
	}
}
