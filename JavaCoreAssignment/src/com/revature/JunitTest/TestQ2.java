package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q2;

class TestQ2 {

	@Test
	void test() {
		Q2 test = new Q2();
		int[] expecteds = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		
		int[] actuals = test.fibonacci(25);
		
		assertArrayEquals(expecteds, actuals);
	}

}
