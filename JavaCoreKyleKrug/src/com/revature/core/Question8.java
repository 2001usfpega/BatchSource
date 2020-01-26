package com.revature.core;

import java.util.ArrayList;

public class Question8 {

	public String question8() {
		System.out.println("Welcome to question 8!");
		//checks for palindrones and then saves them to an empty array list
	ArrayList<String> list = new ArrayList<String>();
	list.add("karan");
	list.add("madam");
	list.add("tom");
	list.add("civic");
	list.add("radar");
	list.add("jim");
	list.add("kayak");
	list.add("john");
	list.add("refer");
	list.add("billy");
	list.add("did");
	
	ArrayList<String> p = new ArrayList<String>();
	
	for(String i : list){
		if(check(i) == true) {
			p.add(i);
		}
	}
	
	
	System.out.println("The palindromes are " + p);
	return "Done";
	}
public static boolean check(String str) {
	int j = str.length()-1;
	for(int i = 0; i < j ;i++, j--) {
		if (str.charAt(i)!= str.charAt(j)) {
			return false;
		}
	}
	return true;
	
}

}
