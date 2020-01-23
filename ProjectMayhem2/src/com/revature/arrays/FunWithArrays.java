package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		//give it a saze
		int [] myArray = new int[7];
		//hardcode values
		int myOtherArray[] = {1,4,7,5,2,8,9,4,7,5};
		//doesn't help me
		//System.out.println(myOtherArray.toString());
		//Arrays Class!
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray[4]);
		
		for (int i = 0; i<myOtherArray.length; i++) {
			myOtherArray[i]=myOtherArray[i]*7;
		}
		for(int i:myOtherArray) {
			System.out.println(i);
		}
		//System.out.println(Arrays.toString(myOtherArray));
	}
}
