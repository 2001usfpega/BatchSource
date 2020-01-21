package com.revature.questions;

import java.util.Scanner;

public class Interest {
	


	public static double calcInt() {
		System.out.println("Type in 3 numbers one for the Principle one" +
				"one for the Rate and one for the Time");
		double p, time, rate, result;
		Scanner scan = new Scanner(System.in);
		
		
		p = scan.nextDouble();
		time = scan.nextDouble();
		rate = scan.nextDouble();
		
		result = p * rate * time;
		return result;
		
	}
	
	public static double calcInt(double p, double time, double rate) {
		double result = p * rate * time;
		return result;
	}
}
