package com.revature.bubble;

import com.revature.bubble.Methods;
import com.revature.question7.Employee;

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

		Methods.Q1(bub);
		System.out.println("Ordered array");

		for (int b = 0; b < bub.length; b++) { // print out ordered
			System.out.print(bub[b] + " ");
		}
		System.out.println();
		System.out.println("======Question 2======");

		Methods.Q2(); // call method

		System.out.println();

		System.out.println("======Question 3======");

		Scanner sc = new Scanner(System.in);
		System.out.println("What word would you like to print backwards?");// ask for word input
		String str = sc.next(); // store user input
		String result = Methods.Q3(str); // make a variable in driver equivalent to method
		System.out.println(result); // print variable

		Methods.Q3(str); // call method to reverse the word

		System.out.println();
		System.out.println("======Question 4======");

		Methods.Q4();

		System.out.println();
		System.out.println("======Question 5======");

		Methods.Q5();

		System.out.println();
		System.out.println("======Question 6======");

		Methods.Q6();
		
		System.out.println();
		System.out.println("======Question 7======");
		
		Methods.Q7();		

		System.out.println();

		System.out.println("======Question 8======");

		Palindromes.check();

		System.out.println();
		System.out.println("======Question 9======");

		Methods.Q9();

		System.out.println();
		System.out.println("======Question 10======");

		Methods.Q10();

		System.out.println();
		System.out.println("======Question 11======");

		Methods.Q11();

		System.out.println();
		System.out.println("======Question 12======");
		System.out.println("Even numbers ascending 100");

		Methods.Q12();

		System.out.println();
		System.out.println("======Question 13======");

		Methods.Q13();

		System.out.println();
		System.out.println("======Question 14======");

		Methods.Q14();

		System.out.println();
		System.out.println("======Question 15======");

		int a = 5, b = 9;
		Implement imp = new Implement(); // create a new class Object to run each method
		System.out.println("Our numbers are 5 and 9.");
		System.out.println("5 + 9 = " +imp.add(a, b)); // activate each method
		System.out.println("5 - 9 = " +imp.subtract(a, b));
		System.out.println("5 * 9 = " +imp.multi(a, b));
		System.out.println("5 / 9 = " +imp.div(a, b));

		System.out.println();
		System.out.println("======Question 16======");

		Methods.Q16();

		System.out.println();
		System.out.println("======Question 17======");

		Methods.Q17();

		System.out.println();
		System.out.println("======Question 18======");
		
		Methods.Q18();

		System.out.println();
		System.out.println("======Question 19======");

		UpToTen.main(args);
		
		System.out.println();
		System.out.println("======Question 20======");
		
		Methods.Q20();
	}
}
