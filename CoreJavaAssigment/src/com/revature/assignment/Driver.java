package com.revature.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.revature.assignment.Methods;

import com.revature.question11.Question11;;

public class Driver {

	public static void main(String[] args) {

		/*
		 * 
		 * QUESTION 1
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 1:");
		System.out.println();

		int myArray[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		Methods.Q1(myArray);

		for (int C = 0; C < myArray.length; C++) {
			System.out.print(myArray[C] + " ");

		}
		

		

		/*
		 * 
		 * QUESTION 2
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 2:");
		System.out.println();
		
		

		Methods.Q2();


		/*
		 * 
		 * 
		 * QUESTION 3
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 3:");
		System.out.println();
		
		

		Methods.Q3();
		



		/*
		 * 
		 * QUESTION 4
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 4:");
		System.out.println();

		Methods.Q4();
		

		/*
		 * 
		 * QUESTION 5
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 5:");
		System.out.println();

		System.out.println(Methods.Q5("QUESTION 5", 5));
		


		/*
		 * 
		 * QUESTION 6
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 6:");
		System.out.println();

		Methods.Q6(6);

		/*
		 * 
		 * QUESTION 7
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 7:");
		System.out.println();

		ArrayList<Question7> q7List = new ArrayList<Question7>();
		q7List.add(new Question7("Rob", 22, "Software"));
		q7List.add(new Question7("Bob", 25, "Hardware"));

		System.out.println("Sorted by Name:");

		Collections.sort(q7List, new NameSort());

		for (int A = 0; A < q7List.size(); A++) {
			System.out.println(q7List.get(A));

		}
		
		System.out.println("Sorted by Age:");

		Collections.sort(q7List, new AgeSort());

		for (int B = 0; B < q7List.size(); B++) {
			System.out.println(q7List.get(B));

		}
		
		System.out.println("Sorted by Department:");

		Collections.sort(q7List, new DepartmentSort());

		for (int C = 0; C < q7List.size(); C++) {
			System.out.println(q7List.get(C));

		}

		/*
		 * 
		 * QUESTION 8
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 8:");
		System.out.println();

		ArrayList myArray2 = new ArrayList();
		ArrayList PalindromeArray = new ArrayList();
		myArray2.add("karan");
		myArray2.add("madam");
		myArray2.add("tom");
		myArray2.add("civic");
		myArray2.add("radar");
		myArray2.add("jimmy");
		myArray2.add("john");
		myArray2.add("refer");
		myArray2.add("billy");
		myArray2.add("did");

		for (int A = 0; A < myArray2.size(); A++) {
			if (Methods.Q8((String) myArray2.get(A))) {

				PalindromeArray.add((String) myArray2.get(A));

			}

			System.out.println("Palindromes=" + PalindromeArray);

		}

		/*
		 * 
		 * QUESTION 9
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 9:");
		System.out.println();

		Methods.Q9();

		/*
		 * 
		 * QUESTION 10
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 10:");
		System.out.println();

		Methods.Q10();

		/*
		 * 
		 * QUESTION 11
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 11:");
		System.out.println();

		Question11 quest = new Question11();

		System.out.print(quest.A + " ");

		System.out.print(quest.B);

		System.out.println("");

		/*
		 * 
		 * 
		 * QUESTION 12
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 12:");
		System.out.println();

		/*
		 * 
		 * QUESTION 13
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 13:");
		System.out.println();

		int triangle = 0;

		for (int A = 1; A <= 4; A++) {
			for (int B = 0; B < A; B++) {
				System.out.print(triangle + "");
				triangle = Methods.Q13(triangle);

			}

			System.out.println();
		}

		/*
		 * 
		 * QUESTION 14
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 14:");
		System.out.println();

		Methods.Q14(1);
		Methods.Q14(2);
		Methods.Q14(3);

		/*
		 * 
		 * 
		 * QUESTION 15
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 15:");
		System.out.println();

		Question15class question = new Question15class();
		System.out.print(question.addition(10, 5) + ",");
		System.out.print(question.multiplication(10, 5) + ",");
		System.out.print(question.subtraction(10, 5) + ",");
		System.out.print(question.divison(10, 5) + ",");

		/*
		 * 
		 * QUESTION 16
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 16:");
		System.out.println();

		System.out.println();
		String A;
		Scanner myInput = new Scanner(System.in);
		System.out.println("String:");
		A = myInput.nextLine();
		myInput.close();

		System.out.println("The Number of charaters is: " + A.length());

		/*
		 * 
		 * 
		 * Question 17
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 17:");
		System.out.println();

		Methods.Q17();

		/*
		 * 
		 * Question 18
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 18:");
		System.out.println();

		/*
		 * 
		 * 
		 * QUESTION 19
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 19:");
		System.out.println();

		/*
		 * 
		 * QUESTION 20
		 * 
		 * 
		 */
		
		System.out.println("");
		System.out.println("QUESTION 20:");
		System.out.println();

	}

}
