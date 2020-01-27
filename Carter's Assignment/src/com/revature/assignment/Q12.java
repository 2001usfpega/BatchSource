//reference https://www.tutorialgateway.org/java-program-to-count-even-numbers-in-an-array/
package com.revature.assignment;

import java.util.Scanner;

public class Q12 
{
	private static Scanner sc;
	
	public static void main(String[] args) 
	{
		int Size, i, evenCount = 0;
		sc = new Scanner(System.in);
		
		System.out.print("Please Enter Numberof elements in an array : ");
		
		Size = sc.nextInt();
		// allows the user to input the size of the array
		int[] a = new int[Size];
		
		System.out.print("Please Enter " + Size + " elements of an Array: ");
		//allows the user to enter the number required to fill array
		for(i = 0; i < Size; i++) 
		{
			a[i] = sc.nextInt();
		}
		
		System.out.print("\n List of Even Numbers in this Array are :");
		//sees if the numbers are even
		for(i = 0; i < Size; i++) 
		{
			if(a[i] % 2 == 0) 
			{
				System.out.println(a[i] +" ");
				evenCount++;
			}
		}
		System.out.println("\n Total Number of Even Numbers in this Array = " + evenCount);
	}

}
