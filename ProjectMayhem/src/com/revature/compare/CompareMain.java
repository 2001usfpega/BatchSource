package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {
 public static void main(String[] args) {
	 List<Student> studentList = new ArrayList<Student>();
	 
	 studentList.addAll(Arrays.asList(
			 new Student [] {
					 new Student(15, "Matt", 6.4),
					 new Student(34, "AJ", 4.0)
			 }
			 ));
	 
	 System.out.println("Original list");
	 
	 for(Student s: studentList) {
		 System.out.println(s);
	 }
	 
	 System.out.println("sorted by GPA");
	 Collections.sort(studentList, new StudentComparator());
	 System.out.println("Sorted by lable w/ lambda");
	 
	 Collections.sort(studentList,  (arg0,arg1)
			 ->{
				return arg0.getLabel().compareTo(arg1.getLabel());
			 }
			 );
	 
 }
}
