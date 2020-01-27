package com.revature.coreassignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] letsSwitch) {
		System.out.println("Yay cases");
		System.out.println("Choose your case...");
		System.out.println("Option 1: Square Root");
		System.out.println("Option 2: Today's Date");
		System.out.println("Option 3: String Array...Yay");
			Scanner ugh = new Scanner(System.in);
			Scanner keyboard = new Scanner (System.in);
			char choice = ugh.nextLine().charAt(0);
			switch(choice) {
			case'1':
				double k = 25;
				System.out.println(Math.sqrt(k));
			break;
			
			case'2':
				LocalDate today = LocalDate.now();
				System.out.println("Today is " + today);
			break;	
			
			
			case'3':
				String core = "“I am learning Core Java";
				String[] strSplit = core.split(",");
				List<String> coreList = Arrays.asList(strSplit);
				System.out.println(coreList);
			break;	
	}
		
	}
			
	}

//this is the same idea I used for my banking applicaiton
//the switch case makes it possible to make multiple branching
//paths that will do the three differet actions
//referenced how to get the date from https://www.w3schools.com/java/java_date.asp
//split array from https://javadevnotes.com/java-split-string-into-arraylist-examples