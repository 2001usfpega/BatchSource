package com.revature.JunitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q3;

class TestQ3 {

	@Test
	void test() {
		Q3 test = new Q3();
		String expecteds = "edcba";
		String actuals = test.reverseString("abcde");
		
		assertEquals(expecteds, actuals);
		
	}


}
