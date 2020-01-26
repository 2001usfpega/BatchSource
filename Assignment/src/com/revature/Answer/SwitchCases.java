package com.revature.Answer;

import java.util.Date;

import javax.xml.crypto.Data;

public class SwitchCases {

	
	public  static void casesOfWitch(int num, int num2) {
		// this is a switch method with 2 parameter the first is for the number of case and the second y validate  case 1
		switch (num) {
		// case 1 print the square root of a number using tha Math class function called (sqrt)
  case 1:
		System.out.println("the square root of "+ num2 +" is "+ Math.sqrt(num2));
		break;
  case 2:
	  Date today=new Date();
	  System.out.println("Today date is "+ today);
	  
	  break;
  case 3 :
	  //Case 3: Split the following string and store it in a string array. “I am learning Core Java”
    	
	  String str= "I am learning Core Java"; // store the String in a String variable
	  String[] newStr=str.split(" ");        // using the split funcion in the String Class, tha Split a string depending the criteria in this case by space " "
	                                        // and add it to a new array of string
	  for (int i = 0; i < newStr.length; i++) {// then i use a for loop to print out each position of the new array
		  System.out.println(newStr[i]);
	}
	 
	    
	  break;
		default:
			break;
		}
		
	}
	
}
