package com.revature.coreassignment;

public class BubbleSort {
	void bSort(int arr[]) {
		int x = arr.length;
		for (int n = 0; n<x-1;n++)
			for(int k= 0; k<x-1; k++)
				if (arr[k]>arr[k+1]) {
					//this will swap arr[k+1] and arr[x]
					int temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;}
				}
	
	void printArray(int arr[]) {
		int a = arr.length;
		for (int i=0; i<a; ++i)
			System.out.println(arr[i] + "");
		System.out.println();
	}
	
	public static void main(String args[])
	{BubbleSort kb = new BubbleSort();
	int arr[] = {1,5,6,3,2,3,7,9,8,4};
	kb.bSort(arr);
	System.out.println("Array is sorted");
	kb.printArray(arr);
	}
}
//Never heard of Bubble Sort but...
//Learned how to do a bubble sort via https://www.geeksforgeeks.org/bubble-sort/
//changed variables, numbers in the arrays, etc.

