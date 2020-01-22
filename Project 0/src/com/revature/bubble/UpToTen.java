package com.revature.bubble;

import java.util.ArrayList;

public class UpToTen {

	public static boolean prime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		ArrayList<Integer> ls = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			ls.add(i);
		}

		int even = 0;
		for (int e = 0; e < ls.size(); e++) {
			if (ls.get(e) % 2 == 0) { // discover even numbers
				even += ls.get(e);//add newly discovered even number to the sum
			}
		}
		System.out.println("Sum of even numbers in the array list: " + even);

		int odd = 0;
		for (int o = 0; o < ls.size(); o++) {
			if (ls.get(o) % 2 == 1) { //discover odd numbers
				odd += ls.get(o); // add newly discovered odd number to the sum
			}
		}
		System.out.println("Sum of odd numbers in the array list: " + odd);

		for (int p = 0; p < ls.size(); p++) {
			if (prime(ls.get(p))) { // find prime numbers remaining
				ls.remove(p); // remove prime numbers from array ls
				p--;
			}
		}
		System.out.println("Array list after remove the prime numbers:");
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i)); //print out on separate lines
		}
	}
}
