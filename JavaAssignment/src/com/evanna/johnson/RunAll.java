package com.evanna.johnson;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RunAll {

	public static void main(String[] arg) {

//		
////Q1. Perform a bubble sort on the following integer array:1,0,5,6,3,2,3,7,9,8,4
//	   System.out.println("====Q1====  ");
//	   System.out.println("");
//	   System.out.println("Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4 ");
//	   System.out.println(""); Question1(); System.out.println(""); 
////Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
//		 System.out.println("====Q2====  ");
//		 System.out.println("");
//		 System.out.println(" Write a program to display the first 25 Fibonacci numbers beginning at 0. ");
//		 System.out.println("");
//		 Question2(); 
//		 System.out.println("");
////Q3.Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or StringBuilder APIs System.out.println("");
//		 System.out.println("====Q3====  "); 
//		 System.out.println();
//		 System.out.println(" Reverse a string without using a temporary variable.  "); 
//		 System.out.println("Do NOT use reverse() in the StringBuffer or StringBuilder APIs.");
//		 System.out.println();
//		 Question3(); 
//		 System.out.println("");
////Q4. Write a program to compute N factorial.
//		  System.out.println("====Q4====  "); System.out.println();
//		  System.out.println(" Write a program to compute N factorial.");
//		  System.out.println(""); Question4() ; System.out.println("");
////Q5. Write a substring method that accepts a string str and an integer idx System.out.println("====Q5====  "); 
//		  System.out.println();
//		  System.out.println(" Write a substring method that accepts a string str and an integer idx"); System.out.
//		  println(" and returns the substring contained between 0 and idx-1 inclusive.");
//		  System.out.println(" Do NOT use any of the existing substring methods in the String, StringBuilder, "); 
//		  System.out.println(" or StringBuffer APIs.");
//		  System.out.println("");
//		  System.out.println("After Substring Method:  "+Question5("Evanna-Rose-Johnson",7));		  		  
//// Q6. Write a program to determine if an integer is even without using the modulus operator (%) 
//		  System.out.println("====Q6====  ");
//		  System.out.println(); System.out.
//		  println(" Write a program to determine if an integer is even without using the modulus operator (%)\r\n");
//		  System.out.println(); 
//		  Question6(); 
//		  System.out.println("");
////Q7. Sort two employees based on their name, department, and age using the Comparator interface.
//		  System.out.println("====Q7====  ");
//		  System.out.println(); System.out.
//		  println(" Write a program to determine if an integer is even without using the modulus operator (%)\r\n");
//		  System.out.println(); 
//		  Question7(); 
//		  System.out.println("");  
////Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//		  System.out.println("====Q8====  "); 
//		  System.out.println(); 
//		  System.out.println("Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList. ");
//		  System.out.println(); 
//		  Question8();
////Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
//		  Question9();
//          Question10();
//          Question11();
//          Question12();
//          Question13();
//          Question14();
//		  Question15();
//          Question16();				
//          Question17();
//          Question18();	
       //Question19();	
          Question20();	

	}

//====================================================================================================================	
//	Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4	

	public static void Question1() {
		int array[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println("Before Bubble Sort: " + Arrays.toString(array));
		boolean checked = false;
		while (checked == false) {
			checked = true;
			for (int e = 0; e < array.length - 1; e++) {
				if (array[e] > array[e + 1]) {
					int saveNum = array[e + 1];
					array[e + 1] = array[e];
					array[e] = saveNum;
					checked = false;
				}

			}
		}
		System.out.println("After Bubble Sort: " + Arrays.toString(array));
	}
//====================================================================================================================		
// Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.

	public static void Question2() {
		int e = 46368, f1 = 0, f2 = 1;
		while (f1 <= e) {
			System.out.print(f1 + ", ");
			int sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}

	}
//====================================================================================================================			
// Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or StringBuilder APIs.

	public static void Question3() {
		String evanna = "Evanna R Johnson";
		System.out.println("Before the Reverse: " + evanna);
		for (int e = 0; e < evanna.length(); e++) {
			evanna = evanna.substring(1, evanna.length() - e) + evanna.substring(0, 1)
					+ evanna.substring(evanna.length() - e, evanna.length());
		}
		System.out.println(" After the Reverse: " + evanna);

	}
//====================================================================================================================	
// Q4. Write a program to compute N factorial.	

	public static void Question4() {
		int e, fact = 1, num;

		Scanner ej = new Scanner(System.in);
		System.out.print("Enter a number: ");
		num = ej.nextInt();

		for (e = 1; e <= num; e++) {
			fact = fact * e;
		}
		System.out.println("The N factorial of " + num + " is " + fact);
	}
//====================================================================================================================	
// Q5. 	 Write a substring method that accepts a string str and an integer idx

	public static String Question5(String evanna, int johnson) {

		String rose = "";
		int e = 0;
		System.out.println("Before Substring Method: " + evanna);
		while (e <= johnson - 1) {

			rose = rose + evanna.charAt(e);
			// System.out.print(rose.charAt(e));
			e++;

		}

		return rose;
	}
//====================================================================================================================		
// Q6. Write a program to determine if an integer is even without using the modulus operator (%)

	public static void Question6() {
		int e, even = 0;

		Scanner ej = new Scanner(System.in);
		System.out.print("Enter a number: ");
		even = ej.nextInt();

		if ((even / 2) * 2 == even) {
			System.out.println("Your number " + even + " is even!");
		} else {
			System.out.println("Your number " + even + " is not even!");
		}

	}

//====================================================================================================================		
	// Q7. Sort two employees based on their name, department, and age using the
	// Comparator interface.
	public static void Question7() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee1 = new Employee("Evanna", "Music", 35);
		Employee employee2 = new Employee("Rose", "Dance", 27);
		employeeList.add(employee1);
		employeeList.add(employee2);
		System.out.println("============");
		Collections.sort(employeeList, new EmployeeComparatorName());
		for (Employee s : employeeList) {
			System.out.println(s.toString());
		}
	}
//====================================================================================================================		
// Q8.	 Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//   	“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

	public static void Question8() {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> palindrome = new ArrayList<String>();
		String e1 = "karan";
		names.add(e1);
		String e2 = "madam";
		names.add(e2);
		String e3 = "tom";
		names.add(e3);
		String e4 = "civic";
		names.add(e4);
		String e5 = "radar";
		names.add(e5);
		String e6 = "jimmy";
		names.add(e6);
		String e7 = "kayak";
		names.add(e7);
		String e8 = "john";
		names.add(e8);
		String e9 = "refer";
		names.add(e9);
		String e10 = "billy";
		names.add(e10);
		String e11 = "did";
		names.add(e11);
		System.out.println("Original Array: " + names);

		for (String name : names) {
			if (isTrue(name)) {

				palindrome.add(name);
			}
		}
		System.out.println("New Array: " + palindrome);

	}

	public static boolean isTrue(String array) {
		int e = 0, j = array.length() - 1;
		while (e < j) {
			if (array.charAt(e) != array.charAt(j))
				return false;
			e++;
			j--;
		}
		return true;
	}
//====================================================================================================================		
// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console

	public static void Question9() {
		ArrayList<Integer> AllList = new ArrayList<Integer>();
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		for(int g = 2; g<=100; g++) {
			AllList.add(g);
		}
		primeList.add(2);
		for (int e : AllList) {
			boolean holdEm = true;
			for (int j : primeList) {
				if (e % j == 0) {
					holdEm = false;
					break;
				}
			}
			if (holdEm == true) {
				primeList.add(e);
		
			}
		}
		for (int r : primeList) {
			System.out.print(r+" ");
				
		}
		
	}


	

//====================================================================================================================			

//Q10. Find the minimum of two numbers using ternary operators.
	public static void Question10() {
		int evanna = 0;
		int johnson = 0;
		Scanner ej = new Scanner(System.in);
		System.out.print("Enter first number: ");
		evanna = ej.nextInt();
		Scanner ej1 = new Scanner(System.in);
		System.out.print("Enter second nnumber: ");
		johnson = ej1.nextInt();

		int min;

		min = evanna < johnson ? evanna : johnson;
		System.out.println("The min Value between " + evanna + " and " + johnson + " is " + min);

	}
//====================================================================================================================	
//Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.	

	public static void Question11() {

		FloatStyle s = new FloatStyle();
		s.getRose();
		s.getRose1();
		System.out.println("This is the first variable: " + s.getRose());
		System.out.println("This is the second variable: " + s.getRose1());
	}

///Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	public static void Question12() {
		int[] evanna = new int[100];
		for (int e : evanna) {
			evanna[e] = evanna[e] + 1;
			if (evanna[e] % 2 == 0) {
				System.out.println((evanna[e]));
			}
		}
	}

