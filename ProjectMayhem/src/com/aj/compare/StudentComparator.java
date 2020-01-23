package com.aj.compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	//second method of comparing - implement Comparator and implement the compare() method
	
	@Override
	public int compare(Student o1, Student o2) {

		return (int) ((o1.getGpa() - o2.getGpa()) * 100);
	}


}
