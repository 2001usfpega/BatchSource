package com.revature.strings;

public class FunWithString {
	
	/*
	 * Strings!
	 * not char or Character
	 * NOT A PRIMITIVE
	 * Fully Qualified class name: java.lang.String
	 * String literal is o+ charactwers ex"" or String a ="Go Knights"
	 * Concatenation : .concat()
	 * Strings are Immutable
	 * String pool - collection of unique String literals in heap memory
	 * Some strings are common and used in multiple places within app
	 * String s ="dog"; Compiler searches string pull for "dog"
	 * if it exists it will create a reference to it
	 * if not, it will create a new string literal in the string pool
	 * string a = "dog"; same refe4rence as s
	 * a= a+ "House";
	 * String API has utility methods
	 * String: String pool, Immutable, thread safe, fast
	 * StringBuilder: No string pool, mutable, not thread safe, fast
	 * StringBuffer: No pool, mutable, thread safe, slow
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Go Knights!";
		System.out.println("'");
		System.out.println(s);
		s = "woo";
		System.out.println(s);
		String d = "Go Knights";
		System.out.println(d.charAt(4));
		String a = "Pega";
		String b = a;
		System.out.println(a==b);
				
				
		
	}

}
