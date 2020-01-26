package com.revature.q18;

public class SubClass  extends Superclass{
	/* Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass
	 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
	 * 1.Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	  * 2.Convert all of the lower case characters to uppercase in the input string, and return the result.
	  * 3.	Convert the input string to integer and add 10, output the result to the console.
	  */
	
	

	@Override
public	boolean checkUpper(String str) {
		int counter=0;
		boolean upper=false;
		
		while(counter< str.length()&&(upper==false)) {// this loop is going to iterate until it find a upper case in the string imputed
	
			
		 if (Character.isUpperCase(str.charAt(counter))) // i used the static method isUpperCase from Character Class to determine if  the character contain in the string un a position is a Upper case 
			upper=true;
			counter++;
		
		}
			
		return upper;
	}

	@Override

public	String getAllUpper(String str) {
	
		String upcase=str.toUpperCase();// i create a new String variable where im going to save the new Uppercase string by using the toUpperCase method that return a String of Uppercases
		
		return upcase;
	}

	@Override
public	Integer stringToInt(String str) {
		//System.out.println(str);
		int str1 = 0;
		int val=10;
		
		//this function converts string in integer
		
		 str1= Integer.valueOf(str);
		 val=10+str1;
		
			return val;
	}
	
	

}
