package com.revature.wrappers;

public class FunWithWrapperz {
	/*
	 * Wrappers
	 * wrap around primitive and allows it to be treated as an object
	 * character
	 * boolean
	 * byte
	 * short
	 * long
	 * double
	 * why Wrappers??
	 * good for their utility methods
	 * used when we need an object
	 * 
	 * */
 static int myInt=3;
 static Integer myInteger=5;// son objetos
 static Integer newInteger=7;//son objetos
 static double myDouble=45.32;
 
 
 public static void main( String [] args) {
	
	
	 myInteger.byteValue();
	 // autoboxing- implicit conversion from primitive to wrappers
	 
	 System.out.println(addEmUp(myInteger.doubleValue(), myDouble));
	 // si tomas el objeto que se considera wrapper y llamas un metodos como "doublevalue" te va a devolver el valor primitivo.
	 
	 //auto-unboxing-implicit conversion from wrapper to primitive
	 
	 System.out.println(addEmUp(myInteger, newInteger));
    //boxing is expensive!
	 System.out.println(addEmUp1(myInt, newInteger));
 }
 public static int addEmUp(int a ,int b) {
	 System.out.println("Using interger adding");
	 return a+b;
	 
 }
 public static double addEmUp(double a, double b) {
	 System.out.println("Using double adding");
	 
	 return a+b;
 }
 public static Double addEmUp1(Number a , Number b) {
	 System.out.println("Using DOUBLE adding");
	 return a.doubleValue()+b.doubleValue();
	 //what happen??
	 //number is wrapper of all numeric  types in java
	
}
}


