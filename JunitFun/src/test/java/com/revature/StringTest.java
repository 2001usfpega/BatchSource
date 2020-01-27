package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest 
{
	
	@BeforeAll
	static void beforeAllofEm() 
	{
		System.out.println("Before All");
	}
	
	@AfterEach
	void afterEach(TestInfo info) 
	{
		System.out.println("We just ran: " + info.getDisplayName());
	}

	@DisplayName ("Length Chack")
	@Test
	void meh() 
	{
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals (expected, actual values)
		assertEquals(expectedLength,actualLength);
	}

}
