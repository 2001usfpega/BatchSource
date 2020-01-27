package com.revarure.varargs;

public class FunWithVarArgs {
	/*
	 * Variable length arguments - varargs
	 * 	Method that will take a variable number of arguments.
	 * 	Automates and hides the process of creating and saving
	 * 	the values into an array prior to invoking the method.
	 * 		Can be of any type!
	 *	 	Must be the last argument!
	 * 		0 to many args
	 */
	
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6,7};
		vaTest(10);
		vaTest(2,3,1,5,764,53,78,23,234,12,31);
		vaTest();
		vaTest(a);
	}
	
	//Do not put other argument after
	public static void vaTest(int ...v) {
		System.out.println("Number of args is "+ v.length+" Contents");
		//foreach: do not know number of variable is
		for (int x : v) {
			System.out.print(x+" ");
		}
		
		System.out.println();
	}
}
