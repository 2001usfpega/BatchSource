package com.revature.bubble;

import java.util.ArrayList;

public class Palindromes {
	
	public static void check() {
		ArrayList<String> norm = new ArrayList<String>(); //string containing all
		
		ArrayList<String> palin = new ArrayList<String>(); // string storing palindromes
		//storing each string in array norm
		norm.add("karen");
		norm.add("madam");
		norm.add("tom");
		norm.add("civic");
		norm.add("radar");
		norm.add("jimmy");
		norm.add("kayak");
		norm.add("john");
		norm.add("refer");
		norm.add("billy");
		norm.add("did");
		
		for(int s = 0; s < norm.size();s++) { //loop through each element in norm
			if(palindrome((String)norm.get(s))) {// checks if current string is a palindrome
				palin.add((String) norm.get(s)); //adds palindrome to palin
			}
		}
		System.out.println("The original array is: "+norm);
		System.out.println("The Palindrome that were discovered are: "+palin);

	}
	
	
		public static boolean palindrome(String pal) {
						
			String reverse = "";
			//reverse the string
			for(int s = pal.length()-1; s>=0; s--) {
				reverse = reverse +pal.charAt(s);
			}
			//check to see if the given string matches reversed string
			
			return pal.equals(reverse);
		}
			
	


}
