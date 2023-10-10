package org.methodOverload;

public class Students {

	public void getStudentInfo() {
		System.out.println("student name is Keerthiha");
	}
	
	public void getStudentInfo(int id) {
		System.out.println("Student id is "+ id);
	}
	public void getStudentInfo(int id, String name) {
		System.out.println("Student id is "+id+ " and name is "+name);
	}
	public void getStudentInfo(String email,long phoneNumber) {
		System.out.println("Student email is "+email+ " and name is "+phoneNumber);
	}
	
	public static void main(String[] args) {
		Students student = new Students();
		student.getStudentInfo();
		student.getStudentInfo(546);
		student.getStudentInfo(546, "keerthiha");
		student.getStudentInfo("keerthi123@gamil.com", 1050802536);
	}
}
