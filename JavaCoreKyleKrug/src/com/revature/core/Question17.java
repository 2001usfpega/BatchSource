package com.revature.core;
//Kyle Howard Krug
import java.util.Scanner;

public class Question17 {

	public String question17() {
		System.out.println("Welcome to question 17!");
		double go = interestRate();
		System.out.println(go);
		return "Done";
	}
	
	public static double interestRate() {
		double interest = 0;
		double principal = 0;
		double time = 0;
		double rate = 0;
		//prompts user for input
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the principal: ");
		principal = in.nextDouble();
		System.out.println("Enter the time:  ");
		time = in.nextDouble();
		System.out.println("Enter the rate:  ");
		rate = in.nextDouble();
		interest = principal * rate * time;//calculates interest
		in.close();
		return interest;
		
	}
}
