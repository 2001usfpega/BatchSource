package com.aj.corejava;

public class Driver {

	public static void main(String[] saraLance) {
		String myStr = "This is a string";
		int[] q1Arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		Questions.q1BubbleSort(q1Arr);
		Questions.printSeparator();
		Questions.q2Fibonacci();
		Questions.printSeparator();
		Questions.q3ReverseString(myStr);
		Questions.printSeparator();
		Questions.q4NxFactorial(12);
		Questions.printSeparator();
		Questions.q5SubstringMethod(myStr, 9);
		Questions.printSeparator();
		Questions.q6isEven(77);
		Questions.printSeparator();
		Questions.q7ComparatorSort();
		Questions.printSeparator();
		Questions.q8palindromeArrayList();;
		Questions.printSeparator();
		Questions.q9ArrayListPrime();
		Questions.printSeparator();
		Questions.q10TernaryFindMinimum(72, 24);
		Questions.printSeparator();
		Questions.q11FloatVars();
		Questions.printSeparator();
		Questions.q12PrintEvens();
		Questions.printSeparator();
		Questions.q13PrintTriangle();
		Questions.printSeparator();
		Questions.q14SwitchCase();
		Questions.printSeparator();
		Questions.q15MathInterfaceImplementation();
		Questions.printSeparator();
		Questions.q16CountChars(myStr);
		Questions.printSeparator();
//		Questions.q17PrincipalInterestCalc(22);
//		Questions.printSeparator();
		Questions.q18AbstractStringMethods(myStr);
		Questions.printSeparator();
		Questions.q19ManipulateArrayList();
		Questions.printSeparator();
		Questions.q20readFilePrintDetails();
	}
}
