package com.revature.coreassignment;

public class SubString {
	//created new new String named str 
	//that passes USF Pega in its parameter
	public static void main (String [] gambit) {
	String str = new String("USF Pega");
//prints string with first sysout
//second sysout prints the 7th spot in the indes of the string
	//which is a
	
	System.out.println("String contains = " + str);
	
	System.out.println("SubSequence = " + str.substring(7));
}
}
//referenced https://www.geeksforgeeks.org/stringbuffer-substring-method-in-java-with-examples/