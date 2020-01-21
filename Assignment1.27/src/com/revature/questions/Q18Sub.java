package com.revature.questions;

public  class Q18Sub extends Q18Abstract{

	

	@Override
	public boolean checkUpperCase(String word) {
		// TODO Auto-generated method stub
		
			char[] wordArr = word.toCharArray();
			
			for(int i =0; i<wordArr.length; i++) {
				if(!Character.isUpperCase(wordArr[i])) {
					return false;
				}
				
			}
			return true;
		
	}
	
	@Override
	public  String theUpperCase(String word) {
		return word.toUpperCase();
	}

	@Override
	public int stringToNum(String word) {
		// TODO Auto-generated method stub
		int wordNum = Integer.valueOf(word);
		
		return wordNum +10;
	}
	
	
	
}
