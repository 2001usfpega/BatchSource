package com.revature.corejavaassignment;

public class Factorial {

	static int factorial(int n) {
		//establish a variable to hold the starting number
		int res = 1;
		/*initialize the variable i to the value of 1; 
		 *set the condition less than or equal to the passed in parameter;
		 *increment the variable i
		 */
		for (int i = 2; i <= n; i++) {
			//multiply res by the value of i
			//and set the value of res to the product
			res *= i;
		}
		return res;

	}
}
