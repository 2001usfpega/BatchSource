package com.revature.assn1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.revature.bubbles.BubbleSort;
import com.revature.fibb.FibSequence;

public class AssnOneProblems {

	public static String stringReverse(String s) {
		// takes string in as character array so elements can be accessed
		char[] cArr = s.toCharArray();
		// get length of the string
		int n = s.length();
		// for loop to cycle through string
		for (int i = 0; i < (n / 2); ++i) {
			// use dummy variable to hold character value
			char dummy = cArr[i];
			// assign first indice to last indice with loop varible handling the cyclling of
			// each indice
			cArr[i] = cArr[(n - i) - 1];
			cArr[(n - i) - 1] = dummy;
		}
		// return string to main
		String returnString = new String(cArr);
		return returnString;
	}

	// Works for any integer larger than 2 as long as answer can be held by int data
	// type
	public static int nFactorial(int n) {
		// Two initial variables to start series
		int nMinusOne = n - 1;
		int product = n * nMinusOne;
		// dummy to assist with swap
		int dummy;
		if (n == 1) {
			// statement to account for exception of n being 1, returns answer
			return 1;
		} else if (n == 0) {
			// statement to account for exception of n being 0, returns zero factorial
			// equals one
			return 0;
		}
		// for loop to calculate required operations, uses dummy to hold previous
		// product, and uses for next product
		for (int i = 2; i < n; i++) {

			dummy = product;
			product = dummy * (n - i);
		}

		return product;

	}

	// Ugly method, but it works!
	public static void moreStringFun(String str, int index) {
		// uses character array to hold string
		char[] cArr = str.toCharArray();
		// cycles through indices and prints value until desired index found
		for (int i = 0; i < index; i++) {
			System.out.print(cArr[i]);
		}
		// formatting
		System.out.println();
	}

	// method to determine evenness of oddness of number
	public static void isEvenOrOdd(int num) {
		// arithmatic operations to determine if inverse operation result in same result
		// due to integer division
		int x = num / 2;
		int y = 2 * x;
		if (num == 0) {
			// handles case of num being zero
			System.out.println("Zero is neither even nor odd");
		} else if (y == num) {
			System.out.println("Clearly the Number " + num + " is even!");
		} else {
			System.out.println("Obviously the number " + num + "  is odd!");
		}

	}

	public static String ternaryTime(int a, int b) {
		// ternary operator to determine larger of two numbers. returns a if true, and b
		// if false
		String isSmaller = a < b ? a + " is the smaller number" : b + " is the  smaller number";
		return isSmaller;
	}

	// method to find palindromes
	public static void palindromeFinder() {
		// Creates an array list of type string
		ArrayList<String> newArrList = new ArrayList<String>();
		// adding all names to ArrayList
		newArrList.add("karan");
		newArrList.add("madam");
		newArrList.add("tom");
		newArrList.add("civic");
		newArrList.add("radar");
		newArrList.add("jimmy");
		newArrList.add("kayak");
		newArrList.add("john");
		newArrList.add("refer");
		newArrList.add("billy");
		newArrList.add("did");
		// Separate ArrayList to hold palindromes
		ArrayList<String> palArrList = new ArrayList<String>();
//		cycle through array list of strings checking each string using string reverse method written and used earlier
		for (int i = 0; i < newArrList.size(); i++) {
			// Returns true if current string is equal to reverse of itself
			if (newArrList.get(i).equals(stringReverse(newArrList.get(i)))) {
				// adds current string if returns true
				palArrList.add(newArrList.get(i));
			}

		}
		// prints palindrome arraylist to screen
		System.out.println(palArrList);

	}

	// method for creating fibonnachi s3equence
	public static void fibFinder() {
		// Two variables to start series, a sum variable to hold answer and one counter
		// variable
		int num1 = 0;
		int num2 = 1;
		int sum;
		int counter = 23;
		System.out.println("Here lies the fabled fibonacci sequence(Only through 25 iterations!):");
		System.out.print(num1 + ", " + num2 + ", ");
		for (int i = 0; i < counter; ++i) {
			// assignment logic
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
			System.out.print(sum + ", ");

		}
		System.out.println();

	}

//	method to give even numbers up tp one hundred
	public static void oneToHundredEvens() {
		// integer arrays fpr all numbers up to one hundred and another for only even
		// numbers
		int[] arr = new int[100];
		int[] evenArr = new int[50];

		for (int i = 0; i < 100; i++) {
			// populate array with 1 through 100 with 1 being zero indexed
			arr[i] = i + 1;
		}
		// for loop to cycle through each element checking for remainder when division
		// by 2
		for (int i = 0; i < 100; i++) {
			if (arr[i] % 2 == 0) {
				// adds even numbers to array using logic only even number will be tested
				evenArr[i / 2] = arr[i];
			}
		}
		// calls for each loop to cycle through integer array of even numbers.
		getEvens(evenArr);
	}

