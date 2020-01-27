package com.revature.Driver;

import java.util.ArrayList;

public class Q19 {

	public void doArrayList() {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<10; i++) {
			al.add(i+1);
		}
		
		int sumOfOdd = 0;
		int sumOfEven = 0;
	
		for (int i =0; i< al.size(); i++) {
			
			if (( al.get(i) & 0x0001 ) == 1) {
				sumOfOdd += al.get(i);
			}
		}
		System.out.println("ood sum is " + sumOfOdd );
		
		
		for (int i =0; i< al.size(); i++) {
			
			if (( al.get(i) & 0x0001 ) == 0) {
				sumOfEven += al.get(i);
			}
		}
		System.out.println("even sum is " + sumOfEven );
		
		int j =0;
		int lastIdx = al.size() -1 ;
		
		while (j <= lastIdx) {
			
			if (  isPrime(  al.get(j)    )) {
				
				al.remove(j);
				lastIdx --;
				
			} else 
				j++;
		}
		
		System.out.println("the leftovers are:");
		for (int i = 0; i< al.size() ; i++) {
			
			System.out.print(al.get(i) + " ");
			
		}
		
		
		
		
		
	}
	
	
	boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
       
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
       
        return true; 
    }
}
