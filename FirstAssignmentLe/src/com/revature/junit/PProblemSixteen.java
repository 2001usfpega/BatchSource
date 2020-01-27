package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class PProblemSixteen {

	@Test
	void test() {
		String inputString = "Roll Tide!!!";
		assertEquals(8, DriverClass.charCount(inputString));
	}

}
