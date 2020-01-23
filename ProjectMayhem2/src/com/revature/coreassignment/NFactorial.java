package com.revature.coreassignment;
//this is the class
public class NFactorial {
	//here we are declaring int MATH and passing parameters
	static int MATH (int luckyNum) {
		//this if statement will check to see if luckyNum is equal to zero
		//if not it will run the retun fromula
		if (luckyNum==0)
			return 1;
		return luckyNum*MATH(luckyNum-1);
	}
	//main method
	public static void main (String [] wolverine) {
		int luckyNum = 7;
		System.out.println("Phew, this is math. Factorial of " + luckyNum + " is " + MATH(7));
	}
	
}
//reference https://www.geeksforgeeks.org/java-program-for-factorial-of-a-number/