	// for each loop to print even number array
	public static void getEvens(int... v) {
		for (int x : v) {
			System.out.print(x + ", ");
		}
	}

	//
	public static void switchShower(int a) {
		// start of switch statement
		switch (a) {
		// first case gives square root of double 2
		case 1:
			System.out.println(Math.sqrt(2.0));
			break;
		// second case gives date and time
		case 2:
			Date today = Calendar.getInstance().getTime();
			System.out.println(today);
			break;
		// any other case i.e. 3 will give string split up to half length
		default:
			// string to be split
			String newString = "I am learning core java";
			// get length of string
			int n = newString.length();
			// character array to hold string
			char[] newCharArr = newString.toCharArray();
			// character array of length half plus one
			char[] firstHalf = new char[n / 2 + n % 2];
			// character array to hold second half of string
			char[] secondHalf = new char[n / 2];
			for (int i = 0; i < (n / 2 + n % 2); i++) {
				// populate array with first half of string
				firstHalf[i] = newCharArr[i];
			}
			for (int i = (n / 2 + n % 2); i < n; i++) {
				// populate with second half of string
				secondHalf[i - (n / 2 + n % 2)] = newCharArr[i];
			}
			// reformatting strings and printing to screen
			System.out.println();
			String firstString = new String(firstHalf);
			String secondString = new String(secondHalf);
			String[] stringArr = new String[2];
			stringArr[0] = firstString;
			stringArr[1] = secondString;
			System.out.println(stringArr[0]);
			System.out.println(stringArr[1]);

		}

	}

	public static double simpleInterest(double a, double b, double c) {
		// variable to hold interest calculations
		double interest;
		// calculate interest
		interest = a * b * c;
		// return interest
		return interest;

	}

	// Method to find primes
	public static void primeTime() {
		// two array lists, one for all numbers and other for noprime numbers
		ArrayList<Integer> fullList = new ArrayList<Integer>();
		ArrayList<Integer> noPrimeList = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			fullList.add(i);// loop to add numbers to list
		}
		for (int i = 2; i < 100; i++) {
			for (int j = 2; j <= (i / 2) + 1; j++) {
				// for loop to test each number divisibility up to half or number vakue
				if (fullList.get(i) % j == 0) {
					// if exactly divisible w/ no re,ainder non-prime gets added
					noPrimeList.add(fullList.get(i));
				}
			}
		}
		// make new set to remove duplicate values
		Set<Integer> noDuplicateNoPrime = new LinkedHashSet<Integer>(noPrimeList);
		// remove non prime numbers from list
		fullList.removeAll(noDuplicateNoPrime);
		// remove 1 from list since not prime
		fullList.remove(0);
		System.out.println(fullList);
	}

	public static void triangleTime() {
		// for loop with three iterations, each running one case of switch statement
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				System.out.println("0");
			} else if (i == 1) {
				System.out.println("10");
			} else if (i == 2) {
				System.out.println("101");
			} else {
				System.out.println("0101");
			}
		}

	}