//====================================================================================================================
	public static void Question13() {

		Scanner ej = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = ej.nextInt();
		for (int e = 1; e <= num; e++) {
			for (int j = 1; j <= e; j++) {
				System.out.print(((e + j) % 2) + " ");
			}
			System.out.println(""
					+ "");

			
		}
	}

//====================================================================================================================	
	/*
	 * Q14. Write a program that demonstrates the switch case. Implement the
	 * following functionalities in the cases:java Case 1: Find the square root of a
	 * number using the Math class method. Case 2: Display today’s date. Case 3:
	 * Split the following string and store it in a string array. “I am learning
	 * Core Java”
	 */
	public static void Question14() {
		int evanna = 0;
		Scanner ej = new Scanner(System.in);
		System.out.print("Enter a number 1-3 to begin: ");
		evanna = ej.nextInt();

		switch (evanna) {

		case 1:
			Scanner ej1 = new Scanner(System.in);
			System.out.print("Enter a random number :  ");
			int evanna1 = ej1.nextInt();
			System.out.println("The square root of " + evanna + " is " + Math.sqrt(evanna1));
			break;
		case 2:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			break;
		case 3:
			String rose = "I Am Learning - Core Java";
			String[] johnson = rose.split("-");
			System.out.println(johnson[0]);
			System.out.println(johnson[1]);
			break;
		default:
			System.out.println("Try a number 1-3! ");
		}
	}
