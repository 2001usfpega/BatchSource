package com.revarure.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
						new Student(15,"Matt",6.54),
						new Student(34,"AJ",10.0),
						new Student(21,"Torres", 0.3),
						new Student(12,"Amanda", 11.9),
						new Student(67,"Jay-Money",0.9),
						new Student(99,"Kaelin",2.5),
						new Student(44,"Alia",4.0)
				}));
		
		System.out.println("Original List");
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		System.out.println("==============");
		Collections.sort(studentList);
		System.out.println("Sort List");
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		System.out.println("==============");
		Collections.sort(studentList, new StudentComparator());
		System.out.println("Sorted by GPA");
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		System.out.println("==============");
		System.out.println("Sorted by label with lambda");
		
		//Functional interfaces have 1 (not default) method
		//we can do lambda with these
		Collections.sort(studentList,(args0,args1)
				->{return args0.getLabel().compareTo(args1.getLabel());}				
				);
		/*
		 * benefit: Dont have to make new class
		 */
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}
