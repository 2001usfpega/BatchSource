package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {

	@BeforeAll
	static void beforeAllem() {
		System.out.println("b4all");
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("we just ran: "+info.getDisplayName());
	}
	
	
	@DisplayName("Length Check")
	@Test
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		//assertEquals(expected,actual);
		assertEquals(expectedLength,actualLength);
	}

}
