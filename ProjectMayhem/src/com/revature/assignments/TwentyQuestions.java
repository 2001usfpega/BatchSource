package com.revature.assignments;

import java.util.*;
import java.io.*;
import java.lang.Math;
import com.revature.assignments11.*;

public class TwentyQuestions extends QuestionEleven {

	public abstract class Comp implements Comparator<Comp> {
		public Comp(int age, String name, String depart) {

		}

		@Override
		public int compare(Comp arg0, Comp arg1) {

			return 0;
		}

	}

	public static void main(String[] args) {
		String s = "Some";

		System.out.println("Question 1 Result");
		Q1();
		System.out.println();
		System.out.println("Question 2 Result");
		Q2();
		System.out.println();
		System.out.println("Question 3 Result");
		System.out.println(Q3(s.toCharArray(), 0, 3));
		System.out.println("Question 4 Result");
		Q4();
		System.out.println("Question 5 Result");
		System.out.println(Q5("dollar", 3));
		System.out.println("Question 6 Result");
		Q6(11);
		System.out.println("Question 7 Result");
		// Q7();
		System.out.println("Question 8 Result");
		Q8();
		System.out.println("Question 9 Result");
		Q9();
		System.out.println("Question 10 Result");
		Q10(9, 10);
		System.out.println("Question 11 Result");
		// Q11();
		System.out.println("Question 12 Result");
		Q12();
		System.out.println("Question 13 Result");
		Q13();
		System.out.println("Question 14 Result");
		Q14(2);
		System.out.println("Question 15 Result");
		// Q15();
		System.out.println("Question 16 Result");
		// Q16();
		System.out.println("Question 17 Result");
		Q17();
		System.out.println("Question 18 Result");
		// Q18();
		System.out.println("Question 19 Result");
		Q19();
		System.out.println("Question 20 Result");
		Q20();

	}

	public static void Q1() {

		int bbl[] = { 1, 0, 5, 6, 3, 2, 3, 7, 8, 9, 4 };

		int a = bbl.length;
		for (int b = 0; b < a - 1; b++) {
			for (int c = 0; c < a - b - 1; c++)
				if (bbl[c] > bbl[c + 1]) {
					int sort = bbl[c];
					bbl[c] = bbl[c + 1];
					bbl[c + 1] = sort;

				}

		}
		System.out.print(Arrays.toString(bbl));
	}

	public static void Q2() {

		int fib0 = 25, fib1 = 0, fib2 = 1;
		System.out.print("Max 25 : ");
		while (fib1 <= fib0) {
			System.out.print(fib1 + " + ");

			int summ = fib1 + fib2;
			fib1 = fib2;
			fib2 = summ;
		}

	}

	public static String Q3(char[] rev, int start, int end) {

		while (start < end) {
			rev[start] ^= rev[end];
			rev[end] ^= rev[start];
			rev[start] ^= rev[end];

			++start;
			--end;

		}
		return String.valueOf(rev);

	}

	public static void Q4() {

		int t, fac = 1;
		int number = 5;
		for (t = 1; t <= number; t++) {

			fac = fac * t;

		}
		System.out.println("The Factorial of " + number + " is " + fac);

	}

	public static String Q5(String ring, int dex) {

		String money = " ";
		int a = 0;
		while (a <= dex - 1) {

			money = money + ring.charAt(a);
			a++;
		}
		return money;

	}

	public static void Q6(int b) {

		if ((b / 2) * 2 == b) {
			System.out.println("Even");
		}
		if ((b / 2) * 2 != b) {
			System.out.println("Odd");
		}

	}

	public static void Q7() {

	}

	public static void Q8() {

		ArrayList<String> drom = new ArrayList<String>();
		drom.add("karan");
		drom.add("madam");
		drom.add("tom");
		drom.add("civic");
		drom.add("radar");
		drom.add("jimmy");
		drom.add("kayak");
		drom.add("john");
		drom.add("refer");
		drom.add("billy");
		drom.add("did");

		ArrayList<String> palin = new ArrayList<String>();

		for (String a : drom) {
			if (pally(a)) {
				palin.add(a);
			}
		}
		for (String a : palin) {
			System.out.println(a);
		}

	}

