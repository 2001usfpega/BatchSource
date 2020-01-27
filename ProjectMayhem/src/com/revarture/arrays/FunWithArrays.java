package com.revarture.arrays;

import java.util.Arrays;

public class FunWithArrays 
{

	public static void main(String[] args) 
	{
		//give it a size
		int [] myArray = new int[7];
		// hardcode values
		int myOtherArray [] = {14,8,41,8,7,1,8,9,1};
		//doesnt help me
		System.out.println(myOtherArray.toString());
		//Arrays class
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray[4]);
		
		for(int i = 0; i<myOtherArray.length; i++) 
		{
			myOtherArray[i] = myOtherArray[i]*7;
		}
		for(int i:myOtherArray) 
		{
			System.out.println(i);
		}
		System.out.println(Arrays.toString(myOtherArray));
	}

}
