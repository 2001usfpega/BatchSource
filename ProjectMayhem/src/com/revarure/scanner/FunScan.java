package com.revarure.scanner;

import java.util.Scanner;

public class FunScan {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content;
		System.out.println("what would you like to print?");
		//Cut off at space if using next()
		content = sc.next();
		//using nextLine() for whole scan
		//content = sc.nextLine();
		System.out.println(content);
		
		System.out.println(" and then?");
		String s1 =sc.next();
		System.out.println(s1);
		
		System.out.println("What whole number?");
		String s2 = sc.next();
		int c2 = Integer.parseInt(s2);
		System.out.println(c2);
	}
	
	

}
