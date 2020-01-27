package com.revature.Driver;



public class Q16 {

	public int numOfCharacters( String[] str) {
		

		int count = 0;
		for (int i=0; i< str.length; i++) {
			count += str[i].length();
		}
		
		return count;
	}
}
