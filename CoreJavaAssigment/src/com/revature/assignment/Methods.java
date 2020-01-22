package com.revature.assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Methods {
	
	/*
	 * 
	 * QUESTION 1
	 * 
	 * 
	 */
	
	
	public static void Q1(int myArray[]) 
	{
		int A = myArray.length; //Assigns Array length to variable A
		
		int B = 0; //Temporary variable that hold the array element for comparison 
		
		for(int C = 0; C < A; C++)// Goes through each element of the Array 
		{
			for(int D = 1; D < (A - C); D++ )// Compares the element from the last 'for' loop to the element within this loop
			{
				if(myArray[D-1] > myArray[D])
				{
					B = myArray[D-1];
					
					myArray[D-1] = myArray[D];
					
					myArray[D] = B;
					
					/*
					 * this if statement Swaps the elements based on 
					 * the comparison form the 2 for loops
					 * 
					 */
					
					
				}	
				
			
			}	
		}
			
	}
	
	/*
	 * 
	 * QUESTION 2
	 * 
	 * 
	 */
	
	
	
	
	public static void Q2()
	{
		System.out.println();//Formatting 
		int A = 0;// Starting values for the Fibonacci Sequence 
		
		int B = 1;
		
		
		for(int C=0; C<=25; C++)
		{
		
			System.out.print(A + "   ");
		
			int D = A + B;
			
				A = B;
		
				B = D;
				
				/*This for loop iterates C until it surpasses 25 to build 
				 * the full fibonacci sequence 
				 * 
				 * 
				 */
			
		
		}
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 3
	 * 
	 * 
	 */
	
	
	
	public static void Q3()
	{
		String A = "Question 3";//String that is going to get reversed 
		
		char[] myCharArray = A.toCharArray(); //Converts String A to a CharArray
		
		System.out.println(); //formating
		
		for(int B = myCharArray.length-1; B>=0; B-- ) {
			
			
			System.out.print(myCharArray[B]);
			
		}
		
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 4
	 * 
	 * 
	 */
	
	
	public static void Q4()
	{
		
		int A = 1;
		
		int B = 10; //Number im getting the factorial of 
		
		for(int C=1; C<=B; C++)
		{
			/* This loop iterates C until it is greater then or equal to B
			 * and then sets A equal to the result of A*C
			 * 
			 */
			A=A*C;
			
		}
		
		System.out.println();//Formatting 
		System.out.println(A);//Prints out A after the for loop has already run in this case 10 times 
		
		
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 5
	 * 
	 */
	
	public static String Q5(String A, int B)
	{
		
		String myString="";//Creates a empty string 
		
		for(int C=0; C<B; C++)
		{
			myString=myString + A.charAt(C);  
			
			/*This for loops keeps retrieving letters from the 
			 * string in the method until it reaches the indicated amount 
			 * which in this case is 5
			 * 
			 * 
			 */
			
		}
		
		return myString;
		
		
		
		
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 6
	 * 
	 */
	
	public static void Q6(int A)
	{
		
		if(A/2*2 == A)
		{
			System.out.println("Even");
			
		}
		else {
			
			System.out.println("Odd");
			
			
		}
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 7
	 * 
	 * 
	 */
	
	//QUESTION7 CLASS
	
	/*
	 * 
	 * 
	 * QUESTION 8
	 * 
	 * 
	 */
	
	public static boolean Q8(String B)
	{
		String empty = "";
		for(int C=B.length()-1; C>=0; C--)
		{
			empty = empty + B.charAt(C);
			
		}
		
		return B.equals(empty);
		

		
	}
	
	/*
	 * 
	 * QUESTION 9
	 * 
	 * 
	 */

	
	public static void Q9()
	{
		int i = 0;
		int num = 0;
		
		String primeNumbers = "";
				
		
		for(i = 1; i <= 100; i++)
		{
			int counter=0;
			
			
			for(num = i; num >= 1; num--)
			{
				if(i % num == 0)
				{
					counter = counter + 1;
					
					
				}
			if (counter ==2)
			{
				
				primeNumbers = primeNumbers + i + " ";
			}
			
				
			}
			
		}
		
		System.out.println(primeNumbers);
		
	
		
		
	}
	
	/*
	 * 
	 * QUESTION 10
	 * 
	 * 
	 */
	
	public static void Q10()
	{
		int A = 25;//Two Variables that are going to get compared
		int B = 10;
		
		int C = B < A ? B:A; //Using the Ternary operator to compare the A and B to see what is smaller and sets it to C
		
		System.out.println(C);//Print out C
		

	}
	
	
	/*
	 * 
	 * 
	 * QUESTION 12
	 * 
	 * 
	 */
	public static void Q12()
	{
		ArrayList<Integer> evenArray = new ArrayList<Integer>();
		
		for(int a=1; a<=100; a++)
		{
			evenArray.add(a);
			
		}
		
		for(int b:evenArray)
		{
			if(b%2==0)
			{
				System.out.print(b + ",");
				
			}
			
			
		}
		
		
	}
	
	/*
	 * 
	 * QUESTION 13
	 * 
	 * 
	 */
	
	public static int Q13(int A)
	{
		if(A == 0) {
			
			return 1;
		}
		
		else {
			
			return 0;
			
		}
		
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 14
	 * 
	 * 
	 */
	
	public static void Q14(int A)
	{

		Date date = new Date(); 
		
		String learning = "I am learning Core Java";
		
		String[] core = new String[10];
		
		switch(A) {
		
		case 1: System.out.println(Math.sqrt(25)); break;
		
		case 2: System.out.println(date); break;
		
		case 3: 
				core = learning.split(" ");
				for (String b : core){
					System.out.println(b);
					
				}
		}	
				
		}
		
		
	/*
	 * 
	 * QUESTION 15
	 * 
	 * 	
	 */
		
		//QUESTION15 CLASS
		
	/*
	 * 
	 * 
	 * QUESTION 16
	 * 
	 */
		
		//IN THE DRIVER CLASS
	
	/*
	 * 
	 * QUESTION 17
	 * 
	 */
		
	
	
	public static void Q17()
	{
		Scanner PrincipleScan = new Scanner(System.in);
		System.out.println("Principle:");
		int principle = PrincipleScan.nextInt();
		System.out.println("Time:");
		int time = PrincipleScan.nextInt();
		System.out.println("Rate:");
		int rate = PrincipleScan.nextInt();
		int interest = (principle*rate*time);
		System.out.println("Interest Rate: " + interest);
		
		
		
	}
	
	/*
	 * 
	 * 
	 * QUESTION 18
	 * 
	 */
	
	/*
	 * 
	 * QUESTION 19
	 * 
	 * 
	 */
	
	
	/*
	 * 
	 * 
	 * QUESTION 20
	 * 
	 */
	


	
	
	
}
