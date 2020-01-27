package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain 
{

	public static void main(String[] args) 
	{
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] 
						{
								new Student (15, "Matt", 6.54 ),
								new Student (34, "AJ", 10.0 ),
								new Student (21, "Torres", 0.3 ),
								new Student (12, "Amanda", 11.9 ),
								new Student (67, "J-money", 0.9 ),
								new Student (99, "Kaelin", 2.5 ),
								new Student (44, "Alia", 4.0 )
						}
				
				
				
				));
		System.out.println("Original List");
		for(Student s:studentList) 
		{
			System.out.println(s);
		}
		System.out.println("==============");
		System.out.println("Sorted by GPA");
		Collections.sort(studentList, new StudentCompareTool());
		for(Student s:studentList) 
		{
			System.out.println(s);
		}
		System.out.println("==============");
		System.out.println("Sorted by labelw/ lambda");
		
		Collections.sort(studentList, (arg0,arg1)
				->{
					return arg0.getLabel().compareTo(arg1.getLabel());
				}
				);
		for(Student s:studentList) 
		{
			System.out.println(s);
		}
	}

}
