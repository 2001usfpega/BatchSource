package com.aj.compare;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareMain {

	public static void printSeparator() {
		System.out.println("~~~~~~~~~~~~~~~~~~");
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.addAll(Arrays.asList(new Student[] { new Student(17, "AJ", 10.0), new Student(22, "Matt", 6.54),
				new Student(13, "Luke", 0.3), new Student(5, "Jinjun", 12.1), new Student(89, "Parker", 7.89) }));
		System.out.println("Original List: ");
		for (Student s : students) {
			System.out.println(s);
		}
		
		printSeparator();
		Collections.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
		
		printSeparator();
		System.out.println("Sorted by GPA: ");
		Collections.sort(students, new StudentComparator());
		for (Student s : students) {
			System.out.println(s);
		}
		
		printSeparator();
		System.out.println("Sorted by label with lambda: ");
		// Functional interfaces have 1 (not default) method
		// we can do lambda with these
		Collections.sort(students, (arg1, arg2) -> {
			return arg1.getLabel().compareTo(arg2.getLabel());
		});
		for (Student s : students) {
			System.out.println(s);
		}

	}

}
