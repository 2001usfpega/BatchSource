package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	static void beforeAllOfEm() {
		System.out.println("Before All");
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("We just ran: "+info.getDisplayName());
	}
	@DisplayName("Check Length of String")
	@Test
	void testMeh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals(expected value, actual value);
		assertEquals(expectedLength, actualLength);
	}

}
