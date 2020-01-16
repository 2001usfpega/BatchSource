package com.revature.varargs;

public class FunWithVarArgs {
	public static void main(String[] args) {
		vaTest(10,4,-3,5);
		vaTest();
		
		int [] a = {1,2,3,4,6,8,4,6,3,5};
		vaTest(a);
	}
	public static void vaTest(int ... v) {
		System.out.println("number of args is "+ v.length+" contents");
		for(int i:v) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
