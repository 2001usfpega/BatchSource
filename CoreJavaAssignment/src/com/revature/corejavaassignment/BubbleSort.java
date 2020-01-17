package com.revature.corejavaassignment;

public class BubbleSort {

	static void bubbleSort(int[] arr) {
		int temp = 0;
		//iterate over the array once
		for (int i = 0; i<arr.length; i++) {
			//iterate over the array a second time in nested for loop
			for (int j = 1; j < (arr.length - i); j++) {
				//compare the number @ j to the number to the left of j(j-1)
				if (arr[j - 1] > arr[j]) {
					//If the number to the left of j is greater move it to j
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
