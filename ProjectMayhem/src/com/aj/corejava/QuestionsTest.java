package com.aj.corejava;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.aj.otherpackage.FloatVars;

class QuestionsTest {

	@Test
	void testQ1BubbleSort() {
		int[] q1Arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] expected = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		int[] result = Questions.q1BubbleSort(q1Arr);

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ2Fibonacci() {
		int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
				10946, 17711, 28657 };
		int[] result = Questions.q2Fibonacci();

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ3ReverseString() {
		String expected = "gnirts a si sihT";
		String result = Questions.q3ReverseString("This is a string");

		assertEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ4NxFactorial() {
		int expected = 24;
		int result = Questions.q4NxFactorial(4);

		assertEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ5SubstringMethod() {
		String str = "Testing the substring method.";
		String expected = "Testing the sub";
		int num = 15;
		String result = Questions.q5SubstringMethod(str, num);

		assertEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ6isEven() {
		int num = 98;
		boolean expected = true;
		boolean result = Questions.q6isEven(num);

		assertEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ7ComparatorSort() {
		String[] expected = { "21", "30", "33", "AJ", "Alia", "Sonya", "Coding", "Construction", "IT" };
		String[] result = Questions.q7ComparatorSort();

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ8palindromeArrayList() {
		String[] expected = { "madam", "civic", "radar", "kayak", "refer", "did" };
		String[] result = Questions.q8palindromeArrayList();

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ9ArrayListPrime() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
		ArrayList<Integer> result = Questions.q9ArrayListPrime();

		assertEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ10TernaryFindMinimum() {
		int i = 12;
		int j = 20;

		int expected = 12;
		int result = Questions.q10TernaryFindMinimum(i, j);

		assertEquals(expected, result);
		Questions.printSeparator();

	}

	@Test
	void testQ11FloatVars() {
		Float[] expected = { 123.23f, 234.23f };
		Float[] result = Questions.q11FloatVars();

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ12PrintEvens() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22,
				24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74,
				76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100));
		ArrayList<Integer> result = Questions.q12PrintEvens();

		assertEquals(expected, result);
		Questions.printSeparator();
	}

//	@Test
//	void testQ13PrintTriangle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ14SwitchCase() {
//		fail("Not yet implemented");
//	}

	@Test
	void testQ15MathInterfaceImplementation() {
		int[] expected = { 15, 9, 36, 4 };
		int[] result = Questions.q15MathInterfaceImplementation();

		assertArrayEquals(expected, result);
		Questions.printSeparator();
	}

	@Test
	void testQ16CountChars() {
		String myStr = "This is a string";
		int expected = 16;
		int result = Questions.q16CountChars(myStr);
		
		assertEquals(expected, result);
		Questions.printSeparator();
	}

//	@Test
//	void testQ17PrincipalInterestCalc() {
//		fail("Not yet implemented");
//	}

	@Test
	void testQ18AbstractStringMethods() {
		String myStr = "This is a string";
		String[] exp = {"This is a string", "YES", "THIS IS A STRING", "1494"};	
		String[] res = Questions.q18AbstractStringMethods(myStr);
		
		assertArrayEquals(exp, res);
		Questions.printSeparator();
	}

//	@Test
//	void testQ19ManipulateArrayList() {
//		fail("Not yet implemented");
//	}

	@Test
	void testQ20readFilePrintDetails() {
		String[] exp;
	}

}
