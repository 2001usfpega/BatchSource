//reference https://www.geeksforgeeks.org/3-ways-check-number-odd-even-without-using-modulus-operator-set-2-can-merge-httpswww-geeksforgeeks-orgcheck-whether-given-number-even-odd/
package com.revature.assignment;

public class Q6 
{
	static boolean whatEven(int hi) 
	{
		//sets default to true
		boolean whatEven = true;
		//counts 
		for(int y = 1; y <= hi; y++) 
		{
			//whatEven = not true
			whatEven = !whatEven;
		}
		// returns true
		return whatEven;
	}
	
	public static void main(String[] args) 
	{
		int hi = 420;
		// reads number to see it is even or not
		if(whatEven(hi)) 
		{
			//prints out if is even
			System.out.println("Is This Even");
		}

	}

}
