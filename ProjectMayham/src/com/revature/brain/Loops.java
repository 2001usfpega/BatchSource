package com.revature.brain;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [] x = {3,4,5};
		int k =0;
		int w =0;
		System.out.println("Enter 1");
		int input_u = input.nextInt();
		switch(input_u) {
		case 1:
			System.out.println("This is a case");
			if(input_u == 1) {
				System.out.println("this is an if statement");
				for(int i = 0; i < 3; i++) {
					System.out.println("this is a for loop " +i);
					for( int j : x) {
						System.out.println("this is a for each loop "+j);
						while(k < 2) {
							System.out.println("No");
							k++;
							do {
								System.out.println("do while"+w);
							w++;
							}while (w < 2);
							
						}
					}
				}
			}
			break;
		default:
			break;
		}

	}

}
