package com.revature.overloading;

public class OverloadingDemo {
	public static void main(String[] args) {
		double d = 35.5;
		float f = 54.578f;
		System.out.println(multiply(67,34)); //Exact match - method 1
		System.out.println(multiply(67,23,1,2,3,5,78,5));// varargs - method 4
		System.out.println(multiply(d, 78));//boxing ? - method 3
		System.out.println(multiply(66,54,f));//conversion? - method 2
	}
	
	
	public static int multiply(int a, int b) {
		System.out.println("Method 1");
		return a * b;
	}
	
	//Not sure about conversion... Maybe??
	public static int multiply(Integer a, int b, double c) {
		System.out.println("Method 2");
		return (int) (a*b*c);
	}
	
	//Boxing?
	public static int multiply(Double a, int b) {
		System.out.println("Method 3");
		return (int) (a * b);
	}
	
	//Varargs
	public static int multiply(int ...v) {
		System.out.println("Method 4");
		int result = 1;
		for(int x: v) {
			result = result * x;
		}
		return result;
	}
}
