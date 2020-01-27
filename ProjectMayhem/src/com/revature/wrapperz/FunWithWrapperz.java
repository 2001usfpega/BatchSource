package com.revature.wrapperz;

public class FunWithWrapperz 
{
	/*Wrappers
	 * Warps around primitive and allows it to be treated as an odject
	 * Character
	 * Boolean
	 * Byte
	 * Short
	 * Integer
	 * Long
	 * Float
	 * Double
	 * Why wrappers??
	 * good for their utility methods
	 * 
	 * 
	 * */
	static int myInt = 3;
	static Integer myInteger = 5;
	static Integer newInteger = 7;
	static Double myDouble = 45.32;
	
	public static void main (String [] args)
	{
		myInteger.byteValue();
		//Autoboxxing- implicit conversion from primitive to Wrapper
		System.out.println(addEmUp(myInteger.doubleValue(), myDouble));
		//AutoUnboxxing- implicit conversion from Wrapper to Primitive
		System.out.println(addEmUp(myInteger, newInteger));
		//Boxxing is expensive
		//Number- Wrapper for all numeric types
	}
	
	public static int addEmUp(int a, int b) 
	{
		return a + b;
	}
	
	public static double addEmUp(Double a, Double b) 
	{
		return a + b;
	}
	
	public static Double addEmUp(Number a, Number b) 
	{
		return a.doubleValue() + b.doubleValue();
	}
	
	
	
	
	
}
