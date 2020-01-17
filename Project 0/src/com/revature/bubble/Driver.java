package com.revature.bubble;

import com.revature.bubble.BubbleSort;

public class Driver {

	public static void main(String[] args) {
		int bub[] ={1,0,5,6,3,2,3,7,9,8,4};// original array
		
		for(int b=0; b<bub.length; b++) { //print out unordered
			System.out.print(bub[b] + " ");
		}
		System.out.println();
		
		BubbleSort.Q1(bub);
		
		for(int b=0; b<bub.length; b++) { //print out ordered
			System.out.print(bub[b] + " ");
	}
		System.out.println();
		
		BubbleSort.Q2();
		
		System.out.println();
		
		
		
}

	
}


