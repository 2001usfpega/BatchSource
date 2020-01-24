package com.revature;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
>>>>>>> origin/KnightenJ

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

<<<<<<< HEAD

class StringTest {
	
	@BeforeAll
	static void beforeAllofEm() {
		System.out.println("Before All");
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("we just ran" + info.getDisplayName());
=======
class StringTest {
	@BeforeAll
	static void beforeALllofem() {
		System.out.println("Before ALL");
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("We just ran: "+ info.getDisplayName());
>>>>>>> origin/KnightenJ
	}
	@DisplayName("Length Check")
	@Test
	void meh() {
		int actualLength = "ABCD".length();
<<<<<<< HEAD
		int expectedLength =  + 4;
		//assertedEquals( expected value, actual value)
		assertEquals(expectedLength, actualLength);
		
	}

=======
		int expectedLength = 4;
		//assertEquals( expected, actual value);
		assertEquals(expectedLength,actualLength);
	}
	
>>>>>>> origin/KnightenJ
}
