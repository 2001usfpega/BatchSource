package com.revature.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {

	public String question20() {
		System.out.println("Welcome to question 20!");
		String filename = "Data.txt";// file location
		
			
			try {
				BufferedReader in = new BufferedReader(new FileReader(filename));
				String line;
				try {
					line = in.readLine();
					while(line != null) {// will read from file as long as the line is not null
						String [] columns = line.split(":");//splits the string that is read from the file
						String firstname = columns[0];
						String lastname = columns[1];
						String age = columns[2];
						String state = columns[3];
						
						//Prints out the new variables from reading from teh file
						System.out.println("Name: " + firstname + " " + lastname);
						System.out.println("Age: "+ age);
						System.out.println("State: " +state);
						line = in.readLine();// moves the buffer to the next line
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Done";
				

	}
}
