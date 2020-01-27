//reference https://www.geeksforgeeks.org/bubble-sort/


package com.revature.assignment;

//Question Number
public class Q1 
{
	void bubbleSort(int arr[]) 
	{
		int n = arr.length;
		
		for(int i = 0; i < n-1; i++) 
		{
			for(int j = 0; j < n-i-1; j++) 
			{
				if(arr[j] > arr[j+1]) 
				{
					//swap array[j+1], and array[i]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		} 	
	}
	
	// Prints
	void runArray(int arr[]) 
	{
		int q = arr.length;
		for(int i = 0; i < q; ++i) 
		{
			System.out.print(arr[i] + "");
			System.out.println();
		}	
	}	
	
	//Runs Method
	public static void main(String[] args) 
	{
		Q1 ob = new Q1();
		int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		ob.bubbleSort(arr);
		System.out.println("All is in order");
		ob.runArray(arr);

	}

}
