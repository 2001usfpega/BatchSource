package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args)
	{
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				
				new Student [] {
						new Student(15, "Matt", 6.54),
						new Student(12, "Matt", 6.58),
						new Student(45, "Matt", 6.59)
						
						}));
		
		System.out.println("Original List");
		for(Student s:studentList)
		{
			System.out.println(s);
			
		}
		System.out.println("=================");
		Collections.sort(studentList);
		}

}
