package com.revature.strange;

public class FunWithStrings {
	
	/*
	 * Strings!
	 * not char or Character
	 * NOT A PRIMITIVE
	 * fully Qualified class name.java.lang.String
	 * String literal is 0+ characters x "" or string a="Roll Tide";
	 * concatenate strings with + /concat()
	 * "goodbye" + "earth"
	 * strings are immutable
	 * Strings pool - collection of unique String literals in heap memory
	 * some strings are common and used in mult places within app
	 * String s= "dog"; compiler searches strings pool for dog 
	 * if it exists, it will create a new reference to it 
	 * if it does not exist, it will create a new string literal in the string pool 
	 * string a= "dog", same reference as s
	 * a=a+ "house";
	 * String API has utility methods!
	 * String - string pool, immutable, thread safe, fast
	 * String Builder- no string pool, Mutable not thread safe, safe
	 * stringBuffer- no string pool, mutable, thread safe, slow
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "Roll Tide";
		System.out.println(s.hashCode());
		System.out.println(s);
		s="woo";
		System.out.println(s);
		System.out.println(s.hashCode());
		String d= "Roll Tide";
		System.out.println(s.hashCode());
		System.out.println(s.charAt(6));
		String a= "Pega";
		String b = a;
		System.out.println(a==b);
		
		
	}

}
