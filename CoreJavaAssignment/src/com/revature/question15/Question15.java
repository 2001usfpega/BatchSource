package com.revature.question15;

public class Question15 implements Question15Interface{

	@Override
	public void addition(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
		
	}

	@Override
	public void subtraction(int a, int b) {
		System.out.println(a + " - " + b + " = " + (a - b));
		
	}

	@Override
	public void multiplication(int a, int b) {
		System.out.println(a + " * " + b + " = " + (a * b));
		
	}

	@Override
	public void division(int a, int b) {
		System.out.println(a + " / " + b + " = " + (a / b));
		
	}

}
