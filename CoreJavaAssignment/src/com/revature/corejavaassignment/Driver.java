package com.revature.corejavaassignment;

import java.util.*;
import java.io.*;
import com.revature.secondpackage.FloatNumberOne;
import com.revature.secondpackage.FloatNumberTwo;

public class Driver {

	public static void main(String[] BettyWhite) throws IOException {
		// Q1 bubblesort
		int[] newArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Array prior to Bubble Sort: ");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.println();
		BubbleSort.bubbleSort(newArray);
		System.out.println("Array after Bubble Sort: ");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}

		// Q2 Fibonacci
		//System.out.println();
		//System.out.println(Fibo.fiboMethod());
		int n1 = 0;
		int n2 = 1;
		int n3;
		// the number of times the program needs to run is in "count"
		int count = 25;
		// putting the answer on a new line
		System.out.println();
		// printing out "0" and "1" - the first two numbers in the Fibonacci sequence
		System.out.print(n1 + " " + n2);
		for (int i = 2; i < count; ++i) {
			// get the sum of the first two numbers
			n3 = n1 + n2;
			// print the sum of the first two numbers
			System.out.print(" " + n3);
			// move to the next set of two numbers in the sequence recursively
			n1 = n2;
			n2 = n3;
		}
		
		// Q3 ReverseString
		String string = "Revature Boot Camp ROCKS!!";
		System.out.println();
		System.out.println(string);		
		ReverseString.reverseStringMethod(string);


		// Q4 Factorial
		// establish the variable to hold the number to factorial
		int exp = 12;
		// print the factorial of 12 calling the factorial() form the Factorial class
		System.out.println("Factorial of " + exp + " is " + Factorial.factorial(exp));

		// Q5 Substring
		String sentence = "How now, Brown Cow?";
		int a = 7;
		System.out.print(SubString.subStringMethod(sentence, a));

		// Q6 EvenSteven
		// creating a variable to pass into the even checking method
		int number = 3479654;
		// putting the answer on its own line
		System.out.println();
		// calling the method and passing in the variable
		ItIsEven.isEven(number);

		// Q7 Comparator Question
		// setting up the lists to sort
		ArrayList<ComparatorQuestion> employees = new ArrayList<ComparatorQuestion>();
		employees.add(new ComparatorQuestion("Chuck", "Policy", 58));
		employees.add(new ComparatorQuestion("Bill", "Law", 37));
		employees.add(new ComparatorQuestion("Lacey", "Policy", 44));

		ArrayList<ComparatorQuestion> sameName = new ArrayList<ComparatorQuestion>();
		sameName.add(new ComparatorQuestion("Charlie", "Policy", 45));
		sameName.add(new ComparatorQuestion("Charlie", "IT", 19));
		sameName.add(new ComparatorQuestion("Charlie", "Billing", 38));
		sameName.add(new ComparatorQuestion("Charlie", "Legal", 55));

		ArrayList<ComparatorQuestion> sameNameDept = new ArrayList<ComparatorQuestion>();
		sameNameDept.add(new ComparatorQuestion("Bill", "Billing", 68));
		sameNameDept.add(new ComparatorQuestion("Bill", "Billing", 22));
		sameNameDept.add(new ComparatorQuestion("Bill", "Billing", 44));
		sameNameDept.add(new ComparatorQuestion("Bill", "Billing", 73));
		sameNameDept.add(new ComparatorQuestion("Bill", "Billing", 39));

		System.out.println(employees);
		System.out.print("Sort by Name: ");
		Collections.sort(employees, new MyComparator());
		System.out.println(employees);
		System.out.print("Sort by Department: ");
		Collections.sort(sameName, new MyComparator());
		System.out.println(sameName);
		System.out.print("Sort by Age: ");
		Collections.sort(sameNameDept, new MyComparator());
		System.out.println(sameNameDept);

		// Q8 ArrayList Strings and Palindromes
		// creating ArrayList
		ArrayList<String> newList = new ArrayList<String>();
		// adding Strings to newList
		newList.add("karan");
		newList.add("madam");
		newList.add("tom");
		newList.add("civic");
		newList.add("radar");
		newList.add("jimmy");
		newList.add("kayak");
		newList.add("john");
		newList.add("refer");
		newList.add("billy");
		newList.add("did");
		// creating ArrayList to hold palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		// testing Strings for palindromes
		for (String s : newList) {
			if (Palindromes.findPalindrome(s)) {
				palindromes.add(s);
			}
		}
		System.out.println("The full list is: " + newList);
		System.out.println("The Palindromes are: " + palindromes);

