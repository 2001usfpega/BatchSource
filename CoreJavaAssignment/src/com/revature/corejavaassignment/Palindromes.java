package com.revature.corejavaassignment;



public class Palindromes {
	
	static public boolean findPalindrome(String s) {
		//Instantiate the variable
		String reverse = "";
		//iterate over the word from the last letter to the first
		for(int i = s.length()-1; i >= 0; i--) {
			//re-assign the string based on the above for loop
			reverse = reverse+s.charAt(i);
	}
		//use java-functionality for comparison
		if(s.equalsIgnoreCase(reverse)) {
			return true;
		} else {
			return false;
		}
	}
}
