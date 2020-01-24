package com.revature.compare;

import java.util.Comparator;

<<<<<<< HEAD
public class StudentComparator  implements Comparator<student>{

	@Override
	public int compare(student o1, student o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getGpa()-o2.getGpa()*100);
	}
	//2nd methos comparing implement comparator and implenten compare
	
	
	
	

=======
public class StudentComparator implements Comparator<Student>{
	//2nd method of comparing- implement COmparator and implement compare()
	@Override
	public int compare(Student o1, Student o2) {
		return (int) ((o1.getGpa()-o2.getGpa())*100);
	}
	
>>>>>>> 7c61e685c67d8ceb7427eebeb87d4a6a7521aec8
}
