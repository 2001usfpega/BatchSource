package com.revature.wrapperz;

public class FunWithWrapperz {
	
	static int myInt=3;
	static Integer myInteger =5;
	static Integer newInteger =7;
	static Double myDouble = 45.32;
	
	public static void main(String[] args) {
		System.out.println(addEmUp(myInteger.doubleValue(),myDouble));
		System.out.println(addEmUp(myInteger,newInteger));
		System.out.println(addEmUp(myInt,newInteger));
		vaTest(1,4,5,6,932,20000);
	}
	public static int addEmUp(int a, int b){
		System.out.println(1);
		return a+b;
	}
	public static double addEmUp(Double a, Double b){
		System.out.println(2);
		return a+b;
	}
	public static Double addEmUp1(Number a, Number b){
		System.out.println(3 );
		return a.doubleValue()+b.doubleValue();
	}
	public static void vaTest(int ... v) {
		for(int x:v){
			System.out.print(x+" ");
		}
		System.out.println();
	}
}
