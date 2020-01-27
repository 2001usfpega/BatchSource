package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q10;

class TestQ10 {

	@Test
	void test() {
		Q10 test = new Q10();
		
		int int1 = 14; 
		int int2 = 18;
		int expecteds = 14;
		
		int actuals = test.ternary(int1, int2);
		
		assertEquals(expecteds, actuals);
		
		
		
		
		
	}

}
