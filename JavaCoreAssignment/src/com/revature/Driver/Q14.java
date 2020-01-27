package com.revature.Driver;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Q14{
	static Scanner input = new Scanner(System.in);
	static String[] splt;
	static int num = 0;

	public void switchCase() {
		
		int num;
		do {
			
			System.out.println("enter 1~4 to select options?");
			System.out.println("1~ Find the square root of a number using the Math class method");
			System.out.println("2~ Display today’s date");
			System.out.println("3~ Split the following string and store it in a string array. “I am learning Core Java”");
			System.out.println("( anything other than 1, 2, and 3 to get out of here ) \n\n");
			num = input.nextInt();
			
			
			switch (num) {
			case 1:
				squareRoot();
				break;
			case 2:
				dateOfToday();
				break;
			case 3:
				splitStr();
				break;
			default:
				System.out.println("bye bye");

			}
		} while ( num==1 || num==2 || num ==3);
		
	}
	
	public static void squareRoot() {
		System.out.println("Which number's square root do u want to compute?");
		Double num = input.nextDouble();
		System.out.println("the square root of " + num + " is: " + Math.sqrt(num) +"\n");
	}
	
	public static void dateOfToday() {
		Date today = Calendar.getInstance().getTime();
		System.out.println("today's data is: " + today + "\n\n\n");
	}
	
	
	public static void splitStr() {
		String str = "I am learning Core Java";
		
		splt = str.split(" ");
		
		for (int i = 0 ; i< splt.length; i++) {
			System.out.print( splt[i] + "     ");
		}
		System.out.println();
		
	}
	
	
	
	
	
	

}