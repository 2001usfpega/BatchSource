package com.revature.core;
//Kyle Howard Krug
public class Question5 {
	public String question5() {
		System.out.println("Welcome to question 5!");
		System.out.println(method("hello", 2));
		//accpets a string and will print from location 0 to teh entered location
		return "Done";
		
	}
	public static String method(String str, int n) {
		String str1 = "";
		for(int i = 0; i <= n; i++) {
			str1 = str1 + str.charAt(i);
		}
		return str1;
	}

}
