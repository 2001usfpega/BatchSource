package com.revature.coreassignment;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main (String [] args) {
	
		int k;
		int num = 0;
		int maxCheck = 100;
		boolean isPrime = true;
		
		String primeFound = "";
		
		for(k=1;k<=maxCheck;k++) {
			isPrime = CheckPrime(k);
			if(isPrime) {
				primeFound=primeFound+k+" ";
				
			}
		}
		System.out.println("Prime nums between 1 and "+ maxCheck + " here they be:");
		System.out.println(primeFound);
		
	}
	
	public static boolean CheckPrime(int numToCheck) {
		int remains;
		for (int i = 2; i <= numToCheck / 2; i++) {
            remains = numToCheck % i;
            if(remains==0) {
            	return false;
            }
			
		}
		return true;
	}
}
//reference https://www.guru99.com/prime-number-program-java.html
/*the multiple for loops check if int k is less than 100(maxCheck) and looks
 * to see if the numbers are prime.
 * The next for loop finds numbers that are even
 * none of those equal 0 so they will not be printed
 * this allows for only prime numbers to be chosen.
 * the numCheck/2 looks to see if the numbers are or aren't prime
*/