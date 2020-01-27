package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q8;

class TestQ8 {

	@Test
	void test() {
		
		String actualsStr = "";
		String expectedsStr = "ABABA AOAOAOAOA ";
		Q8 test = new Q8();
		ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> palindrome = new ArrayList<String>();
        al.add("ABABA");
        al.add("ABCDA");
        al.add("TOM");
        al.add("AOAOAOAOA");
       
        palindrome = test.splitPalindrome(al);
        
        
        for(int i = 0; i < palindrome.size(); i++) {   
        	actualsStr += palindrome.get(i);
		}
        
        assertEquals(expectedsStr, actualsStr);
        
        
        
        
        
		
		
		
		
		
		
		
	}

}
