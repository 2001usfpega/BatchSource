package com.revature.Driver;

import java.util.Scanner;

public class Q17 {
	
	Scanner scanner = new Scanner(System.in);

	public void fromCustomer() {
		
		Double deposit, rate, year;
		
		System.out.println("How much is your deposit? ");
		deposit = scanner.nextDouble();
		System.out.println("what is your rate? ");
		rate = scanner.nextDouble();
		System.out.println("How many year?? ");
		year = scanner.nextDouble();
		
		System.out.println("you wil have " + deposit * rate * year + " interest after " + year +" years.");
		
		
		
		
	}
	
	
	
	
	
	
}
