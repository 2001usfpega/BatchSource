package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class FProblemSix {

	@Test
	void test() {
		assertEquals(true, DriverClass.evenNumber(2));
	}

}
