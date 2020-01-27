//reference https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
package com.revature.assignment;

import java.util.Arrays;
import java.util.List;


public class Q8 
{
	//grabs a word reads for potential Palindrome
	static boolean isPalindrome(String boo) 
	{
		int gen = boo.length();
		
		for(int k = 0; k < gen/2; k++) 
		{
			if(boo.charAt(k) != boo.charAt(gen-k-1)) 
			{
				return false;
			}
		}
		return true;
	}
	
	static boolean checkPalindromePair(List<String> vect) 
	{
		//runs a check for a word to see if it reads forwards and backwards
		for(int v =0; v<vect.size()-1; v++) 
		{
			for(int r = v+1; r< vect.size(); r++) 
			{
				String check_boo = "";
				
				check_boo = check_boo + vect.get(v) + vect.get(r);
				
				if(isPalindrome(check_boo)) 
				{
					return true;
				}
				
				check_boo = vect.get(r) + vect.get(v);
				
				if(isPalindrome(check_boo)) 
				{
					return true;
				}
			}
		}
		return false;
	}
	//Prints yea or nah if the word is a Palindrome or not
	public static void main(String[] args) 
	{
		List<String> vect = Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		
		if(checkPalindromePair(vect) == true) 
		{
			System.out.println("yea");
		}
		else 
		{
			System.out.println("nah");
		}

	}

}
