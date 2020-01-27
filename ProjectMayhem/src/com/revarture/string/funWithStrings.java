package com.revarture.string;

public class funWithStrings 
{
	/*
	 * Strings
	 * Not char or Character
	 * NOT A PRIMITIVE
	 * fully qualified class name:jaa.lang.String
	 * String literal is 0+ character ""
	 * concatenate string w/ + . concat()
	 * String are immutable
	 * string pool is a collection of unique String literals in heap memory
	 * some string are common and used in multi places within app
	 * string s = dog compiler searches string pool for dog
	 * if it exists it will create a refer to it
	 * not exist it will create a new string literal in string pool 
	 * string = dog same as s
	 * a = a+"house"
	 * String API has utility methods
	 * String - String immutable, thread safe, fast
	 * String builder - no pool, mutable, not safe, fast
	 * String buffer - no string pool, mutable, safe, slow
	 * 
	 * 
	 * */

	public static void main(String[] args) 
	{
		String s = "Roll Tide";
		System.out.println(s.hashCode());
		System.out.println(s);
		s="woo";
		System.out.println(s);
		System.out.println(s.hashCode());
		String d = "Roll Tide";
		System.out.println(d.hashCode());
		System.out.println(d.charAt(6));
		String a ="Pega";
		String b = a;
		System.out.println(a==b);
	}

}
