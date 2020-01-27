package com.revature.Driver;

public class Q5 {

	public String substring(String str, int idx) {
		String ans = "";
		

		if (idx > str.length()-1  ||   idx < 0 ) {
			
			System.out.println(" idx out bound ");
			
		} else {
			
			for (int i=0; i <= idx -1 ; i++ ) {
				
				ans += str.charAt(i);

			}
		}
		return ans;
	}
}
