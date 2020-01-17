package com.revature.corejavaassignment;

public class SubString {
	
	static void subStringMethod(String str, int idx) {
		//iterate over the string
		for(int i=0; i <= idx-1; i++) {
			//print out each char in the array
			System.out.print(str.charAt(i));
		}
	}

}
