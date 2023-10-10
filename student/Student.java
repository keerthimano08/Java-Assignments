package org.student;

import org.department.Department;

public class Student extends Department {

	public void studentName() {
		System.out.println("Student name is Keerhtiha");
	}
	
	public void studentDept() {
		System.out.println("Student dept is civil");
	}
	
	public void studentId() {
		System.out.println("Student ID is 1035769");
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();
	}
	
}
