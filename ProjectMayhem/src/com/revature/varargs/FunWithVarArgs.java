package com.revature.varargs;

public class FunWithVarArgs {
	
	/*
	 * Method that will take a variable number of arguments
	 * 
	 * Automates and hides the process of creating and saving
	 * the values into an array prior to invoking the method
	 * Can be of any type!
	 * must be the last argument!
	 * 0 to many args.
	 */
	
	
	public static void main(String[] args) {
		vaTest(5, 7, 8, 9);
	}
	
	public static void vaTest(int ... v) {
		
		System.out.println("number of args is " + v.length + " Contents");
		
		for(int x:v) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
