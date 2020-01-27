package com.revature.coreassignment;

public class Reverse {
	public static void main (String [] bettyWhite){
	String reverse = "2001 Pega Batch is the Best";
	for (int i = 0; i < reverse.length(); i++) {
	    reverse = reverse.substring(1, reverse.length() - i)
	        + reverse.substring(0, 1)
	        + reverse.substring(reverse.length() - i, reverse.length());
	    System.out.println(reverse);
	 }
}	
}

/*
 * referenced from https://stackoverflow.com/questions/7612396/reverse-string-in-java-without-using-any-temporary-string-char-or-string-builder
 * This code uses a simple for loop to set the conditions
 * the substring method uses the length and start, end in substring to 
 * reverse the order.
 */