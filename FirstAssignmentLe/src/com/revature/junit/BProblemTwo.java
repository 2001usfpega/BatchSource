package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class BProblemTwo {

	@Test
	void test() {
		double expected[]= {0.0, 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0, 55.0, 89.0,
				144.0, 233.0, 377.0, 610.0, 987.0, 1597.0, 2584.0, 4181.0, 6765.0, 10946.0,
				17711.0, 28657.0, 46368.0};
		double res[] = DriverClass.fibonancySequence(0.0, 1.0, 25);
		assertArrayEquals(expected, res);
	}

}
