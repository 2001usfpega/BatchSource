//https://www.geeksforgeeks.org/stringbuffer-substring-method-in-java-with-examples/

package com.revature.assignment;

public class Q5 
{

	public static void main(String[] args) 
	{
		//creates an object
		String non = new String("WordsWithinWords");
		//print
		System.out.println("String contains = " + non);
		//get substring start from 6
		//uses substring
		System.out.println("SubSequence = " + non.substring(5));

	}

}
