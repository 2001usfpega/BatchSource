package com.revature.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.revature.question7.Employee;
import com.revature.question7.Question7;
import com.revature.floats.Floats;
import com.revature.question15.*;
import com.revature.question18.Question18;

public class Assignment1 {

	public static void main(String[] args) {
		System.out.println("==========QUESTION 1==========");
		question1();
		
		System.out.println("==========QUESTION 2==========");
		question2();
		
		System.out.println("==========QUESTION 3==========");
		System.out.println(question3("Question 3") + "\n");//Feel free to change the input
		
		System.out.println("==========QUESTION 4==========");
		System.out.println(question4(4) + "\n");//Feel free to change the input
		
		System.out.println("==========QUESTION 5==========");
		question5("Question 5", 6);
		
		System.out.println("==========QUESTION 6==========");
		question6(63);
		
		System.out.println("==========QUESTION 7==========");
		ArrayList<Employee> list = new ArrayList<>();
		ArrayList<Employee> list1 = new ArrayList<>();
		ArrayList<Employee> list2 = new ArrayList<>();
		Employee emp0 = new Employee("Jacob Lail", "IT", 22);
		Employee emp1 = new Employee("Mark Lail", "IT", 22);
		Employee emp2 = new Employee("Matt Knighten", "IT", 25);
		list.add(emp0);
		list.add(emp1);
		list.add(emp2);
		question7Sort(list);
		emp0 = new Employee("Jacob Lail", "IT", 22);
		emp1 = new Employee("Jacob Lail", "QC", 22);
		emp2 = new Employee("Jacob Lail", "Marketing", 22);
		list1.add(emp0);
		list1.add(emp1);
		list1.add(emp2);
		question7Sort(list1);
		emp0 = new Employee("Jacob Lail", "IT", 24);
		emp1 = new Employee("Jacob Lail", "IT", 22);
		emp2 = new Employee("Jacob Lail", "IT", 20);
		list2.add(emp0);
		list2.add(emp1);
		list2.add(emp2);
		question7Sort(list2);
		
		System.out.println("==========QUESTION 8==========");
		question8();
		
		System.out.println("==========QUESTION 9==========");
		ArrayList<Integer> primes = question9();
		
		System.out.println("==========QUESTION 10==========");
		question10(12,8);
		
		System.out.println("==========QUESTION 11==========");
		Floats floats = new Floats();
		System.out.println(floats.getf1() + " " + floats.getf2() + "\n");
		
		System.out.println("==========QUESTION 12==========");
		question12();
		
		System.out.println("==========QUESTION 13==========");
		question13();
		
		System.out.println("==========QUESTION 14==========");
		question14(3);
		
		System.out.println("==========QUESTION 15==========");
		Question15 q15 = new Question15();
		q15.addition(15, 25);
		q15.subtraction(65, 21);
		q15.multiplication(12, 67);
		q15.division(76, 8);
		System.out.println();
		
		System.out.println("==========QUESTION 16==========");
		System.out.println(args[0] + " is " + args[0].length() + " characters long.\n");
		
		System.out.println("==========QUESTION 17==========");
		question17();
		
		System.out.println("==========QUESTION 18==========");
		Question18 q18 = new Question18();
		System.out.println("Checking for uppercase on string \"Question 18\": " + q18.checkUppercase("Question 18"));
		System.out.println("Converting string \"Question 18\" to upper case: " + q18.toUpperCase("Question 18"));
		System.out.print("Converting string \"Question 18\" to an int: ");
		q18.toInt("Question 18");
		
		System.out.println("==========QUESTION 19==========");
		question19(primes);
		
		System.out.println("==========QUESTION 20==========");
		question20();

	}
	
	/**
	 * Question 1 of the core Java assignment, performs a bubble sort
	 * on the following integer array:
	 * {1,0,5,6,3,2,3,7,9,8,4}
	 */
	public static void question1() {
		int[] givenArray = {1,0,5,6,3,2,3,7,9,8,4};
		
		// stores length of the array for ease, don't have to type 
		// givenArray.length every time
		int len = givenArray.length; 
		
		//The outer loop allows us to do multiple passes of the list so we can perform the logic of the sort.
		for(int i = 0; i < len-1; i++) {
			
			//Loops through the array until length-1-i(amount of iterations of the sort have passed)
			for(int j = 0; j < len-i-1; j++) {
				
				//Checking if value at spot (j) is greater than the value next to it. If so, swap the values 
				if(givenArray[j] > givenArray[j+1]) {
					int temp = givenArray[j];
					
					//swapping the values using a temporary variable so that we do not lose the value at index (j)
					givenArray[j] = givenArray[j+1];
					givenArray[j+1] = temp;
				}
			}
		}
		
		/*
		 * This for loop only prints out the new array and is only used 
		 * for formatting
		 */
		System.out.print("Newly Sorted Array: { ");
		for(int i : givenArray) {
			System.out.print(i + " ");
		}
		System.out.println("}\n");
	}
	
