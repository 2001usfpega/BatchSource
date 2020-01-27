package com.revature.Driver;

public class Q1 {
	
	
	
	public int[] bubbleSort(int ...v) {
		
		int[] intArray = new int[v.length];
		
		for (int i = 0; i < v.length; i++ ) {
			intArray[i] = v[i];
		}
		
		
		for (int i=0; i<v.length -1 ; i++) {
			
			for (int j=i+1; j< v.length; j++) {
				if ( intArray[i] > intArray[j] ) {
					int temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
		}

		return intArray;
	}
	
}
