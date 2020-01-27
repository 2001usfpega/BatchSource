package com.revature.arrays;

import java.util.Arrays;

public class FunWithArray {

	public static void main(String[] args) {
		//give it a size
		int [] myArray = new int [7];
		//hardcode values
		int myOtherArray[]= {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,4,5,45,4};
		// doesnt help me
		System.out.println(myOtherArray.toString());
		//Array Class!
		System.out.println(Arrays.toString(myOtherArray));
		System.out.println(myOtherArray[4]);
		
		for (int i=0; i<myOtherArray.length; i++) {
			myOtherArray[i]= myOtherArray[i]*7;
		}
		System.out.println(Arrays.toString(myOtherArray));
		for(int i : myOtherArray) {
			System.out.println(i);
		}
	}

}
