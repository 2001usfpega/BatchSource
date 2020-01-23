package com.revature.coreassignment;

public class Fibonacci {

//	Example from https://www.javatpoint.com/fibonacci-series-in-java 
//	static int n1=0,n2=1,n3=0;    
//	 static void printFibonacci(int count){    
//	    if(count>0){    
//	         n3 = n1 + n2;    
//	         n1 = n2;    
//	         n2 = n3;    
//	         System.out.print(" "+n3);   
//	         printFibonacci(count-1);    
//	     }    
//	 }    
//	 public static void main(String args[]){    
//	  int count=25;    
//	  System.out.print(n1+" "+n2);//printing 0 and 1    
//	  printFibonacci(count-2);//n-2 because 2 numbers are already printed   
//	 } 
	
	
// Used while loop instead of for loop from reference. NewBoston on youtube showed how 
//	to do a whille loop. Used that knowledge plus Fibonacci formula.
	public static void main (String [] args) {
	 int f1=0, f2=1, counter=25;
		System.out.print(" First " + counter + "numbers");
		int fib = 1;
		
		while(fib<=counter) {
			System.out.print(f1+" ");
			int lastTwo= f1 + f2;
			f1 = f2;
			f2 = lastTwo;
			fib++;
		}
				
		
}
}


	