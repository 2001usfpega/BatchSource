package com.revature.questions;

public class StringNum {
	
	
	
public static void stringArg(String[] args) {
	String words="";
	for(int i=0;i<args.length;i++)  {
		if(i ==args.length-1 ) {
			words += args[i];
			break;
		}
		words +=args[i] + " ";
	}
	System.out.println(words);
	words.toCharArray();
	System.out.println(words.length());
		 
}
}
