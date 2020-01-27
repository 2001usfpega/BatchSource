package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("What would you like to print");
		String contents = sc.next();
		System.out.println(contents);
		
		System.out.println("And then?");
		String s1 = sc.nextLine();
		System.out.println(s1);
	}
}
