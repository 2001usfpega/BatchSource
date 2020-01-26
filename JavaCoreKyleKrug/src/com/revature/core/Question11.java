package com.revature.core;
import com.revature.core2.*;

public class Question11 {
	
	public String question11() {
		System.out.println("Welcome to question 11!");
		//example of how to grab from a different class and package
	Question11Part2 floats = new Question11Part2();
	System.out.println("Float 1 is :" + floats.getOne() + " Float 2 is :" + floats.getTwo());
	return "Done";
	}
	

}
