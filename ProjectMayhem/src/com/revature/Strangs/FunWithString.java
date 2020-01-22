package com.revature.Strangs;

public class FunWithString {
	/*String
	 * not char or character
	 * not a primituve type
	 * Fully Qualifield class name.loang.String
	 * String literal is 0+ character ex "" or string a="viuhrei";
	 * "goodbye"+"earth" (concatened a String)
	 * String are immutable
	 * 
	 * 
	 * 
	 *   pool- collection of unique string litersl in hesp memory
	 * some strings are common and used in multiple places within app
	 * string s="dog"; compiler searches string pool for "dog"
	 * if it exists,it will create a reference to it,
	 * if it does not exist, it will create a new string literal in the string pool
	 * string a="dog"; same reference as s
	 * a=a+"house";
	 * string API has utility methods
	 * strings - string pool , immutable, thread safe, fast
	 * stringsbuilder- no string pool, mutable , not thread safe, fast
	 * stringbuffer - no string pool , mutable ,thread safe , slow
	 * */

	public static void main(String[] args) {
		
		String s="Roll tide";
		System.out.println(s.hashCode());
		System.out.println(s);
		s="wooo";
		System.out.println(s);
		System.out.println(s.hashCode());
	
		String d="Roll tide";
		System.out.println(d.hashCode());
		System.out.println(d.charAt(6));
		String a="PEGA";
		String b=a;
		System.out.println(s==d);
	}

}
