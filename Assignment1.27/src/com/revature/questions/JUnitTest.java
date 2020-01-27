package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest {
	
	
	
	
	@Test
	void testCalcInt() {
		double expected = 27;
		double result = Interest.calcInt(3.0, 3.0, 3.0);
		assertEquals(expected, result);
	}
	@Test
	void q1(){
		int[] expected = {1,2,3};
		int[] unsorted = {2, 1, 3};
		int[] result = QuestionsMain.q1(unsorted);
		
		assertArrayEquals(expected, result);
	};
	
	@Test
	void q2() {
		
		// if I use the line below for the expected variable
		//my test fails. Both arrays are identical
		//but what I see is that the hash or reference 
		//for the arrays are different.
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		//int[] expected = QuestionsMain.q2();
		int[] result = QuestionsMain.q2();
		assertArrayEquals(expected, result);
	}
	
	@Test
	void q3() {
		String expected = "yletulosbA";
		String result = QuestionsMain.q3("Absolutely");
		
		assertEquals(expected, result);
	}
	
	@Test
	void q4() {
		int expected = 24;
		int result = QuestionsMain.q4(4);
		assertEquals(expected, result);
	}
	
	@Test
	void q5() {
		String expected = "Absol";
		String result = QuestionsMain.q5("Absolutely", 5);
		
		assertEquals(expected, result);
	}
	@Test
	void q6() {
		boolean expected = true;
		boolean result = QuestionsMain.q6(6);
		
		assertEquals(expected, result);
	}
	
	
	

}
