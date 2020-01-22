package com.revature.corejavaassignment;

public class SubString {

	static char[] subStringMethod(String str, int idx) {
		char[] subString = new char[idx];
		// iterate over the string
		for (int i = 0; i <= idx - 1; i++) {
			subString[i] = str.charAt(i);
		}
		return subString;
	}
}