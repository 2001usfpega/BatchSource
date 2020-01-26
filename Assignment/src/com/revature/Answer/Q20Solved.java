package com.revature.Answer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20Solved {
	
	public static void fileReader( ) throws FileNotFoundException {
		
		String contain;// is to save the first line of the file into a string
		try {
			FileReader read=new FileReader("C:/Users/tscam/Desktop/Data.txt");// read the file
			BufferedReader mybuffer=new BufferedReader(read);//save the file contain in a temporal BufferedReader memory
			while ((contain= mybuffer.readLine())!=null) { // a while loop to rread each line that is save in contain string variable
				String[] separator=contain.split(":");     // separate tha first line by : and seve it in a array
				System.out.println("Name: "+separator[0]+" "+separator[1]); // and print tha array in different index in the ordar tha we want to see it
				System.out.println("Age: "+separator[2]);
				System.out.println("State : "+separator[3]);
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
