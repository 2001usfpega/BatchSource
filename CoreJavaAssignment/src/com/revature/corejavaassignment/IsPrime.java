package com.revature.corejavaassignment;

import java.util.ArrayList;

public class IsPrime {
	public static void isPrime(ArrayList x) {
			// iterating over the ArrayList
			for (int i = 0; i < x.size(); i++) {
				boolean primeTime = true;
				//casting int to Integer to operate in the ArrayList
				Integer currentNumber = (Integer) x.get(i);
				// excluding one as a prime number
				if (currentNumber == 1) {
					primeTime = false;
				}
				// for each element of the ArrayList after 1 iterating from 2 to x to check for
				// Prime Numbers
				for (Integer j = 2; j < currentNumber; j++) {
					if (currentNumber % j == 0) {
						primeTime = false;
					}
				}
				// printing Prime Numbers to the console
				if (primeTime == true)
					System.out.print(currentNumber + ", ");
			}
		}
	}

