package com.revature.overload;

public class Overloader {

	public static void main(String[] args) {

		Integer myNum = 5;
		Double myDouble = 5.5;

		int myInt1 = 4;
		int myInt2 = 5;

		// Exact match

		System.out.println(concat(myNum.toString(), "10"));

		// Conversion

		System.out.println(concat(myInt1, myInt2));

		// Boxing

		System.out.println(concat(myNum.doubleValue(), myDouble));

		// VarArgs

		concat("hello", "how are you", "what is up");

	}

	public static String concat(String word1, String word2) {
		return word1 + " " + word2;
	}

	public static float concat(float num1, float num2) {
		return num1 + num2;
	}

	public static double concat(Double num1, Double num2) {
		return num1 + num2;
	}

	public static void concat(String... strings) {
		for (String x : strings) {
			System.out.print(x + " ");
		}
	}

}
