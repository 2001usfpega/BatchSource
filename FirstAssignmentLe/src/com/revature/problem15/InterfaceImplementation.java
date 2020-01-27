package com.revature.problem15;

public class InterfaceImplementation implements operand {
	public double num1;
	public double num2;
	
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	public double getNum1() {
		return this.num1;
	}
	
	public double getNum2() {
		return this.num2;
	}
	
	public double addition() {
		return this.num1 + this.num2;
	}
	
	public double multiplication() {
		return this.num1 * this.num2;
	}
	
	public double substraction() {
		return this.num1 - this.num2;
	}
	
	public double division() {
		return this.num1 / this.num2;
	}
	
}

interface operand{
	double addition();
	double substraction();
	double multiplication();
	double division();
}