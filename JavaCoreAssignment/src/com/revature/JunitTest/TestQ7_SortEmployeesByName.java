package com.revature.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.revature.Driver.Employee;
import com.revature.Driver.Q7_SortEmployeesByName;

class TestQ7_SortEmployeesByName {

	@Test
	void test() {
		String expectedsStr = "";
		String actualsStr = "";
		
		
		ArrayList<Employee> actuals = new ArrayList<Employee>();
		actuals.add(new Employee("CCC", "XBX" , 2));
		actuals.add(new Employee("BBB", "XAX" , 3));
		actuals.add(new Employee("AAA", "XCX" , 1));
		
		Collections.sort(actuals, new Q7_SortEmployeesByName());
		
		for (int i=0; i<actuals.size(); i++) 
			actualsStr += actuals.get(i)+" ";
		
		ArrayList<Employee> expecteds = new ArrayList<Employee>();
		expecteds.add(new Employee("AAA", "XCX" , 1));
		expecteds.add(new Employee("BBB", "XAX" , 3));
		expecteds.add(new Employee("CCC", "XBX" , 2));
		
		
		
		for (int i=0; i<expecteds.size(); i++) 
			expectedsStr += expecteds.get(i)+" ";
            
		

		
		assertEquals(expectedsStr, actualsStr);
		
		
		
	}

}
