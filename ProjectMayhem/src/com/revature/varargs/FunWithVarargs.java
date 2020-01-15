package com.revature.varargs;

public class FunWithVarargs {
	/*
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args){
		vaTest(10);
		vaTest(1,2,3,4,5,6,7,8,9,10);
		
		
	}
	
	public static void vaTest(int ... v) 
	{
		System.out.println("Number of args is" + v.length + "Contents");
		for(int x:v)
		{
			System.out.print(x+" ");
				
		}
		
		System.out.println();
		
	}
}
