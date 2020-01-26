package com.revature.bubble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.revature.floater.Floater;
import com.revature.question7.EmpComp;
import com.revature.question7.Employee;
import com.revature.classabs.*;

public class Methods {

	static int[] Q1(int[] bub) {
		int x = bub.length; // size of array
		int fill = 0; // temporary fill in value
		for (int b = 0; b < x; b++) {
			for (int l = 1; l < (x - b); l++) { // element value comparisons
				if (bub[l - 1] > bub[l]) {

					fill = bub[l - 1]; // moving through array elements
					bub[l - 1] = bub[l];
					bub[l] = fill;
				}
			}

		}
		return bub;
	}

	static void Q2() {
		int a = 0; // set first two values
		int b = 1;
		for (int f = 0; f <= 25; f++) { // set counter for 25 sequences
			System.out.print(a + ", ");
			int next = a + b; // creating a sum variable
			a = b;
			b = next;

		}
	}

	public static String Q3(String str) {
		// Converting to character array
		char hoop[] = str.toCharArray(); // creating new char array from str
		int n = hoop.length; // creating a size of array variable
		char result[] = new char[n];
		for (int i = 0; i < hoop.length; i++) {
			result[n - 1] = hoop[i]; // loop printing each char starting from the back of the array to the front
			n = n - 1;
		}
		return new String(result);
	}

	public static void Q4() {

		System.out.println("What number would you like to find the factorial of?");// ask for number input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // store number input in n
		int res = 1; // create variable to be temp and final result
		for (int i = 1; i <= n; i++) { // move through each number up to the user input
			res = res * i; // multiply each temp to the current product
		}
		System.out.println("The factorial of " + n + " is " + res);
	}

	public static void Q5() {
		String what = "Jabberwocky";
		int idx = 4; // create idx variable
		System.out.println("The first 3 letters of Jabberwocky are:");
		System.out.println(what.substring(0, idx - 1)); // print until idx -1
	}

	public static void Q6() {
		int num;
		Scanner input = new Scanner(System.in);

		System.out.print("What whole number confuses you? ");
		num = input.nextInt(); // store number input

		if (((num / 2) * 2) == num) { // odd or even check
			System.out.println("The number " + num + " is even");
		} else {
			System.out.println("The number " + num + " is odd");
		}
	}

	public static void Q7() {
		ArrayList<Employee> Emp = new ArrayList<>();
		Employee emp1 = new Employee("Colby Agar", 24, "Psychology"); // create employee 1
		Employee emp2 = new Employee("Matt Knighten", 33, "IT"); // create employee 2
		// add employees to the array
		Emp.add(emp1);
		Emp.add(emp2);
		Collections.sort(Emp, new EmpComp());// Sort by the order you want
		for (Employee e : Emp) { // for each employee in array
			System.out.println(e); // print employee info
		}
	}

	public static void Q9() {
		ArrayList<Integer> ls = new ArrayList<>();// Create array ls

		for (int p = 1; p <= 100; p++) { // Store 1 - 100 array ls
			ls.add(p);
		}
		for (Integer num : ls) {
			for (Integer i = 2; i < num; i++) { // go through each number in array ls
				if (num % i == 0) { // is it prime

					if (i == num) { // check to see if i matches original number
						System.out.println(num + "");
					}
				}
			}

		}
	}

	public static void Q10() {
		int x, y, min;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers");
		x = sc.nextInt(); // first user input
		y = sc.nextInt(); // second user input
		min = x < y ? x : y; // min equals x if x<y is true
		System.out.println("Minimum of your two numbers is:");
		System.out.println(min + " ");
	}

	public static void Q11() {
		Floater flop = new Floater();
		System.out.println("First float: " + flop.floater); // call on variables from Floater class
		System.out.println("Second float: " + flop.floater2);
	}

	public static void Q12() {
		int numb[] = new int[100];

		// Storing 1 to 100 in Array
		for (int x = 1; x <= 100; x++) {
			numb[x - 1] = x;// push back to 0 as new start
		}

		// Showing only even numbers for each
		for (int y : numb) {
			if (y % 2 == 0) // identify even numbers
				System.out.println(y); // print out even numbers
		}
	}

