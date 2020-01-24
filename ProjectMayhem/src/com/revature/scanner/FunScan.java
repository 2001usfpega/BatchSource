package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String [] args) {
		String contents;
		System.out.println("what would you like to print?");
		contents = scanner.nextLine();
		System.out.println(contents);
		
		System.out.println(" and, ...then?");
		String s1=scanner.nextLine();
		System.out.println(s1);
		
		System.out.println("which whole number?");
		String s2 = scanner.nextLine();
		int c2 = Integer.parseInt(s2);
		System.out.println(s2);
		
	}

}
