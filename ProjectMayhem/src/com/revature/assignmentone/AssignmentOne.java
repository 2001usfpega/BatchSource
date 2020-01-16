package com.revature.assignmentone;

public class AssignmentOne {
	
	static Integer myInteger=7;
	static Integer newInteger=2;

	public static void main(String[] args) {
		System.out.println(addItNow(myInteger, newInteger));
		vArgs("Tyler", "Ben", "Alice", "Karen", "Ken");
	}
	public static double addItNow(Integer a, Integer b) {
		return a.doubleValue()*b.doubleValue();
	}
	public static void vArgs(String...c) {
		System.out.println("This is how many names are inside: "+ c.length +" The contents inside are: ");
		for(String x:c) {
			System.out.print(x+" ");
		}
		
	}
	
}
