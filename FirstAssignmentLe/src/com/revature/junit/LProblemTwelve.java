package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class LProblemTwelve {

	@Test
	void test() {
		Integer[] expected = {2,4,6,8,10};
		assertArrayEquals(expected, DriverClass.evenPrint(10).toArray());
	}

}
