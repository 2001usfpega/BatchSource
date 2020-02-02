package com.bank;

import java.util.List;
import java.util.Scanner;

public abstract class BankUtil {
	private static Scanner scan = new Scanner(System.in);
	
	public static Scanner getScanner() {
		return scan;
	}
	

	//return -1 if input is bad
	public static double numGreaterThanZero(String s) {
		try {
			double ret = Double.parseDouble(s);
			if (ret > 0) {
				return ret;
			}
		} catch(NumberFormatException e) {}
		return -1.0;
	}
	public static int intGreaterThanZero(String s) {
		try {
			int ret = Integer.parseInt(s);
			if (ret > 0) {
				return ret;
			}
		} catch(NumberFormatException e) {}
		return -1;
	}
	
	
	
	//print list of objects
	public static void printArrayList(List<?> list) {
		for (Object a : list) {
			System.out.println(a.toString());
		}
	}

	//print list of ojbects with index
										//dont forget the offset index
	public static void printArrayListN(List<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " " + list.get(i).toString());
		}
	}
	

}
