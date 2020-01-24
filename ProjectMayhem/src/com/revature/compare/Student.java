package com.revature.compare;

<<<<<<< HEAD
public class Student implements Comparable<Student> {
	private int studentId;
=======
public class Student implements Comparable<Student>{
	//1st method of comparing - Implement Comparable and implement the compareTo()
	
	private int studentID;
>>>>>>> origin/KnightenJ
	private String label;
	private double gpa;
	public Student() {
		super();
<<<<<<< HEAD
	}
	public Student(int studentId, String label, double gpa) {
		super();
		this.studentId = studentId;
		this.label = label;
		this.gpa = gpa;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
=======
		// TODO Auto-generated constructor stub
	}
	public Student(int studentID, String label, double gpa) {
		super();
		this.studentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
>>>>>>> origin/KnightenJ
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
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Student [studentId=" + studentId + ", label=" + label + ", gpa=" + gpa + "]";
	}
	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


=======
		return "Student [studentID=" + studentID + ", label=" + label + ", gpa=" + gpa + "]";
	}
	@Override
	public int compareTo(Student o) {
		
		return this.getStudentID()-o.getStudentID();
	}
	 
>>>>>>> origin/KnightenJ
}
