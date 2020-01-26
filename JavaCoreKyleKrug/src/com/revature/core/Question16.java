package com.revature.core;

public class Question16 {
	public String question16 (String [] args) {
		System.out.println("Welcome to question 16!");
		int sum = 0;
		for (int i= 0; i < args.length; i++) {
			sum = sum + Integer.parseInt(args[i]);// sends entered string to parasing
			//then sets it to integer
		}
		System.out.println("Number of Characters is: " + sum);
		return "Done";
	}
}