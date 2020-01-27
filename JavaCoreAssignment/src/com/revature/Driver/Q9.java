package com.revature.Driver;

import java.util.ArrayList;
import java.util.ListIterator;

public class Q9 {
	
	ArrayList<Integer> ansList = new ArrayList<Integer>();
	
	public ArrayList<Integer> prime(ArrayList<Integer> al) {
		

		ListIterator<Integer> it = al.listIterator();
		
		
		while (it.hasNext()) {
			int temp = it.next();
			if (isPrime(temp))
				ansList.add(temp);
		}
		return ansList;
		
	}
	
	
	
	
	
	static boolean isPrime(int n) 
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
