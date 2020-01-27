package com.revature.Driver;

public class Q2 {

	public int[] fibonacci(int x) {
		int[] fiboAry = new int[x];
		
		if  (x< 1) {
			System.out.println("no, I cant do less than 1");
			
		} else if (x == 1) {
			System.out.println(0);
			
		} else if (x == 2) {
			System.out.println(1);
		} else {
			
			fiboAry[0] = 0;
			fiboAry[1] = 1;
			
			for (int i = 2; i < x ; i++ ) {
				fiboAry[i] = fiboAry[i-1] + fiboAry[i-2];
			}
		}
		return fiboAry;
	}
}
