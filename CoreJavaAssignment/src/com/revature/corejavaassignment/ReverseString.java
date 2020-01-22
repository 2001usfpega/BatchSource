package com.revature.corejavaassignment;

public class ReverseString {
	
	static char [] reverseStringMethod(String s) {
	// create a char array of the characters in the variable string
	char value[] = s.toCharArray();
	// put the answer on the next line of the console
	System.out.println();
	// print out the string for comparative purposes
	System.out.println(s);
	// iterate backwards over the char array
	for (int i = value.length - 1; i >= 0; i--) {
		// print out the char in each spot
		System.out.print(value[i]);
	}
	return value;
}
}
