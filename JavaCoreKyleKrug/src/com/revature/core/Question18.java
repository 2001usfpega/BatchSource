package com.revature.core;
//Kyle Howard Krug
abstract class abs{
	//establishes an abstract class with the three required methods
	public boolean uppercase(String str) {
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if(Character.isUpperCase(character)) {
				return true;
			}
		}
		return false;
	}
	public String conLower(String str) {
		String newStr="";
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if(Character.isUpperCase(character)) {
				newStr = newStr + Character.toLowerCase(character);
			}
		}
		return str;	
	}
	public int convert(String str) {
		int i = Integer.parseInt(str) + 10;
		return i;
	}
}
public class Question18 extends abs{
	//extends the abstract class
	public String question18() {
		System.out.println("Welcome to question 18!");
		Question18 a = new Question18();
		System.out.println(a.conLower("HElloThere"));
		System.out.println(a.uppercase("Hello"));
		System.out.println(a.uppercase("hello"));
		System.out.println(a.convert("100"));
		return "Done";
		
	}

}
