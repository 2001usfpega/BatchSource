package com.revature.corejavaassignment;

public class NewPrime {

	public static boolean isPrime(int x) {
		boolean primeNumber = true;
		if (x == 1) {
			primeNumber = false;
		}
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				primeNumber = false;
			}
		}
		return primeNumber;
	}
}
