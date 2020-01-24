package com.aj.corejava;

import java.util.ArrayList;

public class Impl extends AbstractClass {

	@Override
	public String anyUppercase(String str) {
		boolean isUpper = false;
		String yes = "YES";
		String no = "NO";
		ArrayList<Character> arrOfStr = new ArrayList<Character>();
		for (int c = 0; c < str.length(); c++) {
			Character temp = new Character(str.charAt(c));
			arrOfStr.add(temp);
		}
		for (char i : arrOfStr) {
			if (Character.isUpperCase(i)) {
				isUpper = true;
			}
		}
		if (isUpper) {
			return yes;
		}
		return no;
	}

	@Override
	public String myToUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public int strToInt(String str) {
		int total = 10;
		char[] charArr = str.toCharArray();

		for (char c : charArr) {
			int a = c;
			total += a;
		}
		return total;
	}

}
