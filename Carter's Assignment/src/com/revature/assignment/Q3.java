//reference https://www.javatpoint.com/program-to-swap-two-string-variables-without-using-third-or-temp-variable

package com.revature.assignment;

public class Q3 
{

	public static void main(String[] args) 
	{
		String word1 = "Running";
		String word2 = "Program";
		
		//the first sentence as normal
		System.out.println("Is this " + word1 + " " + word2);
		
		//takes both the string word 1 and word2 and stores them into word1
		word1 = word1 + word2;
		
		//extracts or pulls word2 first from the storage of word1
		word2 = word1.substring(0,(word1.length() - word2.length()));
		
		//extracts or pulls word1 second from the storage of word1
		word1 = word1.substring(word2.length());
		
		//prints the first sentence with two words switched
		System.out.println("Is this " + word1 + " " + word2);
	}

}
