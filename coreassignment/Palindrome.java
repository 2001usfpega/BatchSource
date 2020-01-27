package com.revature.coreassignment;

import java.util.ArrayList;

public class Palindrome {
	public static void main (String [] AHHHHHH) {
	
		ArrayList<String> k = new ArrayList<>();
		
		k.add("karen");
		k.add("madam");
		k.add("tom");
		k.add("civic");
		k.add("radar");
		k.add("sexes");
		k.add("jimmy");
		k.add("kayak");
		k.add("john");
		k.add("refer");
		k.add("billy");
		
		k.forEach(n->{if(palin(n))System.out.println(n);});
	
}
	private static boolean palin(String p) {
		for(int i = 0; i < p.length()-i-1;i++)
			if(p.charAt(i) != p.charAt(p.length()-i-1));
				return false;
				
}
}
///*
// * this code creates an arraylist named k with a type of string and makes a new arraylist
// * the k.add methods add these names to k arraylist
// * from there for each looks through palin and if a character is at 0 and
// * not equal to the length minus 
// *\ 
