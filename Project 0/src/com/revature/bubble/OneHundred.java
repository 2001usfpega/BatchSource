package com.revature.bubble;

import java.util.*;

public class OneHundred {

	public static void hundred() {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		int i;

		for (int p = 1; p <= 100; p++) {
			ls.add(p);

		}

		for (Integer num : ls) {
			for (i = 2; i < num; i++) {
				if (num % i == 0) {

				}
//				if (i == num) {
//					System.out.println(num + "");
//				}
			}

		}
	}
}
