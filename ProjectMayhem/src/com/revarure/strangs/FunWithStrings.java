package com.revarure.strangs;

public class FunWithStrings {
	/*
	 * Strings!
	 * not char or Character
	 * NOT A PRIMITIVE
	 * Fully Qualified class name: java.lang.String
	 * String literal is 0+ characters. Ex "" or String a ="Roll Tide";
	 * 	Concatenate Strings 
	 * 		using ".concate()"
	 * 		using "+"
	 * Strings are immutable - cannot change value at that space
	 * 
	 * String pool - collection of unique String literals in heap memory. Search if the current string is 
	 * available or not. If yes, create a reference. If no, create new string literal in the string pool
	 * EX: 	String s = "dog";
	 *		String a = "dog"; SAME REFERENCE as s
	 *		a += "house";		create a new place for it
	 * 
	 * String API has utility methods! like charAt()
	 * String - String Pool, Immutable, thread safe, fast
	 * StringBuilder - No String Pool, Mutable, Not thread safe, fast
	 * StringBuffer  - No String Pool, Mutable, thread safe, slow
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Roll Tide";
		System.out.println(s+" : "+s.hashCode());
		s = "woo";
		String a = new String("Roll Tide");
		System.out.println(a.hashCode());
		System.out.println(s==a);
		
	}

}
