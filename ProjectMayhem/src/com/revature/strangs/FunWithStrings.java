package com.revature.strangs;

public class FunWithStrings {
	/*
	 * Strings!
	 * not char or Character
	 * NOT A PRIMITIVE
	 * String Literal - is 0 to many characters ex "bla bla"
	 * Concatenate strings using the + and .concat()?
	 * Strings are immutable - cannot be changed?
	 * 
	 * String Pool - collection of unique String literals in heap memory
	 * current memory tank thats being used for the 
	 * Java program you're running.
	 * go look up stack vs heap
	 * Why have a string pool
	 * because some strings are common and used in multiple places.
	 * for example String word = "hello" and string word2 = "hello"
	 * will be saved into the same memory place
	 * or have the same reference
	 * 
	 * when we reassign a string value to a variable 
	 * the previous values reference will remain.
	 * 
	 * ex String s= "woo"
	 * 		s= "hello"
	 * 		String d = "woo"
	 * d will have the same reference as s when it was "woo"
	 * "woo"s reference remains in the String pool
	 * StringBuilder - no string pool, mutable, not thread safe, fast
	 * StringBugger - No String pool, mutable thread safe, slow
	 * 
	 * Need to understand threads
	 * 
	 * Thread safe means that the value of the string isn't
	 * changing as it moves through threads
	 * 
	 * Not thread safe means that the same int can change value as
	 * it moves through threads.
	 * 
	 * String API has utility methods like charAt();
	 * String - String Pool, Immutable, thread safe, fast
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
