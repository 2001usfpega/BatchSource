package com.revature.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

		int myArray[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };//Creates an array if these values 

		Methods.q1(myArray);//Calls the method q1 in the Methods class

		for (int C = 0; C < myArray.length; C++) {
			System.out.print(myArray[C] + " ");

		}

		System.out.println();

		/*
		 * 
		 * QUESTION 2
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 2:");
		System.out.println();

		Methods.q2(); //Calls the method q2 in the Methods class

		System.out.println();
		/*
		 * 
		 * 
		 * QUESTION 3
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 3:");
		System.out.println();

		Methods.q3(); //Calls the method q3 in the Methods class

		System.out.println();

		/*
		 * 
		 * QUESTION 4
		 * 
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 4:");
		System.out.println();

		Methods.q4(); //Calls the method q4 in the Methods class

		System.out.println();

		/*
		 * 
		 * QUESTION 5
		 * 
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 5:");
		System.out.println();

		System.out.println(Methods.q5("QUESTION 5", 5));//Calls the method q5 in the Methods class

		System.out.println();

		/*
		 * 
		 * QUESTION 6
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 6:");
		System.out.println();

		Methods.q6(7); //Calls the method q6 in the Methods class

		System.out.println();

		/*
		 * 
		 * QUESTION 7
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 7:");
		System.out.println();

		ArrayList<Question7> q7List = new ArrayList<Question7>();//Creates an array list
		q7List.add(new Question7("Rob", 22, "Software"));//Adds each employee to the Array list of Q7List
		q7List.add(new Question7("Bob", 25, "Hardware"));

		System.out.println("Sorted by Name:");

		Collections.sort(q7List, new NameSort());//Call sort to sort q7List by employee name

		for (int A = 0; A < q7List.size(); A++) {
			System.out.println(q7List.get(A));

		}

		System.out.println("Sorted by Age:"); //Call sort to sort q7List by employee age

		Collections.sort(q7List, new AgeSort());

		for (int B = 0; B < q7List.size(); B++) {
			System.out.println(q7List.get(B));

		}

		System.out.println("Sorted by Department:"); //Call sort to sort q7List by Department

		Collections.sort(q7List, new DepartmentSort());

		for (int C = 0; C < q7List.size(); C++) {
			System.out.println(q7List.get(C));

		}

		System.out.println();

		/*
		 * 
		 * QUESTION 8
		 * 
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 8:");
		System.out.println();

		ArrayList<String> myArray2 = new ArrayList<String>();//Creates an array list for each of the words being tested
		ArrayList<String> PalindromeArray = new ArrayList<String>();//creates an empty arraylist that will be filled with palindromes after test
		myArray2.add("karan");//adds to the arrayList
		myArray2.add("madam");//adds to the arrayList
		myArray2.add("tom");//adds to the arrayList
		myArray2.add("civic");//adds to the arrayList
		myArray2.add("radar");
		myArray2.add("jimmy");
		myArray2.add("john");
		myArray2.add("refer");
		myArray2.add("billy");
		myArray2.add("did");

		for (int A = 0; A < myArray2.size(); A++) {
			if (Methods.q8((String) myArray2.get(A))) {

				PalindromeArray.add((String) myArray2.get(A));
				/*
				 * Iterates over the full array and then called the method to test if they are a plaindrome 
				 * and then adds them to the palindorme array if true
				 * 
				 * 
				 * 
				 */

			}

		}

		System.out.println("Palindromes=" + PalindromeArray);// Prints the plaindrome array

		/*
		 * 
		 * QUESTION 9
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 9:");
		System.out.println();

		Methods.q9(); //Calls the method q9 in the Methods class

		/*
		 * 
		 * QUESTION 10
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 10:");
		System.out.println();

		Methods.q10(); //Calls the method q1 in the Methods class

		/*
		 * 
		 * QUESTION 11
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 11:");
		System.out.println();

		Question11 quest = new Question11();//creates a new object of question 11;

		System.out.print(quest.A + " ");

		System.out.print(quest.B);//retrives information from the question 11 package

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

		Methods.q12(); //Calls the method q12 in the Methods class

		System.out.println("");

		/*
		 * 
		 * QUESTION 13
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 13:");
		System.out.println();

		int triangle = 0;
		
		/*		 
		 * creates a triangle of 1's and 0's for the methods class to covert
		 * to either a 1 or a 0.  		 *
		 */

		for (int A = 1; A <= 4; A++) {
			for (int B = 0; B < A; B++) {
				System.out.print(triangle + "");
				triangle = Methods.q13(triangle);

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

		Methods.q14(1);//Calls the method q14 in the Methods class
		System.out.println();
		Methods.q14(2);//Calls the method q14 in the Methods class
		System.out.println();
		Methods.q14(3);//Calls the method q14 in the Methods class

		/*
		 * 
		 * 
		 * QUESTION 15
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 15:");
		System.out.println();

		Question15class question = new Question15class();//creates a new object of the Question 15 class
		System.out.print(question.addition(10, 5) + ",");//calls the methods in the Question 15 class
		System.out.print(question.multiplication(10, 5) + ",");
		System.out.print(question.subtraction(10, 5) + ",");
		System.out.print(question.divison(10, 5) + ",");

		System.out.println();

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
		A = myInput.nextLine();// Scans in the user input and assigns it to the variable A 

		System.out.println("The Number of charaters is: " + A.length());//Prints the length of A

		/*
		 * 
		 * 
		 * Question 17
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 17:");
		System.out.println();

		Methods.q17(); //Calls the method q17 in the Methods class

		/*
		 * 
		 * Question 18
		 * 
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 18:");
		System.out.println();

		String myString2 = "Question18";
		String myString3 = "2525";
		Question18Concrete q18 = new Question18Concrete();//creates a new object of the concrete class
		
		switch (1) {//Calls different methods of the concrete class depending on what case is entered 

		case 1:
			q18.part1(myString2);

		case 2:
			q18.part2(myString2);

		case 3:
			System.out.println(q18.part3(myString3));

		}

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

		ArrayList<Integer> myArrayList2 = new ArrayList<Integer>();//Creates an array list with an index of 10 by iterating over it with a for loop
		for (int a = 1; a <= 10; a++) {
			myArrayList2.add(a);

		}

		int even = 0;
		for (int b = 0; b < myArrayList2.size(); b++) {//if the number is even this for loop will set the value of the even to its current value plus the new value 
			if (myArrayList2.get(b) % 2 == 0) {

				even += myArrayList2.get(b);
				System.out.println(even);

			}
		}
		
		int odd = 0;
		for (int c = 0; c < myArrayList2.size(); c++) {//This for loop does the same as the above for loop but with odd values 
			if (myArrayList2.get(c) % 2 == 1) {

				odd += myArrayList2.get(c);
				System.out.println(odd);

				}
		}
		

		/*
		 * 
		 * QUESTION 20
		 * 
		 * 
		 */

		System.out.println("");
		System.out.println("QUESTION 20:");
		System.out.println();
		
		  BufferedReader bufreader = null;
		try {
			bufreader = new BufferedReader(new FileReader("Data.txt"));
		} catch (FileNotFoundException e) {// try catch block will throw an expception if 'Data.txt' file is not found
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Reads the data.txt files into the program
	       String string;
	       try {
			while((string = bufreader.readLine()) != null) {//While reader does not equal null it will read the entire text file into the system
			       String tokens[] = string.split(":");//this splits the text in the data file by the colons and then assigns it into an array
			       System.out.println("Name: " + tokens[0] + tokens[1]);
			       System.out.println("Age: " + tokens[2] + " years");
			       System.out.println("State: " + tokens[3] + " State\n");
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	       try {
			bufreader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
