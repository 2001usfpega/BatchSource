package com.revature.coreassignment;

public class FIbonnaci {
	public static void main (String [] args) {
		int counter = 25, fib1=0, fib2=1;
		System.out.println("First " + counter + "numbers ");
		
		int f=1;
		while (f<=counter) {
			System.out.print(fib1+" ");
			int lastTwo = fib1+fib2;
			fib1=fib2;
			fib2 = lastTwo;
			f++;
		}
	}
}
