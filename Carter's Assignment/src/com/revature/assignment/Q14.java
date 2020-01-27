//reference https://www.tutorialspoint.com/get-square-root-of-a-number-using-math-sqrt-in-java
//reference https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
//reference https://www.guru99.com/how-to-split-a-string-in-java.html
package com.revature.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q14 
{
	Scanner c = new Scanner(System.in);
	
	 class GetCurrentDateTime {

	    public final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		}
	
	public static void main(String[] args) 
	{
		
		
		int java = 0;
		
		switch(java) 
		{
		case(1):
			double x = 25;
			double y = 81;
			//runs the square roots
			System.out.println("The square root of " + x +" is " + Math.sqrt(x));
			System.out.println("The square root of " + y +" is " + Math.sqrt(y));
		break;
		
		case(2):
			//displays the current date
			Date date = new Date();
			System.out.println(sdf.format(date));
		break;
		
		case(3):
			//runs the spilt Array
			String javaMain = "I, Am, Learning, Core, Java";
			String[] arrSplit = javaMain.split(" ");
			for(int i = 0; i < arrSplit.length; i++) 
			{
				System.out.println(arrSplit[i]);
			}
		break;
		default:
		break;
		
		}

	}

}
