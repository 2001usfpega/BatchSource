package com.revature.core;
//Kyle Howard Krug
public class Question3 {

	public String question3() {
		System.out.println("Welcome to question 3!");
		//reverses a string
		String str = "hello";
		for(int i = str.length()-1; i>= 0; i-- ) {
			System.out.print(str.charAt(i));
		}
		return "Done";
	}
}