	/**
	 * Prints out the first 27 (generates 25 due to giving the first two numbers of the sequence) values
	 * of the Fibonacci sequence using a for loop.
	 */
	public static void question2() {
		//using ArrayList for dynamic size
		ArrayList<Integer> fib = new ArrayList<>();
		
		//Give the first two digits of the sequence because to calculate the next term
		//you have to add the previous two terms together
		fib.add(0);
		fib.add(1);
		System.out.print("The First 25 digits of the Fibonacci sequence are: \n");
		System.out.print(fib.get(0) + " " + fib.get(1) + " ");
		for(int i = 1; i < 25; i++) {
			
			//Adds the previous two terms together, adds it to the 
			//list(used for calculation of next term), and prints it out.
			Integer next = fib.get(i) + fib.get(i-1);
			fib.add(next);
			System.out.print(next + " ");
		}
		System.out.println("\n");
	}
	
	/**
	 * reverses an input String without using built-in reverse methods or 
	 * using temporary variables.
	 */
	public static String question3(String input) {
		//Converts the input String into a character array
		char[] inputStr = input.toCharArray();
		int len = inputStr.length;
		
		//Creating a new character array based on the length of the input string
		char[] output = new char[len];
		
		//Looping through placing every sequential character in the input into the back 
		//of the output array
		for(int i = 0; i< inputStr.length; i++) {
			output[--len] = inputStr[i];
		}
		
		//Converts the output character array into a new string and prints
		//it to the terminal
		String outputStr = new String(output);
		return outputStr;
	}
	
	/**
	 * Prints out N factorial, done using recursion
	 */
	public static int question4(int input) {
		//This is the base case
		if(input == 1) {
			return 1;
			
			//if input is still greater than 1, multiply it by the 
			//returned value of this method with input - 1
		} else {
			return input*question4(input-1);
		}
	}
	
	/**
	 * Performs the substring function between 0 and given index-1 inclusive
	 * without using built-in substring methods.
	 */
	public static void question5(String in, int index) {
		char[] input = in.toCharArray();
		char[] output = new char[index];
		
		//Makes sure that the given index is a valid index size
		if(index < input.length) {
			
			//Places the chars into the output until the index is reached
			for(int i = 0; i < index-1; i++) {
				output[i] = input[i];
			}
		}
		System.out.println(new String(output) + "\n");
	}
	
	/**
	 * Determines whether or not a given input is even or odd without 
	 * using the modulus(%) operator
	 */
	public static void question6(int input) {
		//Using bit shifting to leave only the sign bit(and ones place)
		//then just check the input again, -1 == odd and 0 == even
		input = input<<31;
		input = input>>31;
		
		if(input == 0) {
			System.out.println("The given input is even\n");
		} else {
			System.out.println("The given input is odd\n");
		}
	}
	
	/**
	 * Does the sorting for question 7
	 */
	public static void question7Sort(ArrayList<Employee> list) {
		int len = list.size();
		Question7 q7 = new Question7();
		//The outer loop allows us to do multiple passes of the list so we can perform the logic of the sort.
		for(int i = 0; i < len-1; i++) {
			
			//Loops through the array until length-1-i(amount of iterations of the sort have passed)
			for(int j = 0; j < len-i-1; j++) {
				
				//Checking if value at spot (j) is greater than the value next to it. If so, swap the values 
				if(q7.compare(list.get(j), list.get(j+1)) > 0) {
					Employee temp = list.get(j);
					
					//swapping the values using a temporary variable so that we do not lose the value at index (j)
					list.add(j, list.get(j+1));
					list.remove(j+1);
					list.add(j+1, temp);
					list.remove(j+2);
				}
			}
		}
		for(Employee emp : list) {
			System.out.println(emp.toString());
		}
		System.out.println();
	}
	
	/**
	 * stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did"
	 */
	public static void question8() {
		ArrayList<String> givenList = question8ArrayList();
		ArrayList<String> palindromes = new ArrayList<>();
		for(String str : givenList) {
			boolean flag = true;
			String strRev = question3(str);
			char[] strC = str.toCharArray();
			char[] strRevC = strRev.toCharArray();
			
			//Checks if the reversed string and the correct string
			//have the same character values at each index. If so,
			//the string is a palindrome.
			for(int i = 0; i < strC.length; i++) {
				if(strC[i] != strRevC[i]) {
					flag = false;
				}
			}
			if(flag) {
				palindromes.add(str);
			}
		}
		System.out.print("The palindromes are: ");
		for(String str : palindromes) {
			System.out.print(str + " ");
		}
		System.out.println("\n");
		
	}
	
