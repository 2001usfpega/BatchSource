package com.revature.Driver;

public class Q13 {

	public void triangle() {
		
		String str = "1 0 1 0 1 0 1 0 1 0";
		String[] stSplited = str.split(" ");
		

		int index = stSplited.length-1;
		
		for (int i=0; i<4; i++) {
			for (int j=0; j< i+1; j++) {
				System.out.print(stSplited[index--] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
}
