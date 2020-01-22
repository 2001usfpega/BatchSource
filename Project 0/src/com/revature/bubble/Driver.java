package com.revature.bubble;

import com.revature.bubble.BubbleSort;


import java.util.*;
import java.util.Scanner;
import com.revature.bubble.*;

public class Driver {

	public static void main(String[] args) {
		int bub[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };// original array

		System.out.println("======Question 1======");

		System.out.println("Before array");
		for (int b = 0; b < bub.length; b++) { // print out unordered
			System.out.print(bub[b] + " ");
		}
		System.out.println();

		BubbleSort.Q1(bub);
		System.out.println("Ordered array");

		for (int b = 0; b < bub.length; b++) { // print out ordered
			System.out.print(bub[b] + " ");
		}
		System.out.println();
		System.out.println("======Question 2======");

		BubbleSort.Q2(); // call method

		System.out.println();

		System.out.println("======Question 3======");

		Scanner sc = new Scanner(System.in);
		System.out.println("What word would you like to print backwards?");// ask for word input
		String str = sc.next(); // store user input
		String result = BubbleSort.Q3(str); // make a variable in driver equivalent to method
		System.out.println(result); // print variable

		BubbleSort.Q3(str); // call method to reverse the word

		System.out.println();
		System.out.println("======Question 4======");

		BubbleSort.Q4();

		System.out.println();
		System.out.println("======Question 5======");

		BubbleSort.Q5();

		System.out.println();
		System.out.println("======Question 6======");

		BubbleSort.Q6();
		
		System.out.println();
		System.out.println("======Question 7======");
		
		

		System.out.println();

		System.out.println("======Question 8======");

		Palindromes.check();

		System.out.println();
		System.out.println("======Question 9======");

		BubbleSort.Q9();

		System.out.println();
		System.out.println("======Question 10======");

		BubbleSort.Q10();

		System.out.println();
		System.out.println("======Question 11======");

		BubbleSort.Q11();

		System.out.println();
		System.out.println("======Question 12======");

		BubbleSort.Q12();

		System.out.println();
		System.out.println("======Question 13======");

		BubbleSort.Q13();

		System.out.println();
		System.out.println("======Question 14======");

		BubbleSort.Q14();

		System.out.println();
		System.out.println("======Question 15======");

		int a = 5, b = 9;
		Implement imp = new Implement(); // create a new class Object to run each method
		System.out.println(imp.add(a, b)); // activate each method
		System.out.println(imp.subtract(a, b));
		System.out.println(imp.multi(a, b));
		System.out.println(imp.div(a, b));

		System.out.println();
		System.out.println("======Question 16======");

		BubbleSort.Q16();

		System.out.println();
		System.out.println("======Question 17======");

		BubbleSort.Q17();

		System.out.println();
		System.out.println("======Question 18======");

		System.out.println();
		System.out.println("======Question 19======");

		UpToTen.main(args);
		
		System.out.println();
		System.out.println("======Question 20======");
		
		
	}
}
