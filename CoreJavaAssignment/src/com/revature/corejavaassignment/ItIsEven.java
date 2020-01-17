package com.revature.corejavaassignment;

public class ItIsEven {

	static void isEven(int n) {
		// take the passed in parameter and divide by 2
		int quotient = n / 2;
		// create logic to mulitply the result by 2
		// if the product is the original passed in parameter then the number is even
		if (quotient * 2 == n) {
			System.out.println("This numbrer is EVEN, Steven!");
		}
	}
}
