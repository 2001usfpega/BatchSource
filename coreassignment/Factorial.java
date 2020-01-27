package com.revature.coreassignment;

public class Factorial {
	public static void main(String[] args) {
        int num = 7;
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}

/*
 * referenced from https://www.programiz.com/java-programming/examples/factorial
 * the loop cycles through numbers between 
 * 1 and 7 and finds the product
 */

