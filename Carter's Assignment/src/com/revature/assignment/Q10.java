//reference https://www.geeksforgeeks.org/program-to-find-the-largest-number-using-ternary-operator/
package com.revature.assignment;

public class Q10 
{

	public static void main(String[] args) 
	{
		int c1 = 5, c2 = 10, min;
		//judges if the number is smaller than the larger number
		min = (c1 < c2) ? c1 : c2;
		
		System.out.println("Smallest number between " + c1 + " and " + c2 + " is " + min + ". ");

	}

}
