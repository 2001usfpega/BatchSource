package com.revatue.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(new Student [] {
				new Student(15, "Matt",6.54),
				new Student(34, "AJ",6.54),
				new Student(21, "TORREZ",6.54),
				new Student(12, "aMANADA",6.54),
				new Student(67, "Jay-Money",6.54),
				new Student(99, "Kaelin",6.54),
				new Student(44, "ALIA",6.54),
				
		}));
		System.out.println("Orignal List");
		for (Student s:studentList) {
			System.out.println(s);
		}
	}

}
