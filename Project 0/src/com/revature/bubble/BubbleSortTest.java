package com.revature.bubble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void testQ1() {
		int bub[] ={1,0,5,6,3,2,3,7,9,8,4};
		int [] expect ={0,1,2,3,3,4,5,6,7,8,9};
		int [] res = BubbleSort.Q1(bub);
		assertArrayEquals(expect,res);
		
	}


	//@Test
	//void testQ2() {
		//int expect = 
		//int res = BubbleSort.Q2();		
		//fail("Not yet implemented");
	//}
//
//	@Test
//	void testQ3() {
//		
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ4() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ5() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ6() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ7() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ8() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ10() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ11() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ12() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ13() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ14() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ16() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ17() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ18() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQ19() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testMain() {
//		fail("Not yet implemented");
//	}
//
}


