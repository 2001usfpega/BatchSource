package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Q9;

class TestQ9 {

	@Test
	void test() {
		
		
		int[]  expecteds = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		
		Q9 test = new Q9();
		
		ArrayList<Integer> alQ9 = new ArrayList<Integer> ();
		
		
		for (int i = 1; i <= 50; i++ ) {
			alQ9.add(i);
		}
		
		ArrayList<Integer> ansQ9 = test.prime(alQ9);
		
		int[] actuals = new int[ ansQ9.size() ];
		
		for (int i = 0; i<ansQ9.size() ; i++ ) {
			actuals[i] = ansQ9.get(i);
		}
		
		assertArrayEquals(expecteds, actuals);
		
		
	}

}
