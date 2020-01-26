package com.revature.Answer;

import java.util.ArrayList;

public class PrintEvenQ12 {
	
	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 public static void arrayOfEnvenN() {
				
		ArrayList<Integer> numbers=new ArrayList<>();// create a aaray list where im going to fill with number from 1 to 100
		for (int i =0; i <=100; i++) {// a for loop going from 0 to 100 and adding it to my array list called numbers
			numbers.add(i);
				
		}
				       
			for (int x : numbers) { //  for each statement where im going thru the array 
				
			if ((numbers.get(x)%2 )==0) {// asking if the  rest of the division  of array in the index by 2 is zero
				System.out.println(numbers.get(x));//then print that number
				
			}
				
			}
			
}

}
