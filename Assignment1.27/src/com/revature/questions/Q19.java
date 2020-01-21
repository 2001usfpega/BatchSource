package com.revature.questions;

import java.util.ArrayList;

public class Q19 {

	static int evenSum = 0;
	static int oddSum = 0;
	static int primeSum = 0;

	public static ArrayList arrListQuestion(ArrayList<Integer> list) {
		for (int i = 1; i < 11; i++) {
			list.add(i);

		}
		System.out.println("This is the Array List of #s 1-10");
		System.out.println(list.toString());

		for (int i = 0; i < list.size(); i++) {

			int theEvenNums = Integer.valueOf(list.get(i).toString());
			if (theEvenNums % 2 == 0) {
				evenSum += theEvenNums;
			}
		}
		System.out.println("Here is the sum of the even numbers");

		System.out.println(evenSum);

		for (int i = 0; i < list.size(); i++) {

			int theOddNums = Integer.valueOf(list.get(i).toString());
			if (!((theOddNums % 2) == 0)) {
				oddSum += theOddNums;
			}
		}

		System.out.println("Here is the sum of the odd numbers");
		System.out.println(oddSum);
		
		
		return list;
		

	}

}