		// Q9 Prime Numbers
		// create the ArrayList to hold the prime integers of 100
		ArrayList<Integer> primes = new ArrayList<Integer>();
		// iterate over the ArrayList 100 times
		for (int i = 1; i <= 100; i++) {
			// adding numbers to ArrayList
			primes.add(i);
		}
		// printing out the ArrayList 1 to 100
		System.out.print("List to 100: ");
		System.out.print(primes);
		// printing out the prime numbers from isPrime method
		System.out.println();
		System.out.print("Prime numbers from 1 to 100: ");
		IsPrime.isPrime(primes);

		// Q10 ternary operator
		// creating variables to compare
		int bigNumber = 55;
		int smallNumber = 2;
		// using the ternary operator to compare them
		int min = (bigNumber < smallNumber) ? bigNumber : smallNumber;
		System.out.println();
		System.out.println("The smallest number between " + bigNumber + " and " + smallNumber + " is " + min);

		// Q11 Two floats
		// create a new object f1 to pull the float from secondpackage, FloatNumberOne
		// class
		FloatNumberOne f1 = new FloatNumberOne();
		// create a new object f2 of the secondpackage, class FloateNumber two to get
		// the other float
		FloatNumberTwo f2 = new FloatNumberTwo();
		// add the two together to give the program functionality
		Float f3 = f1.getFromPackOne() + f2.getFromPackTwo();
		// use the getters to put the floats in a print statement and give their sum
		System.out.println(f1.getFromPackOne() + " plus " + f2.getFromPackTwo() + " is equal to " + f3);

		// Q12 Even numbers to 100
		// creating the ArrayList to hold the even integers
		ArrayList<Integer> evenSteven = new ArrayList<Integer>();
		// for loop going form 1 to 100, detecting even numbers and adding them to the
		// populating the ArrayList 1 to 100
		for (int i = 1; i <= 100; i++) {
				evenSteven.add(i);
		}
		System.out.println("ArrayList of 100: "+evenSteven);
		
		System.out.print("Even numbers from 1 to 100: ");
		
		for (int t : evenSteven) {
			if(t%2==0) {
			System.out.print(t+", ");
			}
		}
		System.out.println();

		// Q13 TRIANGLE
		// create variable to hold 0 or 1
		int holder = 0;
		// for loop to run four times
		for (int i = 1; i <= 4; i++) {
			// nested for loop to run from zero while j is less than i
			for (int j = 0; j < i; j++) {
				// print out the beginning value of holder
				System.out.print(holder + " ");
				// use the flip logic to flip value of holder
				holder = FlipCode.flip(holder);
			}
			// start on next line of console for next iteration of for loops
			System.out.println();
		}

		// Q14 Switch Cases Demonstration
		// there aren't any breaks so that switch will run completely to show
		// functionality
		// creating variable for Date functionality
		Date date = new Date();
		// creating String variable to split in case 3
		String coreLearning = "I am learning Core Java";
		// creating String array to accept the split in case 3
		String[] h = new String[10];
		switch (1) {
		case 1:
			// case one functionality use Math.sqrt()
			System.out.println(Math.sqrt(25));
		case 2:
			// case two functionality printing out the date
			System.out.println(date);
		case 3:
			// case three functionality splitting the string and printing the array to the console
			h = coreLearning.split(" ");
			for (String s : h) {
				System.out.print(s+" ");
			}
			System.out.println();
		}

		// Q15 Interface
		// Created interface and class
		// Had the class implement the interface
		// gave the methods functionality in the class
		// creating an object of the class implementing the interface
		QuestionFifteen q15 = new QuestionFifteen();
		// printing out the interface methods with the functionality from the
		// implementing class
		System.out.println(q15.addition(27, 23));
		System.out.println(q15.subtraction(4, 65));
		System.out.println(q15.multiplication(6, 6));
		System.out.println(q15.division(25, 5));