	public static boolean pally(String pal) {

		int front = 0;
		int back = pal.length() - 1;
		while (front < back) {
			if (pal.charAt(front++) != (pal.charAt(back--))) {
				return false;

			}
		}
		return true;

	}

	public static void Q12() {
		int[] hundo = new int[100]; // creates array length 100
		for (int a = 0; a < hundo.length; a++) {
			hundo[a] = a + 1; // adds 1-100 to array
		}
		for (int a : hundo) {
			if (a % 2 == 0) {
				System.out.println(a); // prints number if even number
			}
		}

	}

	public static void Q10(int a, int b) {

		int min;
		min = (a < b) ? a // if a < b, then a
				: b; // if a not < b = b < a, then b
		System.out.println("The minimum of these numbers is " + min + ".");
	}

	public static void Q11() {

	}

	public static void Q9() {
		ArrayList<Integer> hundo = new ArrayList<Integer>(); // creates new Array List
		for (int a = 0; a < 100; a++) {
			hundo.add(a + 1); // adds 1-100 to ArrayList
		}
		for (int a : hundo) {
			if (Primal(a)) { // calls isPrime method
				System.out.println(a); // prints out number if prime
			}

		}
	}

	public static boolean Primal(int num) {
		if (num <= 1) {
			return false;
		}
		int i = 2;
		while (i < num) {
			if (num % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void Q13() {

		for (int a = 1; a <= 4; a++) {
			for (int b = 1; b <= a; b++) {
				System.out.print(((a + b) % 2) + " ");
			}
			System.out.print("\n");
		}
	}

	public static void Q14(int random) {

		switch (random) {
		case 1:
			double a = 30;

			System.out.println(Math.sqrt(a));
			break;
		case 2:
			System.out.println(java.time.LocalDate.now());
			break;
		case 3:
			String java = "I am learning Core Java";
			String[] javaSplit = java.split(" ");
			for (int b = 0; b < javaSplit.length; b++) {
				System.out.println(javaSplit[b]);
			}
			break;
		default:
			System.out.println("Don't do that");

		}
	}

	public static void Q15() {

	}

	public static void Q16() {

	}

	public static void Q17() {
		Scanner inn = new Scanner(System.in);
		System.out.println("Enter values for principal, rate, and time."); // tells user to input values
		double p = inn.nextDouble(); // principal value input - used double in case not rounded value
		double r = inn.nextDouble(); // rate input
		int t = inn.nextInt(); // time input - integer years or months
		double prt = p * r * t;
		inn.close();
		System.out.println(prt);

	}

	public static void Q18() {

	}

	public static void Q19() {
		ArrayList<Integer> ten = new ArrayList<Integer>();
		for (int a = 0; a < 10; a++) {
			ten.add(a + 1); 
		}
		int evenSum = 0;
		int oddSum = 0;
		for (int a : ten) {
			System.out.println(a);
			if (a % 2 == 0) {
				evenSum += a;
			} else if (a % 2 != 0) {
				oddSum += a;
			}
		}
		System.out.println("The sum of all even numbers is " + evenSum + ".");
		System.out.println("The sum of all odd numbers is " + oddSum + ".");

		for (int a = 0; a < ten.size(); a++) {
			if (Primal(ten.get(a))) {
				ten.remove(new Integer(ten.get(a)));
			}
		}
		for (int a : ten) {
			System.out.println(a);
		}
	}

	public static void Q20() {
		try {
			Scanner MM = new Scanner(new File("Data.txt"));

			while (MM.hasNextLine()) {
				String mickey = MM.nextLine();
				String[] mouse = mickey.split(":");
				System.out.println("Name: " + mouse[0] + " " + mouse[1]);
				System.out.println("Age: " + mouse[2] + " years");
				System.out.println("State: " + mouse[3] + " State");

			}

		} catch (FileNotFoundException a) {
			a.printStackTrace();
		}
	}
}
