package com.revature.classabs;

public class Concrete extends Abstract {

	@Override
	public boolean Uppercase(String str) {
		char [] stra = str.toCharArray(); //create char array stra to store string
		boolean off = false; // Assume not uppercase
		for(int i=0; i < stra.length; i++){// move through char array
            
            //if any character is not in upper case, return false
            if( !off) {
            	off = Character.isUpperCase( stra[i] ); // check to see if character is uppercase
           
            }
            
		}
		return off; //return true or false depending on if it has uppercase
	}

	@Override
	public String Lowercase(String str) {
		
		return str.toUpperCase(); //convert each letter in str to uppercase
	}

	@Override
	public void AddTen(String str) {
		int start = 10; //create variable with value of 10
		char [] opt = str.toCharArray(); //create char array opt
		for(char c: opt) { //move through each char in array
			start = start + c; //add each value of character in opt to start
		}
		System.out.println(start);
	}
}
