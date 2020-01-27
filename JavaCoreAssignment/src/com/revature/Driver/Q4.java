package com.revature.Driver;


public class Q4 {
	
	
	public int factorial( int f) {
		
		int ans = 1;

		if ( f < 0 ) {
			System.out.println("not a volid number");
			
		} else if (f == 0){
			System.out.println(1);
			
		} else if (f == 1) {
			System.out.println(1);
			
		} else {
			for (int i = 1; i <= f ; i++) {
				ans *= i;
			}
		}
		return ans;
	}
}
