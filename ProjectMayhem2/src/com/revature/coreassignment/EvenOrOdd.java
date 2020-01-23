package com.revature.coreassignment;

public class EvenOrOdd {

	//this sets up for the method isEven to do the math if our number is even or odd
		static boolean isEven(int k) {
		return ((k/2) * 2 == k);	
		}
		//main driver
		public static void main (String[] args) {
			//assigning n 505 and creating an if else statement that 
			//says if n is even isn't false then it should print odd.
			//it has to be set to not false because if it was == to false
			//the code would print even saying that 505 is false
			int k = 505;
			if(isEven(k) != false)
				System.out.println("Even");
			else
				System.out.println("Odd");
		}
	}

