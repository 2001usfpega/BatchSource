package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void testBubbleSort() {
		int [] bub = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int [] expected = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		int [] result = BubbleSort.bubbleSort(bub);
		assertArrayEquals(expected, result);
	}
	
	@Test
	void testFib() {
		int [] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		int result [] = Fibo.fiboMethod();
		assertArrayEquals (expected, result);
	}
	
	@Test 
	void testFactorial() {
		int n = 12;
		int expected = 479001600;
		int result = Factorial.factorial(n);
		assertEquals(expected, result);
		
	}
	
	@Test
	void testReverseString() {
		String d = "testchararray";
		char [] expected = {'y', 'a', 'r', 'r', 'a', 'r', 'a','h', 'c', 't', 's', 'e', 't'};
		char[] result = ReverseString.reverseStringMethod(d);
		assertArrayEquals(expected, result);
	}
	
	@Test
	void testSubString() {
		String s = "How now, Brown Cow!";
		int n = 7;
		char [] expected = {'H', 'o', 'w', ' ', 'n', 'o', 'w'};
		char [] result = SubString.subStringMethod(s, n);
		assertArrayEquals(expected, result);
	}

	@Test
	void testIsItEven() {
		int n = 5287608;
		int expected = 2643804;
		int result = ItIsEven.isEven(n);
		assertEquals(expected, result);
	}
	
	@Test
	void testPalindrome() {
		String input = "madam";
		boolean expected = "true" != null;
		boolean result = Palindromes.findPalindrome(input);
		assertEquals(expected, result);
	}
	
	
	
}
