package com.revature.wrapperz;

public class FunWithWrapperz {
	/* Wraps around primative and allows it to be treated as an object
	 * character
	 * Boolean
	 * Byte
	 * Short
	 * Integer
	 * Long
	 * Float
	 * Double
	 * 
	 * Why Wrappers??
	 * good for utility methods
	 * used when we Need an objects
	 * 
	 */
	
	static int myInt=3;
	static Integer myInteger = 5;
	static Integer newInteger=7;
	static Double myDouble= 45.32;
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myInteger.byteValue();
		//Autoboxing - implicit conversion from primitive to WRaPPER
		System.out.println(addEmUp(myInteger.doubleValue(),myDouble));
		//Auto-unboxing- implicit conversiom from wraper to primitive
		System.out.println(addEmUp(myInteger,newInteger));
		//Boxing is expensive!
		System.out.println(addEmUp1(myInt, newInteger));
	}
	public static int  addEmUp(int a, int b) {
		return a+ b;
	}
	public static double addEmUp(Double a, Double b) {
		return a+ b;
	}
	public static Double addEmUp1(Number a, Number b) {
		return a.doubleValue()+b.doubleValue();
	}
}
