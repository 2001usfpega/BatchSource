package com.revature.coreassignment;


public class Terinary {
	public static void main (String [] gettingTired){
		@SuppressWarnings("unused")
		int n1 = 7, n2 = 14, max, min;

		max = (n1 > n2) ? n1 : n2;

		System.out.println("Biggest number between " + n1 + " & " + n2 + " is " + max + ". ");

		min = (n2 < n1) ? n2 : n1;
		
		System.out.println("The smallest number between " + n1 + " & " + n2 + " is " + min + ". ") ;
	}
}
// reference https://www.geeksforgeeks.org/program-to-find-the-largest-number-using-ternary-operator/
//The ternary acts as a simple if statement and compares the numbers to see which is smaller
//and which is bigger.