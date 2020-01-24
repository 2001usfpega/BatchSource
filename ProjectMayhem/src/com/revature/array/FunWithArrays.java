package com.revature.array;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		//when an Array is initialized must give it a size
		int[] myArray = new int[7];
		//hardcode values
		int myOtherArray [] = {2, 5, 1223, 45, 98888, 43029, 27, 74, 1019929 };
		//doesn't help me!
		System.out.println(myOtherArray.toString());
		//Arrays class!  has the utility methods for arrays.
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray[4]);
		
		for (int i = 0; i < myOtherArray.length; i++) {
			myOtherArray[i]=myOtherArray[i]*7;
		}
		System.out.println(Arrays.toString(myOtherArray));
		
		for(int i : myOtherArray) {
			System.out.print(i+", ");
		}
	
}
}
