package com.revature.Driver;

import java.util.ArrayList;

public class Q12 {
	
	public int[] enhancedForLoop() {
		
		int[] intArray = new int[100];
		
		for (int i=0; i<100; i++) {
			intArray[i] = i + 1;
		}
		
		
		ArrayList <Integer> ansList = new ArrayList<Integer> ();
		
		
		for (int eachInt : intArray) {
			if ((eachInt & 0x0001 ) == 0) {
				ansList.add(eachInt);
			}
		}
			
		int [] ans = new int[ansList.size()];
		for (int i=0; i<ansList.size(); i++) {
		ans[i] = ansList.get(i);
		}
		return ans;
	}
}
