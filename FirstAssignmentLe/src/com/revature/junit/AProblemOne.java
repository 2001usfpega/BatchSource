package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class AProblemOne {

	@Test
	void bubbleSortTest() {
		double input[] = 	{9.0, 7.0, 5.0, 3.0, 1.0, 8.5, 2.3, 6.7, 4.5	};
		double expected[]= 	{1.0, 2.3, 3.0, 4.5, 5.0, 6.7, 7.0, 8.5, 9.0};
		double returnArr[] = DriverClass.bubbleSort(input);
		assertArrayEquals(expected, returnArr);
	}

}
