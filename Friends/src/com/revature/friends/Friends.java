package com.revature.friends;

public class Friends {

	
	public static void main (String[] args) {
		System.out.println(friendMethod("Michael", "Emanuel"));;
		
	}
	
	
	public static String friendMethod(String nameOne, String nameTwo) {
		return(nameOne + " " +  nameTwo +" " + "Are Best Friends");
	}
}
