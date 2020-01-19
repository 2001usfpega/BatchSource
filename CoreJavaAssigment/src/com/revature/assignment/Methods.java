package com.revature.assignment;


public class Methods {
	
	
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
	
	
	
	public static void Q3()
	{
		String A = "Question 3";//String that is going to get reversed 
		
		char[] myCharArray = A.toCharArray(); //Converts String A to a CharArray
		
		System.out.println(); //formating
		
		for(int B = myCharArray.length-1; B>=0; B-- ) {
			
			
			System.out.print(myCharArray[B]);
			
		}
		
		
	}
	
	
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
	
	public static void Q10()
	{
		int A = 25;//Two Variables that are going to get compared
		int B = 10;
		
		int C = B < A ? B:A; //Using the Ternary operator to compare the A and B to see what is smaller and sets it to C
		
		System.out.println(C);//Print out C
		

	}
	
	
	
}
