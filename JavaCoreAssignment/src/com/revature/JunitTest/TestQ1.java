package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q1;

class TestQ1 {

	@Test
	void test() {
		Q1 test = new Q1();
		
		int[] expecteds = {1,2,3,4,5,6,7,7,8};
		int[] actuals = test.bubbleSort(8,7,7,6,5,4,3,2,1);
		
		

		assertArrayEquals(expecteds, actuals);
	}
	


}