	/**
	 * Stores numbers from 1 to 100 in an array, and prints out all
	 * of the primes numbers.
	 */
	public static ArrayList<Integer> question9() {
		int half;
		boolean flag = true;
		ArrayList<Integer> list = fillArrayList();
		ArrayList<Integer> primes = new ArrayList<>();
		
		for(int i : list) {
			
			//default add 1 to primes list
			if(i == 1) {
				primes.add(i);
			} else {
				flag = true;
				half = i /2;
				
				//Loops through using the modulus operator on the given value from 
				//2 to givenValue/2. if modulus ever returns 0, the given value
				//cannot be a prime number
				for(int j = 2; j < half+1; j++) {
					if(i % j == 0) {
						flag = false;
					}
				}
				if(flag) {
					primes.add(i);
				}
			}
			
		}
		System.out.print("The primes are: ");
		for(int i: primes) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		return primes;
	}
	
	/**
	 * Finds the minimum of two numbers using ternary operators.
	 */
	public static void question10(int a, int b){
		int c;
		c = (a < b) ? a : b; //if a < b c = a, if a > b   
		System.out.println("The minimum of the input is: " + c + "\n");
	}
	
	/**
	 * Stores numbers from 1 to 100 in an array. Prints out all the even numbers from the array. 
	 */
	public static void question12() {
		ArrayList<Integer> list = fillArrayList();
		System.out.print("The even numbers are: ");
		for(int i : list) {
			//Only prints out if the modulus of the input over 2 is equal to 0
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Displays the triangle on the console as follows using a do-while loop nested
	 * in a regular for loop.
	 * Output:
	 * 0
	 * 1 0 
	 * 1 0 1
	 * 0 1 0 1
	 * 0 1 0 1 0
	 */
	public static void question13() {
		//output of the method, flips between 0 and 1
		int out = 0;
		for(int i = 1; i <= 5; i++) {
			int count = 0;
			
			//Loops through printing the output based on the amount of
			//iterations in for loop
			do {
				System.out.print(out + " ");
				
				//Flips the output between 0 and 1
				if(out == 0) {
					out++;
				} else {
					out--;
				}
				count++;
			} while(count < i);
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Displays the following output using a switch-case
	 * Case 1: Find the square root of a number using the Math class method.
	 * Case 2: Display today’s date.
	 * Case 3: Split the following string and store it in a string array.
	 * “I am learning Core Java”
	 */
	public static void question14(int input) {
		String str = "I am learning Core Java";
		switch(input) {
			case 1:
				System.out.println(Math.sqrt(81));
				break;
			case 2:
				Date date = new Date();
				System.out.println(date);
				break;
			case 3:
				String [] strArr = str.split(" ");
				for(String out : strArr) {
					System.out.print(out + " : ");
				}
		}
		System.out.println("\n");
	}
	
	/**
	 * calculates the simple interest on the principal, rate of interest and number of 
	 * years provided by the user. 
	 */
	public static void question17() {
		Scanner scan = new Scanner(System.in);
		double interest = 0;
		System.out.print("Enter principal >> ");
		int principal = scan.nextInt();
		System.out.print("Enter the rate of interest >> ");
		double roi = scan.nextDouble();
		System.out.print("Enter number of years >> ");
		int years = scan.nextInt();
		interest = principal * roi * years;
		System.out.println("Simple interest = " + interest + "\n");
	}
	
	/**
	 * Creates an ArrayList and inserts integers 1 through 10. Displays the ArrayList. 
	 * Adds all the even numbers up and displays the result. Adds all the odd numbers up
	 * and displays the result. Removes the prime numbers from the ArrayList and prints
	 * out the remaining ArrayList.
	 */
	public static void question19(ArrayList<Integer> primes) {
		ArrayList<Integer> listOfTen = new ArrayList<>();
		int even = 0;
		int odd = 0;
		for(int i = 1; i <= 10; i++) {
			listOfTen.add(i);
		}
		System.out.print("Starting list: ");
		for(int i : listOfTen) {
			System.out.print(i + " ");
			if(i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
		System.out.println("\nSum of even numbers: " + even);
		System.out.println("Sum of odd numbers: " + odd);
		listOfTen.removeAll(primes);
		System.out.print("List with primes removed: ");
		for(int i : listOfTen) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
	}
	
	public static void question20() {
		File file = new File("C:\\Users\\P0RKC\\Documents\\2001UsfRevature\\BatchSource\\CoreJavaAssignment\\src\\com\\revature\\assignment\\Question20.txt");
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String str = scan.nextLine();
				String[] input = str.split(":");
				System.out.println("Name: " + input[0] + " " + input[1]);
				System.out.println("Age: " + input[2] + " years");
				System.out.println("State: " + input[3] + " state\n");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not Found");
		}
	}
	
	/**
	 * Fills an ArrayList with the values of 1 to 100 and returns it.
	 */
	private static ArrayList<Integer> fillArrayList(){
		ArrayList<Integer> list = new ArrayList<>();
		
		//looping through to add all integers from 1 to 100 into the ArrayList
		for(int i = 1; i <= 100; i++) {
			list.add(i);
		}
		return list;
	}
	
	/**
	 * Fills the ArrayList for question 8 with the following strings
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did"
	 */
	private static ArrayList<String> question8ArrayList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		return list;
	}
		
}
