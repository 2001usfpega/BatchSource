package com.revature.corejavaassignment;

public class Driver {

	public static void main(String[] bettyWhite) {
		// bubblesort
		int[] newArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Array prior to Bubble Sort: ");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.println();
		BubbleSort.bubbleSort(newArray);
		System.out.println("Array after Bubble Sort: ");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}

		// Fibonacci
		int n1 = 0;
		int n2 = 1;
		int n3;
		// number of times the program needs to run is in "count"
		int count = 25;
		// putting the answer on a new line
		System.out.println();
		// printing out "0" and "1" - the first two numbers in the Fibonacci sequence
		System.out.print(n1 + " " + n2);
		for (int i = 2; i < count; ++i) {
			// get the sum of the first two numbers
			n3 = n1 + n2;
			// print the sum of the first two numbers
			System.out.print(" " + n3);
			// move to the next set of two numbers in the sequence recursively
			n1 = n2;
			n2 = n3;
		}

		// ReverseString
		// Revature Boot Camp Rocks my world...
		String string = "Revature Boot Camp ROCKS!!";
		// create a char array of the characters in the variable string
		char value[] = string.toCharArray();
		// put the answer on the next line of the console
		System.out.println();
		// print out the string for comparative purposes
		System.out.println(string);
		// iterate backwards over the char array
		for (int i = value.length - 1; i >= 0; i--) {
			// print out the char in each spot
			System.out.print(value[i]);
		}

		// Factorial
		// establish the variable to hold the number to factorial
		int exp = 12;
		// print the answer on a fresh line
		System.out.println();
		// print the factorial of 12 calling the factorial() form the Factorial class
		System.out.println("Factorial of " + exp + " is " + Factorial.factorial(exp));

		// Substring
		//Matt - I wrote this one without much help (Parker told me about charAt());
		//it feels pretty good
		String sentence = "How now, Brown Cow?";
		int a = 7;
		SubString.subStringMethod(sentence, a);

		//EvenSteven
		//creating a variable to pass into the even checking method
		int number = 3479654;
		//putting the answer on its own line
		System.out.println();
		//calling the method and passing in the variable
		ItIsEven.isEven(number);
		
	}
}
