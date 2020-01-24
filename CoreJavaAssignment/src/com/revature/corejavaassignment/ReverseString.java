package com.revature.corejavaassignment;

public class ReverseString {
	
	static char [] reverseStringMethod(String s) {
	// create a char array of the characters in the variable string
	char value[] = s.toCharArray();
	char output [] = new char[value.length];
	int x = 0;
	// iterate backwards over the char array
	for (int i = value.length - 1; i >= 0; i--) {
		// print out the char in each spot
		System.out.print(value[i]);
		output[x] = value[i];
		x++;
	}
	System.out.println();
	return output;
}
}
