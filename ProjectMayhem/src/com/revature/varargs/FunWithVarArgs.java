package com.revature.varargs;

public class FunWithVarArgs {
	public static void main(String [] args) {
		vaTest(10);
		vaTest(2,3,5,7,11,13);
		vaTest();
	}
	
	public static void vaTest(int ...v) {
		System.out.println("Number of args is "+ v.length + " Contents");
		for(int x:v) {
			System.out.print(x +" ");
		}
		System.out.println();
	}

}
