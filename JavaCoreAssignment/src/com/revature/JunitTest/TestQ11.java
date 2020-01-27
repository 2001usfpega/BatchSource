package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q11;

class TestQ11 {

	@Test
	void test() {
		Q11 test = new Q11();
		
		
		float [] expecteds = {2.3f, 2.4f};
		
		float [] actuals = test.readFloat();
		
		assertArrayEquals(expecteds, actuals);
		
	}

}
