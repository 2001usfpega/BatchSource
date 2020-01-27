package com.revature.compare;

public class Student implements Comparable<Student> {

	private int studentID;
	private String Label;
	private double gpa;

	public Student(int i, String string, double d) {

	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", Label=" + Label + ", gpa=" + gpa + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getStudentID() -o.getStudentID();
	}

}
