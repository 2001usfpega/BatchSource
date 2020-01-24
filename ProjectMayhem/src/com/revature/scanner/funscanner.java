package com.revature.scanner;

import java.util.Scanner;

public class funscanner {
  public static Scanner sc=new Scanner(System.in);
  
  
	
	public static void main(String [] arg) {
		String contents;
		System.out.println("wat would you like to print? ");
		contents=sc.nextLine();//is for read the next input with space
		System.out.println(contents);
		System.out.println("and then");
		String s1=sc.nextLine();
		System.out.println(s1);
		System.out.println("wat whole number");
		//int num=sc.nextInt();
		int num2=Integer.parseInt(sc.nextLine());
		System.out.println(num2);
	
	
	}
	}
