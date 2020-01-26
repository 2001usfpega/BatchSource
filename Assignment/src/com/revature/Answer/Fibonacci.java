package com.revature.Answer;

import java.util.ArrayList;

public class Fibonacci {
//Q2 Escriba un programa para mostrar los primeros 25 números de Fibonacci que comienzan en 0.
	
	public ArrayList<Integer> First25Fibonacci() {
		int num=25;
		int num1=0;
		int num2=1;
		int temp;
	ArrayList<Integer> fib25=new ArrayList<>();
		//System.out.print(num1 );
	for (int i = 0; i < 25; i++) {
		temp=num1;
		num1=num2;
		num2=num2+temp;
		fib25.add(num2);
		
		
	}
			
	return fib25;	
			
			
		}
		
	}

