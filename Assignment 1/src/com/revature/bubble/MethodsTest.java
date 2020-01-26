package com.revature.bubble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MethodsTest {

	@Test
	void testQ1() {
		int bub[] ={1,0,5,6,3,2,3,7,9,8,4};
		int [] expect ={0,1,2,3,3,4,5,6,7,8,9};
		int [] res = Methods.Q1(bub);
		assertArrayEquals(expect,res);
		
	}


	//@Test
	//void testQ2() {
		//int expect = 
		//int res = BubbleSort.Q2();		
		//fail("Not yet implemented");
	//}
//
	@Test
	void testQ3() {
		String expect = "ysae";
		String res = Methods.Q3("easy");
		assertEquals(expect,res);
		
		
	}

//	@Test
//	void testQ4() {
//		int expect = 120;
//		int res = BubbleSort.Q4(5);
//		assertEquals(expect, res);
//	}
//
//	@Test
//	void testQ5() {
//		String expect = "Bot";
//		String res = BubbleSort.Q5("Bottle");
//		assertEquals(expect, res);
//	}
//
//	@Test
//	void testQ6() {
//
//
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


