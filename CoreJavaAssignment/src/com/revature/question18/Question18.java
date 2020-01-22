package com.revature.question18;

public class Question18 extends Question18Abstract {

	@Override
	public boolean checkUppercase(String str) {
		char[] input = str.toCharArray();
		boolean out = false;
		for(char c : input) {
			if(!out){
				out = Character.isUpperCase(c);
			} else {
				break;
			}
		}
		return out;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void toInt(String str) {
		int output = 10;
		char[] input = str.toCharArray();
		for(char c : input) {
			output = output + c;
		}
		System.out.println(output + "\n");
	}

}
