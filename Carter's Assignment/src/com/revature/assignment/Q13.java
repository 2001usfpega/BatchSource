//reference https://stackoverflow.com/questions/11409621/creating-a-triangle-with-for-loops
package com.revature.assignment;

public class Q13 
{

	public static void main(String[] args) 
	{
		//add 1 to end of the line
		for(int i = 0; i < 6; i++) 
		{
			//add 0 until j is no longer less than i
			for(int j = 0; j < i; j++) 
			{
				System.out.print("0");
			}
			System.out.println("1");
		}

	}

}
