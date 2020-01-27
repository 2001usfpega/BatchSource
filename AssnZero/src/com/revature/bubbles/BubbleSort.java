package com.revature.bubbles;

public class BubbleSort {
	static int[] myArr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

	public static int[] bubbleSorter(int[] arr) {
		int n = arr.length;
		int dummy = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					dummy = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = dummy;
				}

			}
		}
		return arr;
	}

	
}
