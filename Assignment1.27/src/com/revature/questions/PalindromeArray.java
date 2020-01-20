package com.revature.questions;

import java.util.ArrayList;

public class PalindromeArray {

	// Lets print the names in the arraylist
	
	

	public  void printNames(ArrayList names) {
		
	for(int i =0; i<names.size(); i++){
	
	System.out.print(names.get(i) + ", ");
	String curName = (String) names.get(i);
	
	checkPal(curName);
	
	}
	System.out.println();
	System.out.println("This is the array of palindromes");
	
	for (int l =0; l<palArray.size(); l++) {
		System.out.print(palArray.get(l) + ", ");
	}
	}
	
	 public static ArrayList<String> palArray = new ArrayList<>();
	
	
	public static void checkPal(String name) {
		 
		char[] letterArray =name.toCharArray();
		
		int beg = 0;
		int end = letterArray.length-1;
		
		while(beg<end && letterArray[beg]==letterArray[end]) {
			beg++;
			end--;
		}
		
		if(beg==end || beg>end) {
			
			
			palArray.add(name);
		}
		
//		for(int l =0; l<palArray.size(); l++) {
//			System.out.print(palArray.get(l) + ", ");
//		}
	}

}