//=====================================================================================================
public static void Question15() {
	int n1 = 0;
	int n2=0;

	Scanner ej = new Scanner(System.in);
	
	System.out.println("Enter your first number: ");
	n1 = ej.nextInt();
	
	System.out.println("Enter your second number: ");
	n2 = ej.nextInt();
	
	MathClass math = new MathClass() ;
	math.add(n1, n2);
	math.div(n1, n2);
	math.multi(n1, n2);
	math.sub(n1, n2);
}
//=====================================================================================================
	public static void Question16() {
		Scanner ej = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String word = ej.next();
		int count = 0;
		for (int e = 0; e < word.length(); e++) {
			char temp = word.charAt(e);
			if (temp != ' ')
				count++;
		}
		System.out.println("You have " + count + " characters in your string!");
	}

//====================================================================================================================	
	/*
	 * Q17. Write a program that calculates the simple interest on the principal,
	 * rate of interest and number of years provided by the user. Enter principal,
	 * rate and time through the console using the Scanner class.Interest =
	 * Principal* Rate* Time
	 */
	public static void Question17() {
		Scanner principal = new Scanner(System.in);
		System.out.println("Enter the Principal: ");
		float pri = principal.nextInt();
		Scanner rate = new Scanner(System.in);
		System.out.println("Enter the rate: ");
		float rat = rate.nextInt();
		Scanner time = new Scanner(System.in);
		System.out.println("Enter the Years: ");
		int tim = time.nextInt();
		float interest;

		interest = pri * rat * tim;
		System.out.println("Your Interest is: " + interest);
	}
//====================================================================================================================
	public static void Question18() {
		BabyClass yesSir= new BabyClass();

		String e = "Excuses Are Tools Of The Incompetent";
		String j = "57";
		
		boolean yorn= yesSir.IsUpperCase(e);
		String convert =yesSir.convertLCase(e);
		int stack =yesSir.convert2String(j); 
		
		System.out.println("Uppers Discovered? : " +  yorn);
		System.out.println("Upper to Lower :" + convert);
		System.out.println("integer to string : " +  stack);
		
	
}
	
		
		
//====================================================================================================================			
//
//		 Q19. Create an ArrayList and insert integers 1 through 10. Display the
//		 ArrayList. Add all the even numbers up and display the result. Add all the
//		  odd numbers up and display the result. Remove the prime numbers from the
//		  ArrayList and print out the remaining ArrayList.
		 
	
	public static void Question19() {
			 	ArrayList<Integer>list = new ArrayList<>(10);
					for(int e=0; e < 10; e++) {
						list.add(e+1);
					}
					System.out.println(list);
					int even = 0;
					int odd = 0;
					for(int j=0; j < list.size(); j++) {
						if(list.get(j) % 2 ==0) {
							even += list.get(j);
						}
						else if(list.get(j) % 2 !=0) {
							odd += list.get(j);
						}
					
					System.out.println("Even number sum: " + even);
					System.out.println("odd number sum: " + odd);
					
				}
	}
					
	
	
////====================================================================================================================
	
public static void Question20(){	

	try {
		
	Scanner EJ = new Scanner(new File("Data.txt"));
	
	while(EJ.hasNextLine()) {
		String evanna = EJ.nextLine();
		String []johnson = evanna.split(":");
		System.out.println("Name "+johnson[0]+" "+ johnson[1]);
		System.out.println("Age "+johnson[2]+" "+" years");
		System.out.println("State "+johnson[3]+" "+ "State");
	
	}
	
	
	}catch (FileNotFoundException a) {
	 
	}
	}	
}