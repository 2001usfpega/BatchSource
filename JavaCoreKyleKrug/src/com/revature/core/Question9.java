package com.revature.core;
//Kyle Howard Krug
import java.util.ArrayList;

public class Question9 {

	public String question9() {
		System.out.println("Welcome to question 9!");
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++) {
			//loads array list with integers from 1 to 100
			num.add(i);
		}
		for(int j : num) {
			if(check(j)== false) {
				System.out.print(j +" ");
			}
		}
		return "Done";
	}
	
	public static boolean check(int i) {
		//checks for prime numbers and returns true or false
		for( int j = 2; j <= i/2; j++) {
			if( i % j == 0) {
				return true;
			}
		}
		return false;
	}
}
