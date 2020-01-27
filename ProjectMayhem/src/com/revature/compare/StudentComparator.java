package com.revature.compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	//2nd method of comparing: implement Comparator and implement the compare()

	@Override
	public int compare(Student o1, Student o2) {
		
		return(int) ((o1.gpaGrabber()-o2.gpaGrabber())*100);
	}
	
	

}
