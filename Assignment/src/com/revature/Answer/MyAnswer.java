package com.revature.Answer;
import com.revature.q10.*;

import java.awt.BufferCapabilities.FlipContents;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.experimental.theories.FromDataPoints;

import com.revature.employee.sort.Employee;
import com.revature.q10.MyClassFloat;
import com.revature.q18.SubClass;

public class MyAnswer {
	static Scanner scan;

	public static void main(String[] args) throws FileNotFoundException {
		Q5Solved question5=new Q5Solved();
		Q1Solved question1=new Q1Solved();
		
		
		
	 System.out.println("Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4");
		int array[]= {1,0,5,6,3,2,3,7,9,8,4};
		Q1Solved.bubbleSort(array);
		for(int i=0;i<array.length;i++)// im going thru all the array after the bubbleSort method is called to show how the array look like
		System.out.print(array[i]);
		System.out.println();
		
		System.out.println("Q2. Write a program to display the first 25 Fibonacci numbers beginning at ");
		Fibonacci  fib=new Fibonacci();
		System.out.println(fib.First25Fibonacci());
		System.out.println();
		
		
	System.out.println("/Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or StringBuilder APIs");
		Q3Solved reser=new Q3Solved();
		String str="teresa";
		System.out.print("the reverse of "+ str+" is  " );
		reser.reverse(str);
		
		System.out.println();
		System.out.println("Q4. Write a program to compute N factorial.");

		Q4Solved question4=new Q4Solved();
		
		long num=10;
		System.out.println("The Factorial N of " + num + " is: "+ question4.factorialN(num));
		
System.out.println("Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs");
		question5.subString("teresacamara", 5);//call the method tha recieve a string and the index that we want show the subString
		
System.out.println("		Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList");		

		Q8solved question8=new Q8solved(); // create a instante of tha class 
		ArrayList<String> words=new ArrayList<>(); //new array to store the words
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		System.out.println("this is the original Array List "+ words);//printing the regular array
		
				
		System.out.println("this is a Array List with all the Palimdrome string " + question8.palindrome( words));//calling the method palindrome to shows only the palindromes words in the array
		
System.out.println("Q6. Write a program to determine if an integer is even without using the modulus operator %");
		EvenNumber q6=new EvenNumber();//instance of the class
		EvenNumber.isEven(6); // calling the isEven method who have a number like parameter and determine if is a even number
		
		System.out.println();
	//--------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("		Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console");
		ArrayList<Integer> numbers=new ArrayList<>();// create a aaray list where im going to fill with number from 1 to 100
		for (int i =0; i <=100; i++) {// a for loop going from 0 to 100 and adding it to my array list called numbers
			numbers.add(i);
			
		}
		//System.out.print(numbers);
		System.out.println();
	System.out.println("this are the primes number withing 1 to 100");
		 for (int i = 1; i < numbers.size(); i++) {    // a used a for loop to go over the array a
			  if (PrimeNumber.isPrime(numbers.get(i))) {  // on the if stament i call the isPrime method that receive a number and return true if is a prime number
				  
				  
				 System.out.print(numbers.get(i));// and print tha number
				 System.out.print(",");
			}
			
		 }
		//System.out.println( PrimeNumber.isPrime(9));
	//---------------------------------------------------------------------------------------------------------------------------------------------	
              System.out.println();
              
            // Q10. Find the minimum of two numbers using ternary operators.
              int bigger=23;//  i declare two variable to compare them
             int smaller=4;//
             
             // the ternary operator it says if my smaller variable  is  small then my bigger variable return smaller ,if not return bigger
             int theSmaler=(smaller< bigger) ? smaller :bigger;
 			//printing the result
     		System.out.println("the smaller number between "+bigger+" and "+smaller+" is "+ theSmaler);
     		
     		System.out.println();
   //11-----------------------------------------------------------------------------------------------------------------------------------------  		
     		/*Q11. Write a program that would access two float-variables from a class that exists in another
     		 * package. Note, you will need to create two packages to demonstrate the solution.	
             */
     		
     		     		    	     		
     		 
          System.out.println("The result of adding "+MyClassFloat.getNum1()+" and "+ MyClassFloat.getNum2()+" is: "+ (MyClassFloat.getNum1()+MyClassFloat.getNum2()));
	

//12----------------------------------------------------------------------------------------------------------------------------------------------
	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array.
	//Use the enhanced FOR loop for printing out the numbers.
          System.out.println("Printing even number from a array with  number from 0 to 100 ");
	
       PrintEvenQ12.arrayOfEnvenN();// calling the static arrayOfEnvenN() method from class that print the even number from a array in the class PrintEvenQ12
	  
//-------------------------------------------------------------------------------------------------------------------------------------------------
	//Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.  
       
      int[] trian={0,1,0,1};
       
       
      for (int i = 0; i <=trian.length; i++) {
   	   
   	   for (int j =0; j < i; j++) {
   		   
   		   System.out.print(trian[j]);
			
		}
		System.out.println();
	}
       
 System.out.println(); 
 //----------------------------------------------------------------------------
 //Q14 Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
 //Case 1: Find the square root of a number using the Math class method.

        SwitchCases.casesOfWitch(1,4);
        System.out.println();
//Case 2: Display today’s date.
         SwitchCases.casesOfWitch(2,4);
         System.out.println();
//Case 3: Split the following string and store it in a string array. “I am learning Core Java”
       	
         SwitchCases.casesOfWitch(3, 4);
       
/*Q15. Write a program that defines an interface having the following methods:
 *  addition, subtraction, multiplication, and division. 
 *  Create a class that implements this interface and provides appropriate functionality to carry out the required operations.
 *   Hard code two operands in a test class having a main method that calls the implementing class.*/       
        InterfaceImplement operation=new InterfaceImplement();
      scan=new Scanner(System.in);
      /* int impt1;
       int imp2;
       System.out.println("enter a number" );
       impt1=scan.nextInt();
       System.out.println("enter a other number");
       imp2=scan.nextInt();
       System.out.println("the sume of those two number is : "+ operation.addition(impt1, imp2));
       System.out.println();*/
 //Q16. Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
     
       System.out.println("enter a String ");
       String myStr=scan.nextLine();
      System.out.println("the number of character or the entered String is :" + myStr.length());
      System.out.println();
       
 //  Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user.
     // Enter principal, rate and time through the console using the Scanner class. Interest = Principal* Rate* Time
      
   /*   float principal;
      float rate;
      int time;
      System.out.println("Enter the Principal amount that you want to borrow ");
      principal=scan.nextFloat();
      System.out.println("Enter the rate");
      rate=scan.nextFloat();
      System.out.println("Enter  the number of years");
      time=scan.nextInt();
      
      float interest=principal*(rate*time);
      System.out.println("this is your interest "+ interest);
   System.out.println();
/* Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass
 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
 * 1.Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
  * 2.Convert all of the lower case characters to uppercase in the input string, and return the result.
  * 3.	Convert the input string to integer and add 10, output the result to the console.
  */
   
   SubClass letter=new SubClass();
   Scanner imput=new Scanner(System.in);
   System.out.println("Enter a  test String");
    String theString=imput.nextLine(); 
   
   System.out.println("this is the same String in all Upper Case "+letter.getAllUpper(theString));
     System.out.println();
     //----second funtion
     System.out.println("enter a string  to validate if it has a upper case ");
 String upcase=imput.nextLine();
 if(letter.checkUpper(upcase)) 
	 System.out.println("the String that you entered containe a Upper case");
   
 else
	 System.out.println("the String that you entered do not hava any Upper case");
 //---third function
 System.out.println("enter a string of number to converts them in integer");
 String newString=imput.nextLine();
 
 System.out.println(letter.stringToInt(newString));

/*Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 *  Add all the even numbers up and display the result. Add all the odd numbers up and display the result
 *  Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
*/       
       System.out.println();
       Q19Solved.displayNumbers();
       System.out.println();
  //---------------------------------------------------------------------------------------------
      
  	
       Q20Solved.fileReader();
      
      
	}
	
	}

