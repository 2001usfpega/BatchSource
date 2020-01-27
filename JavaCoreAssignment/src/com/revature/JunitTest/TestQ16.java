package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q16;

class TestQ16 {

	@Test
	void test() {
		Q16 test = new Q16();
		
		String commandLine = "a5555 b66666 c777777 d33 e8888888";
		String [] input = commandLine.split(" ");
		

		int actuals = test.numOfCharacters(input);

		// 5 + 6 + 7 + 3 + 8 = 29;
		int expecteds = 29;
		
		assertEquals(expecteds, actuals);
		
		
		
		
	}

}
