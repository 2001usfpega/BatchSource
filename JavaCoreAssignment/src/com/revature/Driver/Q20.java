package com.revature.Driver;


public class Q20 {
	


	public void workingAt20(String content) {
		
		String[] str = content.split(":");


		int i = 0;
		for (int j = 0;  j < (str.length / 4 ); j++) {
			
			System.out.println("Name:" + str[i++] + " " + str[i++]);
			System.out.println("Age:" + str[i++] + " years");
			System.out.println("State:" + str[i++] + " State" + "\n");

		}
		

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
