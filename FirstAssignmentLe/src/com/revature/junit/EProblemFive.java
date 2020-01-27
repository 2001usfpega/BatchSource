package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class EProblemFive {

	@Test
	void test() {
		String inputString = "Goodbye Earth";
		String expString = "Goodb";
		assertEquals(expString, DriverClass.subString(inputString, 5).toString());
	}

}
