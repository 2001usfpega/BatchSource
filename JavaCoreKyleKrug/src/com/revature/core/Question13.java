package com.revature.core;

public class Question13 {
	public String question13(){
		System.out.println("Welcome to question 13!");
		String str ="0";
		String one = "1";
		String zero = "0";
		
		for(int i = 0; i < 4;i++ ) {
			int length = str.length()-1;
			System.out.println(str);
		if(str.charAt(length) == '0') {
			if(i % 2 == 0) {
				str =one + str;
			}else {
				str = str + one;
			}
		}else {
			if(i % 2 == 0) {
				str =zero+ str;
			}else {
				str = str + zero;
			}
		}
	}
		return "Done";
}

}
