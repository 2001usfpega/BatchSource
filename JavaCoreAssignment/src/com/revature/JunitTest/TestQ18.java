package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q18child;

class TestQ18 {

	@Test
	void test() {
		Q18child test = new Q18child();
		
		boolean actuals = test.isUppercase("I AM BIG GUY");
		
		assertEquals( true , actuals);
		
		actuals = test.isUppercase("i am little baby");
		
		assertEquals( false , actuals);
		
		
		
		String expecteds = "i am little baby";
		
		assertEquals(expecteds, test.toLowerCase("I AM LITTLE BABY"));
		
		
		
		int expectedsInt = 40;
		
		assertEquals(expectedsInt, test.add10("30"));
		
		
		
		
		
		
		
	}

}
