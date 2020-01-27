package com.revature.varargs;

public class FunWithVarArgs {
	/*Var. Length args.- vaargs
	 * Method that will take a var. number of args
	 * Automates and hides the process of creating and saving 
	 * the values into an array prior to invoking the method
	 * can be of any type!
	 * must be the last argument!
	 * ) to many args
	 */
	public static void main (String[] args) {
		int[] a= {1,2,3};
		vaTest(10);
		vaTest(2,3,7,8,14,27,6,5,8,87);
		vaTest();
		vaTest(a);
	}
	public static void vaTest(int ... v) {
		System.out.println("numbers of args is "+v.length+ "Contents");
		for (int x:v) {
			System.out.print(x+ " ");
		}
		System.out.println();
	}
}
