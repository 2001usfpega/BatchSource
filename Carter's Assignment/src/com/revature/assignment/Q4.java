//reference https://www.geeksforgeeks.org/program-for-factorial-of-a-number/

package com.revature.assignment;

public class Q4 
{
	//calculates the starting number down till the last number in the factorial
	static int factorial(int q) 
	{
		if (q == 0) 
		{
			return 1;
		}
		
		//takes number and counts down to 1 and gets the total
		return q*factorial(q-1);
	}
	
	public static void main(String[] args) 
	{
		// prints number and calculates its factorial
		int run = 5;
		System.out.println("Factorial of " + run + " is " + factorial(5));
		
		int jog = 6;
		System.out.println("Factorial of " + jog + " is " + factorial(6));
	}

}
