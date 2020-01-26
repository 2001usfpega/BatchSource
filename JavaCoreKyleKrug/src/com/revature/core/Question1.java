package com.revature.core;
//Kyle Howard Krug
public class Question1 {
	public static void bubblesort(int []array) {
		
		System.out.println("Array start sort");
		//sorts the array
		for( int i = 0; i < array.length;i++ ) {
			for(int j = 0; j < i; j++) {
				if( array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		
		}
		System.out.println("Array done sort");
		for( int k = 0; k < array.length; k++) {
			System.out.print(array[k]);
		}
	}
	public String question1(){
		System.out.println("Welcome to question 1!");
		int []array = {1,0,5,6,3,2,3,7,9,8,4};//establishes the array that is going to be sorted
		bubblesort(array);
		return "Done";
	}

}
