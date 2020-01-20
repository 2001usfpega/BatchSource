package com.revature.questions;

import java.util.ArrayList;

import com.revature.other.FloatVariables;
import java.util.Collections;

public class QuestionsMain {
	
	
	//Driver

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q1();
		q2();
		q3();
		System.out.println();
		System.out.println(q4(5));
		q5("Absolutely", 5);
		q6(6);
		
		
		//q7 section
		
		ArrayList<Employee> empArray = new ArrayList<Employee>();
		
		empArray.add(new Employee("John", 3, 30));
		empArray.add(new Employee("Sylvia", 2, 25));
		empArray.add(new Employee("Jane", 1, 32));
		
		Collections.sort(empArray, new CompareAge());
		
		System.out.println("Sorted by Age");
		for(Employee emp: empArray) {
			System.out.println(emp.name + " " + emp.age);
		}
		
		System.out.println("Sorted by Dept#");
		Collections.sort(empArray, new CompareDept());
		
		for(Employee emp: empArray) {
			System.out.println(emp.name + " " + emp.department);
		}
		
		System.out.println("Sorted by Name");
		Collections.sort(empArray, new CompareName());
		
		for(Employee emp: empArray) {
			System.out.println(emp.name );
		}
		
		System.out.println();
		
		//q8 section
		
		ArrayList<String> nameArr = new ArrayList<>();
		nameArr.add("karan");
		nameArr.add("madam");
		nameArr.add("tom");
		nameArr.add("civic");
		nameArr.add("radar");	
		nameArr.add("jimmy");
		nameArr.add("kayak");
		nameArr.add("john");
		nameArr.add("refer");
		nameArr.add("billy");
		nameArr.add("did");
		
		PalindromeArray palCalc = new PalindromeArray();
		System.out.println("This is the Array of names");
		palCalc.printNames(nameArr); 
		System.out.println();
		
		//Question 9 section
		
		ArrayList<Integer> numList = new ArrayList<>();
		
		PrimeNums.addIntegers(numList);
		
		PrimeNums.findPrimes(numList);;
		
		
		//Question 10 section
		
		System.out.println();
		
		System.out.println(minOfTwo.findMinNum(5, 11));
		
		//Question 11 Section
		//Looks like this only about importing the class from the package
		//fully qualified class name?
		
		FloatVariables floaties = new FloatVariables();
		System.out.println(floaties.getNum1());
		System.out.println(floaties.getNum2());
		
		
		//Question 12
		NumArray.addNumsToArray();
		NumArray.checkEvens(NumArray.nums);
		
		System.out.println();
		
		//Question 13
		
		Triangle.traingleMethod(Triangle.zeroArr);
		
		//Question 14
		//I guess we could use a scanner class to 
		//take in the case number but I'm just going to pass in numbers
		
		
	}
	
	
	
	//Methods for Questions Sections
	//

	public static void q1() {
		int[] numArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		int firstNum;
		int secondNum;
		for (int i = 0; i < numArray.length; i++) {

			for (int k = i; k < numArray.length - 1; k++) {

				if (numArray[k + 1] < numArray[k]) {

					firstNum = numArray[k];
					secondNum = numArray[k + 1];
					numArray[k] = secondNum;
					numArray[k + 1] = firstNum;

				}

			}
		}

		// Print Array
		for (int l = 0; l < numArray.length; l++) {
			System.out.print(numArray[l]);
		}

		System.out.print("\n");

	}

	public static void q2() {
		// 25th fibonacci number is 75025

		int fibNumber1 = 0;
		int fibNumber2 = 1;
		int sum;
		System.out.print(fibNumber1 + ", ");
		System.out.print(fibNumber2 + ", ");
		for (int i = 0; i < 24; i++) {

			sum = fibNumber1 + fibNumber2;

			fibNumber1 = fibNumber2;
			fibNumber2 = sum;

			System.out.print(sum + ", ");

		}
		System.out.println();
	}

	public static void q3() {
		// stick the characters of the word into an array and spit
		// the array out backwards.
		String word = "Absolutely";
		char[] charArray = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			charArray[i] = word.charAt(i);
		}

		for (int l = 9; l > -1; l--) {
			System.out.print(charArray[l]);
		}

	}

	public static int q4(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return (n * q4(n - 1));
		}

	}

	public static void q5(String str, int idx) {
		for (int n = 0; n < idx; n++) {
			System.out.print(str.charAt(n));
		}
		System.out.println();
	}
	
	public static void q6(int n) {
	int newNum = n/2;
	int nextNum = newNum*2;
	if(nextNum==n) {
		System.out.println("this number is even");
	}else {
		System.out.println("this number is odd");
	}
	}

}
