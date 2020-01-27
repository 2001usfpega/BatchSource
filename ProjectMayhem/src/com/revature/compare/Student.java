package com.revature.compare;

import java.util.Comparator;

public class Student implements Comparator<Student> {
	private int studentID;
	private String label;
	private double GPA;

	public int idGrabber() {
		return studentID;
	}

	public String labelGrabber() {
		return label;
	}

	public double gpaGrabber() {
		return GPA;
	}

	public void setID(int studentID) {
		this.studentID = studentID;
	}

	public Student(int studentID, String label, double GPA) {

		this.studentID = studentID;
		this.label = label;
		this.GPA = GPA;

	}

	public String toString() {
		return "Student [studentID=" + studentID + ", label=" + label + "GPA=" + GPA;
	}

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
