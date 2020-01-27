package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q4;

class TestQ4 {

	@Test
	void test() {
		
		
		
		
		Q4 test = new Q4();
		int expecteds = 25;
		
		int actuals = test.factorial(4);
		
		assertEquals(expecteds, actuals);
		
		
		
	}

}
