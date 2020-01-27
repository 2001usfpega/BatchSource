package com.revature.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.revature.other.FloatVariables;
import com.revature.questions.InterfacePract;

import java.util.Collections;

public class QuestionsMain {

	// Driver

	public static void main(String[] args) throws IOException {
		int [] sortedArr = q1(numArray);
		
		for(int i =0; i<sortedArr.length; i++) {
			System.out.print(sortedArr[i] + ", ");
			
		}
		System.out.println();
		int[] fibArray1 = q2();
		
		for(int x:fibArray1) {
			System.out.print(x + ", ");
		}
		System.out.println();
		System.out.println(q3("Absolutely"));
		System.out.println("Next is the factorial of 5");
		System.out.println(q4(5));
		System.out.println(q5("Absolutely", 5));;
		boolean isItEven = q6(6);
		if(isItEven) {
			System.out.println("This number is even");
		}else {
			System.out.println("This number is odd");
		}

		// q7 section

		ArrayList<Employee> empArray = new ArrayList<Employee>();

		empArray.add(new Employee("John", 3, 30));
		empArray.add(new Employee("Sylvia", 2, 25));
		empArray.add(new Employee("Jane", 1, 32));

		Collections.sort(empArray, new CompareAge());

		System.out.println("Sorted by Age");
		for (Employee emp : empArray) {
			System.out.println(emp.name + " " + emp.age);
		}

		System.out.println("Sorted by Dept#");
		Collections.sort(empArray, new CompareDept());

		for (Employee emp : empArray) {
			System.out.println(emp.name + " " + emp.department);
		}

		System.out.println("Sorted by Name");
		Collections.sort(empArray, new CompareName());

		for (Employee emp : empArray) {
			System.out.println(emp.name);
		}

		System.out.println();

		// q8 section

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

		// Question 9 section

		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Integer> primeList = new ArrayList<>();

		PrimeNums.addIntegers(numList);
		System.out.println("These are primes");
		for (int i = 0; i < numList.size(); i++) {
			int curNum = numList.get(i);
			if (PrimeNums.findPrimes(curNum)) {

				primeList.add(curNum);

			}
		}
		for (int i = 0; i < primeList.size(); i++) {
			System.out.print(primeList.get(i) + " ");
		}

		// Question 10 section

		System.out.println();

		System.out.println(minOfTwo.findMinNum(5, 11));

		// Question 11 Section
		// Looks like this only about importing the class from the package
		// fully qualified class name?

		FloatVariables floaties = new FloatVariables();
		System.out.println(floaties.getNum1());
		System.out.println(floaties.getNum2());

		// Question 12
		NumArray.addNumsToArray();
		NumArray.checkEvens(NumArray.nums);

		System.out.println();

		// Question 13

		Triangle.traingleMethod(Triangle.zeroArr);

		// Question 14
		// I guess we could use a scanner class to
		// take in the case number but I'm just going to pass in numbers

		CaseSwitch.caser(1);
		CaseSwitch.caser(2);
		CaseSwitch.caser(3);

		// Question 15

		InterfacePract myInterface = new InterfacePract();

		System.out.println(myInterface.addition(2, 3));
		System.out.println(myInterface.subtraction(2, 3));
		System.out.println(myInterface.multiplication(2, 3));
		System.out.println(myInterface.division(6, 3));

		// Question 16
		// I ran into compilation issues when running javac
		// on this class so I made an array of strings to run
		// the stringArg method.

		String[] words = { "hello", "how", "are", "you" };
		StringNum.stringArg(words);

		// Question 17

		System.out.println(Interest.calcInt());

		// Question 18

		Q18Sub question18 = new Q18Sub();
		System.out.println(question18.checkUpperCase("saniTy"));
		;
		System.out.println(question18.theUpperCase("lilLetters"));
		System.out.println(question18.stringToNum("11"));

		// Question 19

		ArrayList<Integer> intArrList = new ArrayList<>();

		// Q19.arrListQuestion(intArrList);
		// Q19.arrListQuestion(intArrList).removeAll(primeList);
		q19AddToArray(intArrList);
		System.out.println("This is the sum of even numbers");
		System.out.println(q19SumArray(intArrList));
		System.out.println("This is the sum of odd numbers");
		System.out.println(q19SubArray(intArrList));
		intArrList.removeAll(primeList);
		System.out.println("This is the array without primes");
		for (int i = 0; i < intArrList.size(); i++) {
			System.out.print(intArrList.get(i) + ", ");
		}
		System.out.println();

		// Question 20

		File textFile = new File("/Users/emanuelpires/Desktop/Crap/BatchSource/Assignment1.27/Data.txt");
		FileReader fr = new FileReader(textFile);
		BufferedReader reader = new BufferedReader(fr);
		String st;
		String main ="";
		while ((st = reader.readLine()) != null) {
			 String[]mainArr = st.split(":");
			
			System.out.println();
			System.out.println("Name: " +mainArr[0] + " " +mainArr[1] );
			System.out.println("Age: " + mainArr[2] + " years" );
			System.out.println("State: " +mainArr[3] + " state");
		}
		
		
		

	}

	static // Methods for Questions Sections
	//
	int[] numArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
	public static int[] q1(int []numArray) {
		

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
//		for (int l = 0; l < numArray.length; l++) {
//			System.out.print(numArray[l]);
//		}
		return numArray;
		//System.out.print("\n");

	}

	public static int[] q2() {
		// 25th fibonacci number is 75025

		int fibNumber1 = 0;
		int fibNumber2 = 1;
		int sum;
		int []fibArray =new int [25];
		
		fibArray[0] =0;
		fibArray[1] =1;
		
		for (int i = 2; i < 25; i++) {

			sum = fibNumber1 + fibNumber2;

			fibNumber1 = fibNumber2;
			fibNumber2 = sum;

			fibArray[i] = fibNumber2;

		}
		return fibArray;
	}
	
	

	public static String q3(String word) {
		// stick the characters of the word into an array and spit
		// the array out backwards.
		
		char[] charArray = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			charArray[i] = word.charAt(i);
		}
		
		String rev = "";

		for (int l = 9; l > -1; l--) {
			//System.out.print(charArray[l]);
			rev+=charArray[l];
		}
		return rev;

	}

	public static int q4(int n) {
		
		//using recursion to find the factorial
		if (n <= 1) {
			return 1;
		} else {
			return (n * q4(n - 1));
		}

	}

	public static String q5(String str, int idx) {
		String wordPiece = "";
		for (int n = 0; n < idx; n++) {
			//System.out.print(str.charAt(n));
			wordPiece +=str.charAt(n);
		}
		return wordPiece;
	}

	public static boolean q6(int n) {
		int newNum = n / 2;
		System.out.println(newNum);
		int nextNum = newNum * 2;
		if (nextNum == n) {
			return true;
		} else {
			return false;
		}
	}

	public static void q19AddToArray(ArrayList list) {
		for (int i = 1; i < 11; i++) {
			list.add(i);

		}
	}

	public static int q19SumArray(ArrayList list) {
		int evenSum = 0;
		for (int i = 0; i < list.size(); i++) {

			int theEvenNums = Integer.valueOf(list.get(i).toString());
			if (theEvenNums % 2 == 0) {
				evenSum += theEvenNums;
			}
		}

		return evenSum;
	}

	public static int q19SubArray(ArrayList list) {
		int oddSum = 0;
		for (int i = 0; i < list.size(); i++) {

			int theOddNums = Integer.valueOf(list.get(i).toString());
			if (!((theOddNums % 2) == 0)) {
				oddSum += theOddNums;
			}
		}
		return oddSum;
	}
}
