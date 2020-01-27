package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class HProblemEight {

	@Test
	void test() {
		String inputString[] = {"test","abcba","Winniw","wow"};
		ArrayList<String> actual = DriverClass.palindArr(inputString);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("abcba");
		expected.add("Winniw");
		expected.add("wow");
		assertLinesMatch(expected, actual);
	}

}
