package com.revature.absolute;

import java.io.Serializable;
import java.util.Scanner;

import com.revature.customer.Account;
public class Collection implements Serializable{
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number ");
		Account act = new Account();
		act.Menu();
		//int c = input.nextInt();
		System.out.println("value = " + input);
		char c = input.next().charAt(0);
		System.out.println("Value = " +input);

	}

}
