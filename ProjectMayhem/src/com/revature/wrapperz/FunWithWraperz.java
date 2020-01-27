package com.revature.wrapperz;

public class FunWithWraperz {
	
	/*Wrappers
	 * Wrap around primitives and allows to be treated as object\
	 * Character
	 * Boolean
	 * Byte
	 * Short
	 * Integer
	 * Long
	 * Float
	 * Double
	 * 
	 * Why Wrappers??
	 * Good utility methods
	 * used when we NEED an object
	 */
	static int myInt = 3;
	static Integer myInteger = 5;
	static Integer newInteger = 7;
	static Double myDouble = 45.32;
	public static void main(String[] args) {
		myInteger.byteValue();
		//Autoboxing: implicit conversion from primitive to wrapper
		System.out.println(addEmUp(myInteger.doubleValue(),myDouble));
		//autounboxing: implicit conversion from wrapper to primitive
		System.out.println(addEmUp(myInteger,newInteger));
		//Boxing is expensive
		//Number is a wrapper for all numeric types
		System.out.println(addEmUp1(myInt, newInteger));

	}
	public static int addEmUp(int a, int b) {  
		return a + b;
		
	}

	public static double addEmUp(Double a, Double b) {
		return a + b;	
	}
	public static Double addEmUp1(Number a, Number b) {
		return a.doubleValue() + b.doubleValue();
	}
}
