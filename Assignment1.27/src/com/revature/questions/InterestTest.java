package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InterestTest {

	@Test
	void testCalcInt() {
		double expected = 27;
		double result = Interest.calcInt(3.0, 3.0, 3.0);
		assertEquals(expected, result);
	}

}