		// Q16 String input from command line argument
		// printing out String from command line
		System.out.println(BettyWhite[0]);
		System.out.println(BettyWhite[0].length());

		// Q17 compute simple interest
		// imported scanner class
		// creating new variable to implement the scanner class
		Scanner scanner = new Scanner(System.in);
		// console prompt to tell user to enter principal amount
		System.out.println("Please enter a principal amount.");
		// variable to accept the amount of principal input by the user
		int p = scanner.nextInt();
		// console prompt to tell user to enter a rate of interest amount
		System.out.println("Pleae enter a rate of interest.");
		// variable to accept the rate of interest amount entered by the user
		double r = scanner.nextDouble();
		// console prompt to tell the user to enter an amount of time
		System.out.println("Please enter an amount of time.");
		// variable to accept the amount of time input by the user
		double t = scanner.nextDouble();
		// computing the simple interest
		double interest = p * r * t;
		// displaying the amount of simple interest to the console
		System.out.println("Your rate of interest is " + interest);

		// Close Scanner to save system resources
		scanner.close();

		// Q18 abstract method, concrete subclass, strings
		String case1 = "how now, brown cow?";
		String integerString = "17";
		ConcreteSubClassQuestion18 v = new ConcreteSubClassQuestion18();
		//using switch to showcase each functionality implemented in the subclass(showing off really...)
		//again, no breaks so the switch runs all the way through.
		switch (1) {
		case 1:
			v.checkForUpperCase(case1);
		case 2:
			System.out.println(v.convertLowerToUpper(case1));
		//not sure if assignment means case 3 or case 4, so I did both...
		case 3:
			System.out.println(v.convertWordsToValue(case1));
		case 4:
			System.out.println("The best number ever is "+v.convertStringToInteger(integerString));
		}

		//Q19 ArrayList even + odd + prime to ten
		ArrayList<Integer> tenList = new ArrayList<Integer>();
		// for loop adding arrays into the ArrayList
		for (int i = 1; i <= 10; i++) {
			tenList.add(i);
		}
		// create variable for even numbers sum
		int evenSum = 0;
		// for loop to find even numbers and then add them together
		for (int i = 0; i < tenList.size(); i++) {
			if (tenList.get(i) % 2 == 0) {
				evenSum += tenList.get(i);
			}
		}
		// printing out the sum of the even numbers one through ten
		System.out.println("Sum of even numbers in the ArrayList: " + evenSum);
		// create variable for odd numbers sum
		int oddSum = 0;
		// for loop to find odd numbers and then add them together
		for (int i = 0; i < tenList.size(); i++) {
			if (tenList.get(i) % 2 == 1) {
				oddSum += tenList.get(i);
			}
		}
		// printing out the sum of the even numbers one through ten
		System.out.println("Sum of odd numbers in the ArrayList: " + oddSum);
		// removing the prime numbers from the ArrayList
		for (int i = 0; i < tenList.size(); i++) {
			if (NewPrime.isPrime(tenList.get(i))) {
				tenList.remove(i);
				i--;
			}
		}
		// printing out the list of ten without (Optimus) Prime numbers
		System.out.print("ArrayList after removal of the (Optimus) Prime numbers: ");
		for (int i = 0; i < tenList.size(); i++) {
			System.out.print(tenList.get(i) + " ");
		}

		// Q20 reading from Data.txt
		System.out.println();
		// create a new BufferedReader
		// create new BufferedReader to read text from the indicated location
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:\\Users\\Eric D. Torres\\Desktop\\TorresGit\\BatchSource\\Data.txt"));
		// create a variable to hold the information the BufferedReader gets from the
		// text file
		String str;
		//loop to add the .txt file into a String variable
		while ((str = reader.readLine()) != null) {
			// create an array. to hold the String objects split at the colons
			String piece[] = str.split(":");
			// move answer to the next line on the console
			System.out.println();
			// print out the String Arrays in the appropriate location
			System.out.println("Name: "+piece[0]+" "+piece[1]);
			System.out.println("Age: "+piece[2]+" years");
			System.out.println("State: "+ piece[3] +" "+"State");
		}
		// close the BufferedReader to save system resources
		reader.close();
	}	
}
