package com.revature.ThirdDay;

public class ThirdDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int int1 = 2;
		int int2 = 4;
		double dou1 = 3.3d;
		double dou2 = 4.123456789d;
		
		Integer Int1 = 12;
		Integer Int2 = 14;
		
		
		float flo1;
		
		Double Dou1 = 4.987654321d;
		Float Flo1;
		
		int[] ary = {1, 2, 3, 4, 5, 6,};
		
		
		
		
		System.out.println( addTwo(int1 , int2) + "\n");
		//exact match overload with primitive integer
		
		System.out.println( addTwo(dou1 , dou2) + "\n");
		//exact match overload with double
		
		flo1 = (float)dou2;
		dou2 = (double)flo1;
		System.out.println("Conversion: primitive cast to primitive");
		System.out.println(flo1);
		System.out.println(dou2 + "\n");
		
		Flo1 = Dou1.floatValue();
		Dou1 = Flo1.doubleValue();
		System.out.println("Conversion: wrapper type convert to primitive type then store in wraper");
		System.out.println(Flo1);
		System.out.println(Dou1 + "\n");
		
		System.out.println("Boxing");
		System.out.println(addingWithBoxing(int1, Int1)+ "\n");
		System.out.println("Unboxing");
		System.out.println(addingWithUnBoxing(int1, Int1)+ "\n" );
		
		
		System.out.println("Varargs: arguments wrapped into arrays");
		System.out.println("the sum of this array is " + vararg(ary)+ "\n");
		
		

	}

	public static int addTwo(int a, int b) {
		System.out.println("exact match: overload with primitive integer");
		return a + b;
	}
	
	public static double addTwo(double a, double b) {
		System.out.println("exact match: overload with double");
		return a + b;
	}
	
	public static int addingWithBoxing(Integer a, Integer b) {
		
		return a + b;
	}
	
	public static int addingWithUnBoxing(int a, int b) {
		
		return a + b;
	}

	public static int vararg(int ...vv) {
		
		int sum = 0;
		for(int x: vv) {
			sum += x;
		}
		
		return sum;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
