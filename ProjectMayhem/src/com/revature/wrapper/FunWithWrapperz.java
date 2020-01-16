package com.revature.wrapper;


/*
 * Wrappers
 * wraps around primitive and allows it to be treated as an object
 * Character
 * Boolean
 * Byte
 * Short
 * Integer
 * Long
 * Float
 * Double
 * Why Wrappers?
 * good for utility methods
 * used when we NEED an object
 */

public class FunWithWrapperz {
	
	static int myInt=3;
	static Integer myInteger=5;
	static Integer newInteger=7;
	static Double myDouble=45.32;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myInteger.byteValue();
		
		//AutoBoxing - implicit conversion from primitive to wrapper
		System.out.println(addEmUp(myInteger.doubleValue(),myDouble));
		//AutoUnBoxing - implicit version from wrapper to primitive
		System.out.println(addEmUp(myInteger,newInteger));
		//Boxing is expensive!!!!
		//Number - Wrapper for all numeric types
		System.out.println(addEmUp1(myInt, newInteger));

	}
	
	public static int addEmUp(int a, int b) {
		
		return a + b;
	}
	
	public static double addEmUp(Double a, Double b) {
		
		return a + b;
	}
	
	public static Double addEmUp1(Number a, Number b) {
		
		return a.doubleValue()+b.doubleValue();
	}

}
