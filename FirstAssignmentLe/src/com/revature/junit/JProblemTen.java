package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class JProblemTen {

	@Test
	void test() {
		assertEquals(5.0, DriverClass.ternaryOp(5.0, 5.1));
	}

}
