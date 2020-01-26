package com.revature.Answer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestClass {
	
	
        
	@Test
	void bubbleSort() {
		int [] array= {1,2,3};
	
		int[] resutlArray=Q1Solved.bubbleSort(array);
		
				assertEquals(array, resutlArray);
		
	}
	
	@Test
	void First25Fibonacci() {
  
	int [] expected={1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393};

	
	
	
	}
	
}
