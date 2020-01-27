package com.revarure.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// give it a size
		int[] myArray = new int[7];
		// hardcode values
		int[] myOtherArray = { 2, 3, 6, 53, 478, 52, 75, 835, 19 };
		// does not help
		// System.out.println(myOtherArray.toString());

		// Arrays class
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray[4]);

		for (int i = 0; i < myOtherArray.length; i++) {
			myOtherArray[i] *= 7;
		}
		for (int i : myOtherArray) {
			System.out.print(i+" ");
		}
		
		//System.err.println(Arrays.toString(myOtherArray));
	}

}
