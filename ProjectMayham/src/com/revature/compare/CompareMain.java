package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {

		List<Student> sl=new ArrayList<>();
		sl.addAll(Arrays.asList(new Student [] {
				new Student(15,"matt",6.34),
				new Student(465,"tod",0.9),
				new Student(142,"kay",2.5),
				new Student(836,"guin",9.0),
				new Student(222,"kim",3.4)
		}));
		
		System.out.println("original");
		for(Student s: sl) {
			System.out.println(s.toString());
		}
		Collections.sort(sl);
		System.out.println("\nsorted by id");
		
		for(Student s: sl) {
			System.out.println(s.toString());
		}

		System.out.println("\nsorted by gpa");
		Collections.sort(sl,new StudentComparator());
		for(Student s: sl) {
			System.out.println(s.toString());
		}
		
		System.out.println("\nsorted by label");
		
		Collections.sort(sl,(arg0,arg1)
				->{
					return arg0.getLabel().compareTo(arg1.getLabel());
					}
				);
		
		for(Student s: sl) {
			System.out.println(s.toString());
		}
		
		
	}
}
