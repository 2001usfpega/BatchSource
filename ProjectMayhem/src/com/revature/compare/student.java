package com.revature.compare;

public class student implements Comparable<student> {
// 1st method of comparing -implement comparable
	
	private int studentID;
	private String label;
	private double gpa;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public student(int studentID, String label, double gpa) {
		super();
		this.studentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "student [studentID=" + studentID + ", label=" + label + ", gpa=" + gpa + "]";
	}
	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		return this.getStudentID()-o.getStudentID();
	}
	
}
