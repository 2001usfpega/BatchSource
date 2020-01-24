package com.revature.corejavaassignment;

public class ConcreteSubClassQuestion18 extends Question18SuperClass {
	
	ConcreteSubClassQuestion18(){
		
	}
		
	@Override
	public boolean checkForUpperCase(String s) {
			for(int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				System.out.println("True: There is an upper case character in this line");
				return true;
			}
		}
			System.out.println("False:  There is not an upper case character in this line");
			return false;
	}

	@Override
	public String convertLowerToUpper(String s) {
		s = s.toUpperCase();
		return s;
	}

	@Override
	public int convertWordsToValue(String s) {
		int i = s.length();
		return i += 10;
	}
	
	public int convertStringToInteger(String s) {
		int i = Integer.parseInt(s);
		return i += 10;
	}

}