//method to take command line argument and give length of string
	public static void demandTheCommand(String[] args) {
		char[] argument = args[0].toCharArray();
		System.out.println(args[0] + " has length: " + argument.length);
	}

	/// method to get evens, odds and nonprimes up to 10
	public static void arrayListFun() {
		// needed array lists, names are self-explanatory
		ArrayList<Integer> fullArray = new ArrayList<Integer>();
		ArrayList<Integer> evenArray = new ArrayList<Integer>();
		ArrayList<Integer> oddArray = new ArrayList<Integer>();
		ArrayList<Integer> noPrimeList = new ArrayList<Integer>();
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			// populate array lists
			fullArray.add(i);
			primeList.add(i);
		}
		System.out.println("Here is our full list of members.");
		System.out.print(fullArray);
		for (int i = 0; i < 10; i++) {
			if (fullArray.get(i) % 2 == 0) {// even numbers test
				evenArray.add(fullArray.get(i));
			}

		}
		int dummy = 0;
		for (int i = 0; i < evenArray.size(); i++) {
			// adds up all even numbers
			dummy = dummy + (int) evenArray.get(i);
		}

		System.out.println("\nHere are our even members:");
		System.out.println(evenArray);
		System.out.println("They're sum is: " + dummy);
		for (int i = 0; i < 10; i++) {// odd numbers test
			if (fullArray.get(i) % 2 != 0) {
				oddArray.add(fullArray.get(i));
			}
		}
		int summy = 0;
		for (int i = 0; i < oddArray.size(); i++) {
			// sums elements of odd integer array
			summy = summy + (int) oddArray.get(i);
		}
		System.out.println("Here are our odd members:");
		System.out.println(oddArray);
		System.out.println("They're sum is: " + summy);
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j <= (i / 2) + 1; j++) {
				if (fullArray.get(i) % j == 0) {
					noPrimeList.add(fullArray.get(i));
				}
			}
		}
		// remove duplicates
		Set<Integer> noDuplicateNoPrime = new LinkedHashSet<Integer>(noPrimeList);
		// output result
		System.out.println("Here are our subprime members");
		System.out.println(noDuplicateNoPrime);
	}

	public static void bubbleSorter() {
		// initial array
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int n = arr.length;// lengyth of array
		System.out.println("Unsorted array elements.");
		for (int i = 0; i < n; i++) {
			// print unsorted array
			System.out.print(arr[i] + ", ");
		}
		// dummy variable used for swapping
		int dummy = 0;
		for (int i = 0; i < n - 1; i++) {
			// nested for loop
			for (int j = 0; j < n - 1; j++) {
				// checking which is greater with neighbor of one higher index
				if (arr[j] > arr[j + 1]) {
					dummy = arr[j];
					arr[j] = arr[j + 1];// swapping
					arr[j + 1] = dummy;
				}

			}
		}
		System.out.println();
		System.out.println("Sorted array elements via,  you guessed it-Bubble Sort!");
		// outputting sorted elements
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		System.out.println("Question 1");
		bubbleSorter();

		System.out.println("==========================");
		System.out.println("Question 2");

		fibFinder();
		System.out.println("==========================");
		System.out.println("Question 3");
		System.out.println("We will pass in the string: Howdy");
		System.out.println("Here it is reversed:");
		System.out.println(stringReverse("Howdy"));
		System.out.println("Magic!");
		System.out.println();
		System.out.println("==========================");
		System.out.println("Question 4");
		System.out.println("Let's have some fun with factorials. Blow we have computed 10 factorial!");
		System.out.println(nFactorial(10));

		System.out.println("==========================");
		System.out.println("Question 5");
		System.out.println("Blow we will output the string: 'I like tacos' up to the 10th element in the string.");
		moreStringFun("I like tacos", 10);

		System.out.println("==========================");
		System.out.println("Question 6");
		System.out.println(
				"Below we will determine if two numbers are even or odd. First we'll look at 11, then we'll look at 42.");
		isEvenOrOdd(11);
		isEvenOrOdd(42);
		System.out.println("==========================");
		System.out.println("Question 7");
		// create new array list to hold employee info
		ArrayList<Employee> ar = new ArrayList<Employee>();
		// populating array list
		ar.add(new Employee("Jim", "Sales", 28));
		ar.add(new Employee("Pam", "Reception", 30));
		ar.add(new Employee("Creed", "Qualtiy Assurance", 95));
		ar.add(new Employee("Kelly", "Customer Service", 29));
		System.out.println("First we will have a look at the employees unsorted!");
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}

		// Sorting by name\
		System.out.println("Here we will present the employees sorted by their name in ascending order");
		Collections.sort(ar, new SortByName());
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		// Sorting by department
		System.out.println("Here we will present the employees sorted by their depertment in ascending order");
		Collections.sort(ar, new SortByDep());
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		// Sorting by age
		System.out.println("Finally we will present the employees sorted by their age in ascending order");
		Collections.sort(ar, new SortByAge());
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		System.out.println("==========================");
		System.out.println("Question 8");
		System.out.println("The following are palindromes:");
		palindromeFinder();

		System.out.println("==========================");
		System.out.println("Question 9");
		System.out.println("Listed below are the prime numbers between 1 and 100. (p.s. 1 is not a prime number)");
		primeTime();
		System.out.println("==========================");
		System.out.println("Question 10");
		System.out
				.println("Below we will see which number is smaller between the numbers 4 and 5 - A difficult task.  ");
		System.out.println(ternaryTime(4, 5));
		System.out.println("==========================");
		System.out.println("Question 11");
		System.out.println("Here is the first float we are accessing " + FibSequence.getFloatOne()
				+ " and here is the second float we are accessing " + FibSequence.getSecondFloat());
		System.out.println("==========================");
		System.out.println("Question 12");
		System.out.println("If you were curious, here are the even numbers between 1 and 100.");
		oneToHundredEvens();
		System.out.println();
		System.out.println("==========================");
		System.out.println("Question 13");
		System.out.println("Here's a pretty picture.");
		triangleTime();
		System.out.println("==========================");
		System.out.println("Question 14");
		System.out.println(
				"Below we'll go through three switch case. First we'll find the square root of 2, then we'll display the dat and finally split a string");
		switchShower(1);
		switchShower(2);
		switchShower(3);
		System.out.println("==========================");
		System.out.println("Question 15");
		System.out.println("We'll implement interfaces for the four basic mathematical operations");
		// implementing interfaces
		interfaceImplementer implement = new interfaceImplementer();
		System.out.println(implement.addEmUp(25, 26));
		System.out.println(implement.productTime(7, 6));
		System.out.println(implement.subtractionAction(5, 6));
		System.out.println(implement.divideWithPride(24, 6));
		System.out.println("==========================");
		System.out.println("Question 16");
		System.out.println("");
		demandTheCommand(args);
		System.out.println("==========================");
		System.out.println("Question 17");
		Scanner scanIt = new Scanner(System.in);
		System.out.println("Please enter a principle amount. The number can be a whole number or decimal.");
		double a = scanIt.nextDouble();
		System.out.println("Please enter an interest amount. The number can be a whole number or decimal.");
		double b = scanIt.nextDouble();
		System.out.println("Please enter a time period in years. The number can be a whole number or decimal.");
		double c = scanIt.nextDouble();
		System.out.println("Here is the amount due including simple interest");
		System.out.println(simpleInterest(a, b, c));
		System.out.println("==========================");
		System.out.println("Question 18");
		subClass z = new subClass();
		System.out.println(z.isUpper("wHat Do yOu mEaN"));
		System.out.println(z.toUpper("stop yelling"));
		System.out.println(z.toInt("32"));
		System.out.println("==========================");
		System.out.println("Question 19");
		arrayListFun();
		System.out.println("==========================");
		System.out.println("Question 20!");
		String line = "";
		String splitBy = ":";

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("Data.txt"));
			// while not at end of file
			while ((line = br.readLine()) != null) {
				// split by given token
				String[] celebrity = line.split(splitBy);
				// formatting and concatonating desired output
				System.out.println("Name: " + celebrity[0] + " " + celebrity[1]);
				System.out.println("Age: " + celebrity[2]);
				System.out.println("State: " + celebrity[3]);
				System.out.println();
			}
			// catch blocks for checked exceptions
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

abstract class superClass {
	superClass() {
		super();
	}

	public abstract boolean isUpper(String c);

	public abstract String toUpper(String a);

	public abstract int toInt(String b);
}

class subClass extends superClass {

	@Override
	public boolean isUpper(String c) {
		boolean flag = false;

		char[] loopedString = c.toCharArray();
		for (int i = 0; i < loopedString.length; i++) {
			if (Character.isUpperCase(loopedString[i])) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public String toUpper(String a) {
		String d = a.toUpperCase();
		return d;
	}

	@Override
	public int toInt(String b) {
		int x = Integer.parseInt(b);
		int result = x + 10;
		return result;
	}

}

//employee class
class Employee {

	String name;
	String department;
	int age;

	// employee constructor
	Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	// output as string to main
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
}

class SortByName implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}

class SortByDep implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}

class SortByAge implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}

class interfaceImplementer implements FirstInterface {

	@Override
	public int addEmUp(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int productTime(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int subtractionAction(int a, int b) {
		// TODO Auto-generated method stub
		return Math.abs(a - b);
	}

	@Override
	public int divideWithPride(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}

}
