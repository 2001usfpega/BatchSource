package com.revature.homework;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import com.revature.homework.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JTest {
	private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
 
    @BeforeEach
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }
 
    @AfterEach
    public void revertStreams() {
        System.setOut(sysOut);
    }
 
    //test Q1
	@Test
	void testBubbleSort() {
		Classy.bubbleSort(9,1333,-2,1,1,0,5,4);
		String expected="-2 0 1 1 4 5 9 1333";//	"0 1 2 3 3 4 5 6 7 8 9";
		
		String s = outContent.toString().split("\n")[2].trim();
	    assertEquals(expected, s);
	}
	
	//test Q2
	@Test
	void testFib() {
		Classy.fib(-2);
		char expected='0';
		char c = outContent.toString().split("\n")[1].charAt(0);
	    assertFalse(expected==c);
	}
	
	//test Q3
	@Test
	void testReverseString() {
		Classy.reverseString("abcdefghijklmnopqrstuvwxyz");
		String expected="zyxwvutsrqponmlkjihgfedcba";
		String s = outContent.toString().split("\n")[2].trim();
	    assertEquals(expected, s);
		
	}//Q3
		
	//test Q4
	@Test
	void testFactorial() {
		Classy.factorial(-3);
		String expected="-6";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);
	}//Q4
	
	//test Q5
	@Test
	void testSubString() {
		Classy.subString("taco",5);
		String expected="Nope!";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);
	}//Q5
	
	//test Q6 
	@Test
	void testEvenOdd() {//2) {
		Classy.evenOdd(-2);
		String expected="-2 is even!";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);
	}//Q6
	
	//test Q7
	@Test
	void testSortEmployees() {
		Classy.sortEmployees();
		String expected="name=Jake, department=IT, age=25\n";
		expected+=		"name=Todd, department=AI, age=31";
		
		String s = outContent.toString();
		s=s.split("\n")[11].trim()+"\n"+s.split("\n")[12].trim();
		
	    assertEquals(expected, s);
	}//Q7
	
	//test Q8
	@Test
	void testPalindromes() {
		Classy.palindromes("","boot","lol","noon","0");
		String expected="lol noon 0";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);
	}//Q8
	
	//test Q9
	@Test
	void testPrimeNums() {
		Classy.primeNums(10);
		String expected="2 3 5 7";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q9
	
	//test Q10
	@Test
	void testMinimum() {
		Classy.minimum(-6,15);
		String expected="-6 is smaller than 15";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q10
	
	//test Q11
	@Test
	void testPrintFloatsFromElsewhere() {
		Classy.printFloatsFromElsewhere();
		String expected="80.234, 50214.125";
		String s = outContent.toString().split("\n")[2].trim();
	    assertEquals(expected, s);
	}//Q11
	
	//test Q12
	@Test
	void testPrintEvenTo() {
		Classy.printEvenTo(-10);
		String expected="Must be a positive number";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q12
	
	//test Q13
	@Test
	void testMakeTriangle() {
		Classy.makeTriangle(-5);
		String expected="01010";
		String s = outContent.toString().split("\n")[2].trim();
	    assertEquals(expected, s);		
	}//Q13
	
	//test 14
	@Test
	void testSwitchCases1() {
		Classy.switchCases(0);
		String expected="the square root of PI is 1.7724538509055159";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q14
		
	//test 14
	@Test
	void testSwitchCases2() {
		Classy.switchCases(1);
		String expected="2020-01-26";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q14
		
	//test Q14
	@Test
	void testSwitchCases3() {
		Classy.switchCases(2);
		String expected="Java";
		String s = outContent.toString().split("\n")[5].trim();
	    assertEquals(expected, s);		
	}//Q14
	
	//test Q15
	@Test
	void testCalculations() {//53.5,33.2) {
		Classy.calculations(0.5,52.6);
		String expected="0.5 x 52.6 = 26.3";
		String s = outContent.toString().split("\n")[3].trim();
	    assertEquals(expected, s);		
	}//Q15
	
	//test Q16
	@Test
	void testCountLetters() {
		Classy.countLetters("hello moto");
		String expected="hello moto has 10 characters";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q16
	
	//test Q17
	@Test
	void testInteresting() {
		Classy.interesting();//5,6,7
		String expected="Your interest will be $210.0";
		String s = outContent.toString().split("\n")[2].trim();
	    assertEquals(expected, s);		
	}//Q17
	
	//test Q18
	@Test
	void testKonctete() {
		Classy.konctete("A");
		String expected="A has an upper case character";
		String s = outContent.toString().split("\n")[1].trim();
	    assertEquals(expected, s);		
	}//Q18
	
	//test Q19
	@Test
	void testNumbersAndSums() {
		Classy.numbersAndSums(12);
		String expected="non-primes are: 1 4 6 8 9 10 12";
		String s = outContent.toString().split("\n")[4].trim();
	    assertEquals(expected, s);		
	}//Q19
	
	//test Q20
	@Test
	void testDataReader() {
		Classy.dataReader();
		String expected="Name: Roger Rabbit" + 
						"Age: 22 years" + 
						"State: California State";
		String s[] = outContent.toString().split("\n");
		String s2 = s[9].trim()+s[10].trim()+s[11];
	    assertEquals(expected, s2);
		
	}//Q20

}
