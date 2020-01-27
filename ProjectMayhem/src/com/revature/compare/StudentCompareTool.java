package com.revature.compare;

import java.util.Comparator;

public class StudentCompareTool implements Comparator<Student>
{
	public int compare(Student o1, Student o2) 
	{
		return(int) ((o1.getGpa()-o2.getGpa())*100);
	}
}