	public static void Q13() {
		int amnt = 1; // create variable
		for (int r = 1; r <= 4; r++) {// loop for rows
			for (int x = 0; x < r; x++) {
				if (amnt % 2 != 0) { // determines the order of the 1s and 0s in the row
					System.out.print("0");// print a 0
				} else {
					System.out.print("1");// print a 1
				}
				amnt++; // moves a row down
			}
			System.out.print("\n");
		}
	}

	public static void Q14() {

		int root;

		System.out.println("Choose a number between 1 and 3.");
		System.out.println("1. Square Root of the number 25");// Printed out a menu
		System.out.println("2. Today's date");
		System.out.println("3. Lets split that array up into different lines!");

		Scanner num = new Scanner(System.in);
		root = num.nextInt(); // receives user input
		double math = 25; // create variabe for .sqrt() to use.
		String help = "I am Learning Core Java";
		String helpArray[] = new String[8]; // create String array
		switch (root) { // sends user input to a case based on the number they input
		case 1:// begin user input 1
			math = Math.sqrt(math); // uses .sqrt() method to find the square root of 25
			System.out.println("The square root of 25 is: " + math); // print out answer
			break;
		case 2:// begin user input 2
			Date date = new Date(); // create a date Object for the Date() method
			System.out.println("Today's date is: " + date); // Print out the date
			break;
		case 3:// begin user input 3
			helpArray = help.split(" "); // separating the array by spacing using .split()
			for (String me : helpArray) { // loop that puts each word from the String on a new line
				System.out.println(me);
			}
			break;

		}

	}

	public static void Q16() {
		System.out.println("Please type out a statement");
		String what; // create string variable
		int lngth; // create int variable to act as counter for variables
		Scanner strng = new Scanner(System.in); // Receive user input
		what = strng.nextLine(); // apply the string variable to the user input

		lngth = what.length(); // apply the int variable to the .length of the String

		System.out.println("The number of characters in your statement is: " + lngth); // Print the answer
	}

	public static void Q17() {
		double p, yrs, intr, result; // create variables for each value

		//create scanners for user input
		System.out.println("Enter the principal amount: ");
		Scanner principal = new Scanner(System.in);
		System.out.println("Enter the interest rate: ");
		Scanner interest = new Scanner(System.in);
		System.out.println("Enter the number of years: ");
		Scanner years = new Scanner(System.in);
		//Store user input in primitives
		p = principal.nextDouble();
		intr = interest.nextDouble();
		yrs = years.nextDouble();

		result = p * intr * yrs; // multiply all of the values to get the interest

		System.out.println("The amount of interest over " + yrs + " years adds up to $" + result);
	}

	public static void Q18() {
		Concrete concrete = new Concrete(); // create new object
		System.out.println("Is there an uppercase in \"What is going on here!\"");
		System.out.println(concrete.Uppercase("What is going on here!")); 
		System.out.println("Lets make \"can you hear me now?\" a louder");
		System.out.println(concrete.Lowercase("can you hear me now?"));
		concrete.AddTen("7");
	}

	public static void Q20() {
		BufferedReader read; //
		try {
			read = new BufferedReader(new FileReader("Data.txt"));//create file reader
			String l; 

			while ((l = read.readLine()) != null) { //read through each line until finished reading text file
				//create new String array
				String separ[] = l.split(":"); //create new line once ":" is reached in text file
				//Print out new line for each parameter
				System.out.println("Name: " + separ[0] + separ[1]); 
				System.out.println("Age: " + separ[2] + " years");
				System.out.println("State: " + separ[3] + " state");
				System.out.println();
			}
			read.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] hereWeGo) {
		int bub[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };// original array

		Q1(bub); // call on bubble sort method

		for (int b = 0; b < bub.length; b++) { // print out ordered
			System.out.print(bub[b] + " ");
		}

	}

}
