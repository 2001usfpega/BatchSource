package com.revature.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.revature.assignment.DriverClass;

class IProblemNine {

	@Test
	void test() {
		Integer primeList[] = {2,3,5,7,11,13};
		ArrayList<Integer> expected = new ArrayList<>();
		Collections.addAll(expected, primeList);
		
		ArrayList<Integer> actual = DriverClass.primeNum(0, 13);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
