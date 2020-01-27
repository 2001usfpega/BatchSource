package com.revature.strangs;

public class FunWithStrings {
	/*
	 * Strings!
	 * not a char or CHARACTER
	 * NOT A PRIMATIVE
	 * FULLY QUALIFIED CLASS name:java.lang.String 
	 * String literal is 0+ chracter ex "" or STRING a = "roll tide"
	 * concatenate strings w/ + .cincat()
	 * "goodbye" + "earth"
	 * Strings are immutable
	 * String pool - collection of unique String literals in heap memory
	 * some strings are common and used in mult places within app
	 * Strings = goog; compiler searches string pool for "dog
	 * if it exsist, it willl create a ref. to it,
	 * it it does not exsist, it will create a new strimgliteral in the string pool
	 * string a= dog; same ref. as a a=a+"house"
	 * String API has utility methods
	 * String- Sting Pool, Immutable, thread safe, fast
	 * StringBuilder- No string pool, mutable,not thread safe,fast
	 * StringBBuffer- No string pool, mutable,thread safe,slow
	 * 
	 */ 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Roll Tide";
		System.out.println(s.hashCode());
		System.out.println(s);
		s = "woo";
		System.out.println(s);
		System.out.println(s.hashCode());
		String d = "Roll Tide";
		System.out.println(d.hashCode());	
		System.out.println(d.charAt(6));
		String a= "Pega";
		String b= a;
		System.out.println(a==b);
	}

}
