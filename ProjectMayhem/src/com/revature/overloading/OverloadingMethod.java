package com.revature.overloading;

public class OverloadingMethod {
	
	int a=12;
	short b=(short)a;
	
	 static Double wrap3=25.2;
	static  Number wrap4=new Double(56);
	
	public static void main(String[] args) {
		
		int prim=12;
		//autoboxing
		 Integer wrap1= prim;
		 //autoUnBoxing
		 int prim2=wrap1.intValue()+7;
		 
		System.out.println(wrap1);
		System.out.println(prim2);
		
		
		
		System.out.println(overloadingExample(prim, wrap1.intValue()));
		
		System.out.println(overloadingExample( wrap3,  wrap4));
		
		
	}
	
	public static int overloadingExample(int a, int b) {
		System.out.println("Using integer substract");
		return a-b;
		
	}
	
	public static Double overloadingExample(Number a , Number b) {
		System.out.println("Using DOUBLE adding");
		return a.doubleValue()+b.doubleValue();
		
	}

}
