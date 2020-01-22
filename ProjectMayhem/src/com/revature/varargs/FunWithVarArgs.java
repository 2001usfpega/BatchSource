package com.revature.varargs;

public class FunWithVarArgs {
	/*Variable length argument - varargs
	 * Method that will take a variable number of arguments
	 * Automates and hides the process of creating and saving
	 * the value into an array prior to invoking th method
	 * can be of any type!
	 * must be the last argument!
	 * 0 to many args
	 * */
public static void main(String[] args) {
	vaTest(10);
	vaTest(2,3,51,5,1,6,6,3,7,22,52,47);
	vaTest();
	
}
 public static void vaTest(int ... v) {
	  System.out.println("number of args is "+ v.length + "Contents");
	  for(int x:v) {
		  System.out.print(x+" ,");
	
	  }
	System.out.println(); 
 }
}
