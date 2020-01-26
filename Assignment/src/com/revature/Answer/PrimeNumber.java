package com.revature.Answer;

import java.util.ArrayList;

public  class PrimeNumber {
	
	
	

	public static boolean isPrime(int num) {
		boolean isprime=true;//initialize a boolean variable to define when the number is a prime number
		int cont=2; // a cont in 2 because i will be dividing tha cont by the number to see if the reste is cero
		 
			 while ((isprime )&& (cont<num)) {//so while my boolean variable is true and the number entered is bigger than cont
				 
			if (num % cont==0) // if the division between the number and the cont is zero that means is not a prime number
				isprime=false;
				cont++;// im ingrementing the cont to keep asking until all tree cont
			
			//else isprime= true;
		} 
			
								
		return isprime;
		
	}
	
	
}