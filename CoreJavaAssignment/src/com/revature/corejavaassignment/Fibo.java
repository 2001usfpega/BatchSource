package com.revature.corejavaassignment;

public class Fibo {

	static int n1 = 0;
	static int n2 = 1;
	static int n3;
	static int[] fibonacci = new int[25];
	// the number of times the program needs to run is in "count"
	static int count = 25;

	public static int[] fiboMethod() {
		for (int i = 2; i < count; ++i) {
			fibonacci[0] = 0;
			fibonacci[1] = 1;
			// get the sum of the first two numbers
			n3 = n1 + n2;
			// put the result into the fibonacci sequence at index i.
			fibonacci[i] = n3;
			// move to the next set of two numbers in the sequence recursively
			n1 = n2;
			n2 = n3;
		}
		return fibonacci;
	}
}
