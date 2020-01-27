package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class DProblemFour {

	@Test
	void test() {
		int result = 120;
		assertEquals(120, DriverClass.nFactorial(5));
	}

}
