package com.revature.compare;

import java.util.Comparator;

public class StudentComparator  implements Comparator<student>{

	@Override
	public int compare(student o1, student o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getGpa()-o2.getGpa()*100);
	}
	//2nd methos comparing implement comparator and implenten compare
	
	
	
	

}
