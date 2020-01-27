package com.revature.Driver;

public class Q18child extends Q18parent{
	
	public boolean isUppercase(String big) {
		for (int i= 0; i< big.length(); i++) {
			
			char c = big.charAt(i);
			
			if ( !Character.isUpperCase(c) && c!=' ' ) {
				
				return false;
			}
		}
		return true;
	}
	
	public String toLowerCase(String big) {
		StringBuilder sb = new StringBuilder();
		
		for (int i =0; i< big.length(); i++) {
			char c = big.charAt(i);
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}
	
	public int add10(String numStr) {
		return Integer.valueOf(numStr) + 10;
	}
	
	
	
	

}
