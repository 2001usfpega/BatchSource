package com.revature.Driver;

import java.util.ArrayList;
import java.util.ListIterator;

public class Q8 {
	

	public ArrayList<String> splitPalindrome(ArrayList<String> al) {
		
		
		
        ArrayList<String> listOne = new ArrayList<String>();
		ArrayList<String> listTwo = new ArrayList<String>();
		
		
		

		ListIterator<String> iterator = al.listIterator();
		
		while (iterator.hasNext()) {
			
			String str = iterator.next().toString();
			
			if (  isPalindrome(str ) ) {
				
				listOne.add(str + " ");
			} else {
				
				listTwo.add(str + " ");
			}
			
		}
		
		

			
        return listOne;
	}
	
	static boolean isPalindrome(String str) 
    {   // from  geeksforgeeks.org
  
        // Pointers pointing to the beginning 
        // and the end of the string 
        int i = 0, j = str.length() - 1; 
  
        // While there are characters to compare 
        while (i < j) { 
  
            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) 
                return false; 
  
            i++; 
            j--; 
        } 
  
        // Given string is a palindrome
        return true; 
    } 
	
	
	
	
	
	
	
	
}
