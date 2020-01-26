package com.revature.Answer;

import java.util.ArrayList;

public class Q8solved {
	
	public ArrayList<String> palindrome(ArrayList<String> pal) {
		  
		
		ArrayList<String> thisPalin=new ArrayList<>();
		
		
		for (int i = 0; i <= pal.size()-1; i++) {
			char[] array=pal.get(i).toCharArray();// estoy guardando el primer string del arreglo en un arreglo de charactrer
			int first=0;
			int last=array.length-1;
			
			while((first<last)&&(array[first]==array[last])) {
				first++;
				last--;
															
			}
			if(last==first) {
				
				thisPalin.add(pal.get(i));
			}
			
		}
	
		return thisPalin;
		
		
	}


}
