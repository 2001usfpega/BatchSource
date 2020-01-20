package com.revature.questions;

public class NumArray {

	static int[] nums = new int[100];
	
	public static void addNumsToArray() {
		for(int i =1; i<101; i++) {
			nums[i-1] = i;
		}
		
		
	}
	
	public static void checkEvens(int[] nums) {
		for(int x:nums) {
			if(x%2==0) {
				System.out.print(x +", ");
			}
		}
	}
	
}
