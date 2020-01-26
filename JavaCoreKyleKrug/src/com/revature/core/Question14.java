package com.revature.core;

import java.util.Date;
import java.util.Scanner;
//Kyle Howard Krug
public class Question14 {
	public String question14() {
		System.out.println("Welcome to question 14!");
		Scanner in = new Scanner(System.in);
		//prompts user for input
		System.out.println("Enter your choice for case statement[1,2,3]");
		int c = in.nextInt();
		switch(c) {
		//depending on the imput it will print out the case
		case 1:
			System.out.println("SQUARE ROOT OF 144: " + Math.sqrt(144));
			break;
		case 2:
			Date date = new Date();
			System.out.println("Todays date is : " +date);
			break;
		case 3:
			
			String tosplit = "I am learning core java";
			System.out.println(tosplit);
			String [] str = tosplit.split(" ");
			for( String i : str) {
				System.out.print(i + "|");
			}
		default:
			break;

		}
		return "Done";

		
		
	}

}
