package com.revature.strangs;

public class FunWithStrings {
	/*
	 * Strings!!!!
	 * Not char or Character
	 * NOT A PRIMITIVE
	 * Fully qualified class name:java.lang.String 
	 * string literal is 0+ characters ex "" or string a="Roll Tide"
	 * concatenate strings w/ + .concat()
	 * "goodbye" + "earth"
	 * Strings are immutable 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		String s = "Roll Tide";
		System.out.println(s);
		s = "Woo";
		System.out.println(s);
		String d = "Roll Tide";
		System.out.println(s + s);
		String a="Pega";
		String b=a;
		System.out.println(a==b);
		
		
				

	}

}
