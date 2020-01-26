package com.revature.core;
//Kyle Howard Krug
import java.util.ArrayList;

public class Question19 {

	public String question19() {
		System.out.println("Welcome to question 19!");
		int sumEven = 0;
		int sumOdd = 0;
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			num.add(i);
		}
		for(int j : num) {
			if (j %2 == 1) {
				sumOdd = sumOdd + j;
			}else {
				sumEven = sumEven + j;
			}
		}
		System.out.println("Even sum is : " + sumEven);
		System.out.println("Odd sum is : " + sumOdd);

		for(int k = 0; k < num.size(); k++) {
			if(check(k)== true) {
				//needs a check for any execpetions that may be throw from deleteing an element of teh array list
				num.remove(k);
			}
		}
		System.out.print(num);
		return "Done";
		
		
	}
	public static boolean check(int i) {
		for( int j = 2; j <= i/2; j++) {
			if( i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
