package com.revature.core;
//Kyle Howard Krug
public class Question4 {

	public String question4(){
		System.out.println("Welcome to question 4!");
		//Computes n factorial
		int n = 9;
		int factor = 0;
		for( int i = 0; i < n ; i++) {
			if(factor == 0) {
				factor = n;
			}else {
				factor = factor * (n-i);
			}
		}
		System.out.println(factor);
		return "Done";
	}
}
