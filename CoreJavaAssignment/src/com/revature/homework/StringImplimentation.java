package com.revature.homework;

abstract class StringStuff {
	public abstract boolean hasUpper(String s);
	public abstract String toUpper(String s);
	public abstract void addTen(String s);
}

public class StringImplimentation extends StringStuff{

	@Override
	//check if string has uppercase letters
	public boolean hasUpper(String s) {
		String s2 = s.toLowerCase();
		return s2!=s;
	}

	@Override
	//set to upper case
	public String toUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	//add ten to a string
	public void addTen(String s) {
		int x = Integer.parseInt(s);
		x+=10;
		System.out.println(x);	
	}
	
}