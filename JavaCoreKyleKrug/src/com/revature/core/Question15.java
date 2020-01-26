package com.revature.core;
//Kyle Howard Krug
public class Question15 implements Question15Interface {

	@Override
	public int addition(int a, int b) {
		return a+ b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
		
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
		
	}

	@Override
	public int division(int a, int b) {
		return a/b;
		
	}
	
	public String question15() {
		System.out.println("Welcome to question 15!");
		Question15 a = new Question15();
		//
		System.out.println("Addition :" +a.addition(5, 4));
		System.out.println("Subtraction :" +a.subtraction(5, 4));
		System.out.println("Multiplication :" +a.multiplication(5, 4));
		System.out.println("Division : " + a.division(20, 4));
		return "Done";
		
	}
	

}
