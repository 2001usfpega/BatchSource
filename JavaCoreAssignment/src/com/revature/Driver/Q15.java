package com.revature.Driver;

public class Q15 implements Q15OperationInterface{

	@Override
	public double addition(double a, double b) {
		
		return a+b;
	}
	@Override
	public double subtraction(double a, double b) {
		
		return  a - b ;
	}
	@Override
	public double multiplication(double a, double b) {
		
		return a * b;
	}
	@Override
	public double division(double a, double b) {
		if (b == 0 )
			return 0;
		return  a / b ;
	}
}
