package com.revature.Driver;

public class Q6 {

	public String evenOrNot(int n) {
		return ((  n & 0x01 ) == 1) ? "odd" : "even";
	}
}
