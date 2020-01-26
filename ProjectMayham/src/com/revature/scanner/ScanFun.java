package com.revature.scanner;

import java.util.Scanner;

public class ScanFun {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("what you want");
		
		String contents = sc.nextLine();
		System.out.println(contents);
		
		
		System.out.println(" and ");
		System.out.println(sc.nextLine());
		
		
		int c2 = Integer.parseInt(sc.nextLine());
		
		System.out.println(c2);
		
		sc.close();
	}
}
