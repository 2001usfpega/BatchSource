package com.revature.scan;

import java.util.Scanner;

public class ScanTheMan {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		System.out.println("and?");
		String s = sc.nextLine();
		System.out.println(s);
		System.out.println("Enter integer.");
		String s2 = sc.nextLine();
		int x=Integer.parseInt(s2);
		System.out.println(x);
	}

}
