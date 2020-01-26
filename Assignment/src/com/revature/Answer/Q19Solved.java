package com.revature.Answer;

import java.awt.List;
import java.util.ArrayList;

public class Q19Solved {
	
	/*Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
	 *  Add all the even numbers up and display the result. Add all the odd numbers up and display the result
	 *  Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	*/       
	    
	
	
	
	
	public static  void displayNumbers() {
		ArrayList<Integer> numList=new ArrayList<>();
		int addEven=0;
		int addOdd=0;
		ArrayList<Integer> prime=new ArrayList<>();
		ArrayList<Integer> even=new ArrayList<>();
		for (int i = 0; i <=10; i++) {
			numList.add(i);
			
		}
		System.out.println(numList);
		
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i)%2==0) {
				
				addEven+=numList.get(i).intValue();
			
			}
			else {
							
				addOdd+=numList.get(i);
			}
				
		}
		for (int j = 0; j < numList.size(); j++) {
			
		
			if(	PrimeNumber.isPrime(numList.get(j))==true) {
					
					prime.add(numList.get(j));
					numList.remove(j);
					
				}
			
			}							
		
	
		System.out.println("the sum of all the even number in the array is "+addEven);
		System.out.println("the sum of the odd number in the array is      "+ addOdd);
		System.out.println("The remaing Array  is "+ numList);
		System.out.println("list of the prime number "+ prime);
		//return list;
		
	}
	 
}
	
	
	


