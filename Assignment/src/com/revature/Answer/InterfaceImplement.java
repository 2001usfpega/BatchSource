package com.revature.Answer;

import com.revature.operations.MathOperations;

public class InterfaceImplement implements MathOperations {
	
	@Override
	public int addition(int a, int b) {
		
		return a+b;
		
	}

	@Override
	public int subtraccion(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return a%b;
	}

}
