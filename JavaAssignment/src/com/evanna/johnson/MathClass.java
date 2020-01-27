package com.evanna.johnson;

import java.util.Scanner;

public class MathClass implements MathClass1{

	
@Override
public void add(int e, int v) {
	int sum;
	sum = e + v;
	System.out.println("Additon: " + sum);
	
}

@Override
public void sub(int a, int n) {
	int sum2;
	sum2 = a - n;
	System.out.println("Subtraction: " + sum2);
	
}

@Override
public void multi(int n2, int a2) {
	int sum3;
	sum3 = n2 * a2;
	System.out.println("Multiply: " + sum3);
	
}

@Override
public void div(int r, int j) {
	int sum4;
	sum4 = r/j;
	System.out.println("Divide: " + sum4);
}

}
