package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main (String [] args) {
		//give it a size
		int[] myArray= new int[7];
		//hardcode values
		int myOtherArray [] = {2,5,23,54,13,9,26,78,40};
		//doesn't help me
		System.out.println(myOtherArray.toString());
		//Arrays class!
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray [4]);
		
		for(int i = 0; i<myOtherArray.length; i++) {
			myOtherArray[i]=myOtherArray[i]*7;
			System.out.println(Arrays.toString(myOtherArray));
		}
		for(int i:myOtherArray) {
			System.out.println(i);
		}
		
	}
	
	
}
