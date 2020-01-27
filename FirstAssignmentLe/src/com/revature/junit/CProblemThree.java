package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class CProblemThree {

	@Test
	void test() {
		String inputString = "Welcome";
		String expString = "emocleW";
		
		assertEquals(expString, DriverClass.stringReverse(inputString));
	}

}
