package com.revature.core;

import java.util.ArrayList;

public class Question12 {
	public String question12(){
		System.out.println("Welcome to question 12!");
		ArrayList<Integer> num = new ArrayList<Integer>();
		//establishes an arraylist of integers
		for(int i = 1; i < 101; i++) {
			//loads the array list with 1 to 100
			num.add(i);
		}
		for(int j:num) {
			if(j % 2 != 1) {
				//prints the even numbers of teh array list only
				System.out.print(j + " ");
			}
		}
		return "Done";
	}

}
