package com.revature.Answer;

import java.util.Scanner;

public   class Q3Solved {
	
	
	public   void reverse(String arg) {
		char[] myString= arg.toCharArray();
		
		
		for (int i= myString.length-1 ; i>=0 ; i--) {
			 System.out.print(myString[i]);
			
			
			
		}
		
	}

}
