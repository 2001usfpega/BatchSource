package com.revature.bubble;

public class BubbleSort {
	
static void Q1 (int [] bub) {
	int x = bub.length; // size of array
	int fill = 0; //temporary fill in value
	for (int b=0; b < x; b++) { 
		for (int l=1; l<(x-b);l++) { //element value comparisons
			if(bub[l-1] > bub[l]) {
				
				fill = bub[l-1];   //moving through array elements
				bub[l-1] = bub[l];
				bub[l] = fill;
			}
		}
	
	}
}	
	static void Q2 () {
		int a = 0; // set first two values
		int b = 1;	
		for (int f=0; f<=25; f++) { //set counter for 25 sequences
		System.out.print(a + ", ");
		int next = a + b; // creating a sum variable
		a = b; 
		b = next;
		
		}
	}

	public static void main(String [] hereWeGo) {
		int bub[] ={1,0,5,6,3,2,3,7,9,8,4};// original array
		
		Q1(bub); // call on bubble sort method
	
		for(int b=0; b<bub.length; b++) { //print out ordered
			System.out.print(bub[b] + " ");
		}
	}
	

}


