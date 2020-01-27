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
		System.out.println("We just ran a: " + info.getDisplayName());
	}
	@DisplayName("Length Check")
	@Test
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		assertEquals(actualLength, expectedLength);
		
		
	}

}
