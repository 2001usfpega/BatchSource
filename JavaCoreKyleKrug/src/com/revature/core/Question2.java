package com.revature.core;
//Kyle Howard Krug
public class Question2 {
	public String question2(){
		
	System.out.println("Welcome to question 2");
		int num1=0;
		int num2=1;
		
		for(int i = 0; i < 24;i++ ) {
			//prints out the fibonacci sequence
			System.out.print(num1 + " ");
			int sum = num1 + num2;
			num1=num2;
			num2= sum;
		}
		return "Done";
			
	}
}

