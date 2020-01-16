package com.revature.wrapperz;

public class FunWithWrapperz {
	
	static int myInt = 3;
	static Integer myInteger = 5;
	static Integer newInteger = 7;
	static Double myDouble = 45.32;
	
	
	
	public static void main(String[] args) {
		System.out.println(myInteger.byteValue());
		//autoboxxing - implicit conversion from primitive to wrapper
		System.out.println(addEmUp(myInteger.doubleValue(),myDouble));
		//auto-unboxxing - implicit conversion from wrapper to primitive
		System.out.println(addEmUp(myInteger,newInteger));
		//number is a wrapper for all numeric types
		System.out.println(addEmUp1(myInt,newInteger));
	}
	public static int addEmUp(int a,int b) {
		return a+b;
	}
	public static double addEmUp(Double a,Double b) {
		return a+b;
	}
	public static Double addEmUp1(Number a, Number b) {
		return a.doubleValue()+b.doubleValue();
	}
}
