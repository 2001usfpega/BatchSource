package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		int a[] = {1,2,3,5};
		int b[] = {3,4};
		int t[][]= {a,b};
		for(int []c:t) {
			System.out.println(Arrays.toString(c));
		}

	}

}
