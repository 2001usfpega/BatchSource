package com.revature.questions;

import java.util.Date;

public class CaseSwitch {

	
	
	
	public static void caser(int i) {
		switch(i){
		case 1:squareRoot();
			break;
		case 2:dispDate();
		break;
		case 3: splitString();
		break;
		default:
			System.out.println("I don't know!");
			break;
		}
		
	}
	
	public static void squareRoot() {
		double num = 9;
		
		System.out.println("the square root of 9 is " + Math.sqrt(num));
		
	}
	
	public static void dispDate() {
		Date date = new Date();
		
		System.out.println(date);
	}
	
	public static void splitString() {
		
		String sent = "I am learning Core Java";
		
		String[] strArr = sent.split(" ");
		
		for(int i =0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
				
	}
	
}
