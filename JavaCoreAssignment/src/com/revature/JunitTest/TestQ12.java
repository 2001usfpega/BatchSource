package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q12;

class TestQ12 {

	@Test
	void test() {
		Q12 test = new Q12();
		
		int[] actuals = test.enhancedForLoop();
		
		int[] excepteds = new int[50];
		for (int i=0; i< 50; i++) {
			excepteds[i] = 2* (i+1);
		}
		
		assertArrayEquals(excepteds, actuals);
		
		
	}

}
