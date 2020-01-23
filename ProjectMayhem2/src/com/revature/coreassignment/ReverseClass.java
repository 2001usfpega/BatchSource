package com.revature.coreassignment;

public class ReverseClass {

	public static void main(String[] args) {
		String runItBack = "Java is so fun";
		
		for(int i =0; i < runItBack.length(); i++) {
			runItBack = runItBack.substring(1, runItBack.length()-i)
					+ runItBack.substring(0, 1)
					+ runItBack.substring(runItBack.length() - i, runItBack.length());
			
		System.out.println(runItBack);
		
		}
		}
		

}

//referenced from https://stackoverflow.com/questions/7612396/reverse-string-in-java-without-using-any-temporary-string-char-or-string-builder
//changed variables around