package com.revarure.assignment;

public class OrderOfOperating {
	static int myInt = 26;
	static double myDou = 23.06;
	static Integer myInteger = 88;
	static Double myDouble = 19.08;
	
	public static void main(String[] args) {
		
		//Exact Match
		System.out.println(mul(myInt, myInt));
	
		//Unboxing
		System.out.println(mul(myInteger,myInteger));
		
		//Boxing
		System.out.println(mul(myInteger.doubleValue(),myDouble));
		
		//Varargs
		double [] arrDouble = {1.0, 2.0, 3.0, 4.0};
		System.out.println(mul(arrDouble));
	}
	
	public static int mul(int a, int b) {
		System.out.println("Using int Multiplication!");
		return (a*b);
	}
	
	/*
	 * public static int mul(Integer a, Integer b) {
	 * System.out.println("Using Interger Multiplication!"); return(a*b); }
	 */
	
	public static double mul(Double a, Double b) {
		System.out.println("Using Double Multiplication!");
		return(a*b);
	}
	
	//Varargs
	public static double mul(double ...d) {
		System.out.println("Using varargs!");
		double tmp = 1.0;
		for (double e : d) {
			tmp*=e;
		}
		return tmp;
	}
}
