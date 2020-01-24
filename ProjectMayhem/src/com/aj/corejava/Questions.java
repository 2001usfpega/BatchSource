package com.aj.corejava;

import com.aj.otherpackage.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Questions {

	static Scanner getInput = new Scanner(System.in);

	public static void printSeparator() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}

	public static int[] q1BubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int currentNum = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = currentNum;
				}
			}
		}
		System.out.println("Q1. Bubble Sort: ");
		System.out.println("    Original array: [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4]");
		System.out.println("    Sorted array: " + Arrays.toString(arr));
		return arr;

	}

	public static int[] q2Fibonacci() {
		int[] fibonacci = new int[24];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		int num1 = fibonacci[0];
		int num2 = fibonacci[1];
		int num3;
		int count = 24;

		for (int i = 2; i < count; ++i) {
			num3 = num1 + num2;
			fibonacci[i] = num3;
			num1 = num2;
			num2 = num3;
		}
		System.out.println("Q2. Fibonacci Numbers: ");
		System.out.println("    " + Arrays.toString(fibonacci));
		return fibonacci;
	}

	public static String q3ReverseString(String str) {
		char[] charArr = str.toCharArray();
		int i = 0;
		int j = charArr.length - 1;
		while (i < j) {
			charArr[i] ^= charArr[j];
			charArr[j] ^= charArr[i];
			charArr[i] ^= charArr[j];
			++i;
			--j;
		}
		String charArrString = new String(charArr);
		System.out.println("Q3. Reverse String:");
		System.out.println("    Original string: " + str);
		System.out.println("    Reversed string: " + charArrString);
		return charArrString;
	}

	public static int q4NxFactorial(int num) {
		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}
		System.out.println("Q4. N Factorial: ");
		System.out.println("    The factorial of " + num + " is " + factorial);

		return factorial;
	}

	public static String q5SubstringMethod(String st, int idx) {
		char[] charArr = st.toCharArray();
		String returnedStr = "";
		if (idx > charArr.length - 1) {
			System.out.println("Please choose an index that is within range.");
		} else {
			for (int i = 0; i < idx; i++) {
				returnedStr += charArr[i];
			}
		}

		System.out.println("Q5. My Own Substring Method:");
		System.out.println("    Original string: " + st);
		System.out.println("    Substring between 0 and " + idx + ": " + returnedStr);

		return returnedStr;
	}

	public static boolean q6isEven(int n) {
		boolean isEven = true;

		for (int i = 1; i <= n; i++) {
			isEven = !isEven;
		}
		System.out.println("Q6. IsEven Without %:");
		if (isEven) {
			System.out.println("    The number you have chosen, " + n + ", is even.");
		} else {
			System.out.println("    The number you have chosen, " + n + ", is odd.");
		}

		/*
		 * with straight-up division: if((n/2) * 2 == num) { isEven = true; }
		 * 
		 * comparing bitwise with ternary:
		 * 
		 * (( n & 0x0001) == 1) ? "odd" : "even");
		 */
		return isEven;
	}

	public static String[] q7ComparatorSort() {
		System.out.println("Q7. Sorting Employees with Comparator Interface:");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String[] sortedArray = new String[9];
		int counter = 0;

		Employee p1 = new Employee("AJ", "IT", "30");
		Employee p2 = new Employee("Sonya", "Construction", "33");
		Employee p3 = new Employee("Alia", "Coding", "21");
		employees.add(p1);
		employees.add(p2);
		employees.add(p3);

		System.out.println("    Employees Sorted by Age:\n");
		SortByAge ageSort = new SortByAge();
		Collections.sort(employees, ageSort);

		for (Employee x : employees) {
			sortedArray[counter] = x.getAge();
			counter++;
			System.out.println("    " + x.getAge());
		}
		System.out.println("    ------");
		System.out.println("    Employees Sorted by Name:\n");
		SortByName nameSort = new SortByName();
		Collections.sort(employees, nameSort);

		for (Employee a : employees) {
			System.out.println("    " + a.getName());
			sortedArray[counter] = a.getName();
			counter++;
		}
		System.out.println("    ------");

		System.out.println("    Employees Sorted by Department:\n");
		SortByDept deptSort = new SortByDept();
		Collections.sort(employees, deptSort);

		for (Employee j : employees) {
			System.out.println("    " + j.getDepartment());
			sortedArray[counter] = j.getDepartment();
			counter++;
		}
		System.out.println("    ------");
//		for (String i : sortedArray) {
//			System.out.println(i);
//		}
		return sortedArray;
	}

	public static String[] q8palindromeArrayList() {
		String[] wordArr = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		ArrayList<String> arrList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		String[] palArr = new String[6];
		Collections.addAll(arrList, wordArr);
		System.out.println("Q8. Which Words Are Palindromes?");
		System.out.println("    This is the original array: " + arrList);

		for (String x : arrList) {
			char[] charArr = x.toCharArray();
			int lgth = charArr.length;
			boolean isPalindrome = false;

			for (int i = 0; i < lgth; i++) {
				if (charArr[i] != charArr[lgth - i - 1]) {
					isPalindrome = false;
				} else {
					isPalindrome = true;
				}
			}
			if (isPalindrome == true) {
				palindromes.add(x);
			}
		}

		for (int s = 0; s < palindromes.size(); s++) {
			palArr[s] = palindromes.get(s);
		}
		System.out.println("    These are the palindromes: " + palindromes);
//		System.out.println(palArr);

		return palArr;
	}

	public static ArrayList<Integer> q9ArrayListPrime() {
		ArrayList<Integer> oneToAhundred = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for (int i = 0; i < 101; i++) {
			oneToAhundred.add(i);
		}

		for (int j = 1; j < oneToAhundred.size(); j++) {
			boolean isPrime = true;

			for (int x = 2; x < j; x++) {
				if (j % x == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(j);
			}
		}

		System.out.println("Q9. Print Primes from 0-100 Array List:");
		System.out.println("    " + primes);

		return primes;
	}

	public static int q10TernaryFindMinimum(int n1, int n2) {
		System.out.println("Q10. Find The Smaller Number with Ternary Operator:");
		System.out.print("     The smaller number is " + ((n1 > n2) ? n2 : n1) + "\n");
		return ((n1 > n2) ? n2 : n1);
	}

	public static Float[] q11FloatVars() {
		FloatVars floats = new FloatVars();
		Float[] floatArr = new Float[2];
		System.out.println("Q11. Get Floats from Other Package:");
		System.out.println("     " + floats.getF1());
		System.out.println("     " + floats.getF2());
		floatArr[0] = floats.getF1();
		floatArr[1] = floats.getF2();

		return floatArr;
	}

	public static ArrayList<Integer> q12PrintEvens() {
		int[] oneToAhundred = new int[101];
		ArrayList<Integer> evens = new ArrayList<Integer>();

		for (int i = 0; i < 101; i++) {
			oneToAhundred[i] = i;
		}

		for (int x : oneToAhundred) {
			if (x % 2 == 0) {
				evens.add(x);
			}
		}
		System.out.println("Q12. Print Evens from 0 - 100");
		System.out.println("     " + evens);

		return evens;
	}

	public static void q13PrintTriangle() {
		int[] intArr = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
		for (int i = 0; i < intArr.length; i++) {
			System.out.println(intArr[i]);
		}
	}

	public static void q14SwitchCase() {
		int whichSwitch = (int) Math.round(Math.random() * 2);

		System.out.println("Q14. Switch Case:");
		System.out.println("     The random number generated to choose the switch case is: " + (whichSwitch + 1));

		switch (whichSwitch) {
		case 0:
			Scanner enterNum = new Scanner(System.in);
			System.out.println(
					"     You have landed on Switch Case 1. Please enter a number to calculate the square root: ");
			int num = enterNum.nextInt();

			double sqrt = Math.sqrt(num);

			System.out.println("     The square root of " + num + " is " + sqrt);
			break;
		case 1:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("     You have landed on Switch Case 2. The date and time are now:");
			System.out.println("     " + dtf.format(now));
			break;
		case 2:
			System.out.println("     You have landed on Switch Case 3. The split string is: ");
			String str = new String("I am learning Core Java");
			String[] strArr = str.split(" ");
			for (int i = 0; i < strArr.length; i++) {
				System.out.println("     " + strArr[i]);
			}
		}
	}

	public static int[] q15MathInterfaceImplementation() {
		int n1 = 12;
		int n2 = 3;
		MathImpl math = new MathImpl();
		int[] q15Answers = new int[4];
		q15Answers[0] = math.addition(n1, n2);
		q15Answers[1] = math.subtraction(n1, n2);
		q15Answers[2] = math.multiplication(n1, n2);
		q15Answers[3] = math.division(n1, n2);
		String[] names = { "Addition: ", "Subtraction: ", "Multiplication: ", "Division: " };
		System.out.println("Q15. Math Interface Implementation:");
		System.out.println("     The hard-coded values are " + n1 + " and " + n2);

		for (int i = 0; i < q15Answers.length; i++) {
			System.out.println("     " + names[i] + q15Answers[i]);
		}

		return q15Answers;
	}

	public static int q16CountChars(String str) {
		
		
		System.out.println("Q16. Count Characters of String Input:");
		System.out.println("     The input string is: " + str);
		int len = str.length();
		System.out.println("     The number of characters in this string is: " + len);
		
		return len;
	}

	public static void q17PrincipalInterestCalc() {
		System.out.println("Q17. Calculating Interest: ");
		System.out.println("     Please enter the principal balance: ");
		int principal = getInput.nextInt();

		System.out.println("     Please enter the interest rate: ");
		float rate = getInput.nextFloat();
		float ratePercent = rate / 100;

		System.out.println("     Please enter the lenght of the loan in years: ");
		int years = getInput.nextInt();

		float interest = principal * ratePercent * years;
		System.out.println("     The total interest for this loan is $" + interest + "0");

	}

	public static String[] q18AbstractStringMethods(String st) {
		Impl myStrMthds = new Impl();
		String[] strArr = new String[4];
		strArr[0] = st;
		strArr[1] = myStrMthds.anyUppercase(st);
		strArr[2] = myStrMthds.myToUppercase(st);
		strArr[3] = Integer.toString(myStrMthds.strToInt(st));

		System.out.println("Q18. Implementing Abstract String Methods: ");
		System.out.println("     Input string: " + st);
		System.out.println(
				"     Any uppercase letters in the string? " + myStrMthds.anyUppercase(st));

		System.out.println("     If there weren't before, there there are now! " + myStrMthds.myToUppercase(st));
		System.out.println("     And just for funsies, if your string was a number plus ten it would be: "
				+ myStrMthds.strToInt(st));
		
		return strArr;
	}

	public static void q19ManipulateArrayList() {
		ArrayList<Integer> oneThruTen = new ArrayList<Integer>();
		int addedEvens = 0;
		int addedOdds = 0;

		for (int i = 1; i < 11; i++) {
			oneThruTen.add(i);
		}

		System.out.println("Q19. Manipulating An Array List: ");
		System.out.println("     The original Array List: " + oneThruTen);

		for (int x : oneThruTen) {
			if (x % 2 == 0) {
				addedEvens += x;
			} else {
				addedOdds += x;
			}
		}

		System.out.println("     The sum of all even numbers in the Array List: " + addedEvens);
		System.out.println("     The sum of all odd numbers in the Array List: " + addedOdds);

		for (int x : oneThruTen) {
			if (x % 2 == 0) {
				addedEvens += x;
			} else {
				addedOdds += x;
			}
		}

		for (int i = 0; i < oneThruTen.size(); i++) {
			boolean isPrime = true;
			for (int x = 2; x < i + 1; x++) {
				if (i % x == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime || i == 5 || i == 7) {
				oneThruTen.remove(i);
			}
		}
		System.out.println("     The Array List with all prime numbers removed: " + oneThruTen);

	}

	public static String[] q20readFilePrintDetails() {
		StringBuilder builder = new StringBuilder();
		String filePath = new String(
				"C:\\Users\\AJ\\code\\revature\\aj_workspace\\CoreJavaAJ\\src\\com\\aj\\corejava\\Data.txt");
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> builder.append(s).append(":"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = builder.toString();
		String[] strArr = str.split(":");
		System.out.println("Q20. Read File and Print Formatted Content: ");
		System.out.println("     Name: " + strArr[0] + " " + strArr[1]);
		System.out.println("     Age: " + strArr[2]);
		System.out.println("     State: " + strArr[3]);
		System.out.println("     ~~~~~~~~~~~~~~~~~");
		System.out.println("     Name: " + strArr[4] + " " + strArr[5]);
		System.out.println("     Age: " + strArr[6]);
		System.out.println("     State: " + strArr[7]);
		System.out.println("     ~~~~~~~~~~~~~~~~~");
		System.out.println("     Name: " + strArr[8] + " " + strArr[9]);
		System.out.println("     Age: " + strArr[10]);
		System.out.println("     State: " + strArr[11]);
		System.out.println("     ~~~~~~~~~~~~~~~~~");
		System.out.println("     Name: " + strArr[12] + " " + strArr[13]);
		System.out.println("     Age: " + strArr[14]);
		System.out.println("     State: " + strArr[15]);

		return strArr;
	}
}
