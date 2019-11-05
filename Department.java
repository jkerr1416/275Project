package org.university.hardware;

import java.util.ArrayList;

import org.university.people.*;
import org.university.software.*;

public class Department {
	
	private String name;
	private ArrayList<Student> students;
	private ArrayList<CampusCourse> campusCourses;
	private ArrayList<Professor> professors;
	private ArrayList<Staff> staffList;
	private ArrayList<OnlineCourse> onlineCourses;
	
	public Department() {
		
		name = "unknown";
		students = new ArrayList<Student>();
		campusCourses = new ArrayList<CampusCourse>();
		professors = new ArrayList<Professor>();
		staffList = new ArrayList<Staff>();
		onlineCourses = new ArrayList<OnlineCourse>();
		
	}

//	public Department(String aName, ArrayList<Student> roster, ArrayList<Course> classes, ArrayList<Professor> profs) {
//		
//		name = aName;
//		students = roster;
//		courses = classes;
//		professors = profs;
//	}
//	
	
	public void addStaff(Staff aStaff) {
		staffList.add(aStaff);
		aStaff.setDepartment(this);
	}
	
	public ArrayList<Staff> getStaffList(){
		return staffList;
	}
	
	public void addProfessor(Professor aProf) {
		professors.add(aProf);
		aProf.setDepartment(this);
	}
	
	public ArrayList<Professor> getProfessorList(){
		return professors;
	}
	
	public void setDepartmentName(String aName) {
		name = aName;
	}
	
	public String getDepartmentName() {
		return name;
	}
	
	public void addCourse(CampusCourse aCourse) {
		campusCourses.add(aCourse);
		aCourse.setDepartment(this);
	}
	
	public void addCourse(OnlineCourse aCourse) {
		onlineCourses.add(aCourse);
		aCourse.setDepartment(this);
	}
	
	public ArrayList<CampusCourse> getCampusCourseList(){
		return campusCourses;
	}
	
	public ArrayList<OnlineCourse> getOnlineCourseList(){
		return onlineCourses;
	}
	
	public void addStudent(Student aStudent) {
		students.add(aStudent);
		aStudent.setDepartment(this);
	}
	
	public ArrayList<Student> getStudentList(){
		return students;
	}
	
	public void printStudentList() {
		//The student list for department CS:
		//Ben
		//Jerry
		for(int i = 0; i < this.getStudentList().size(); i++) {
			System.out.println( this.getStudentList().get(i).getName());
		}
		
	}
	
	public void printProfessorList() {
		//The professor list for department ECE:
		//Regan
		//RosenBlit
		//Tharp
		for(int i = 0; i < this.getProfessorList().size(); i++) {
			System.out.println( this.getProfessorList().get(i).getName());
		}
	}
	
	public void printCourseList() {
		//The course list for department ECE:
		//ECE275
		//ECE320
		//ECE373
		//ECE107
		for(int i = 0; i < this.getCampusCourseList().size(); i++) {
			System.out.println(this.getCampusCourseList().get(i).getDepartment().getDepartmentName() + this.getCampusCourseList().get(i).getCourseNumber() + " " + this.getCampusCourseList().get(i).getName());
		}
		for(int i = 0; i < this.getOnlineCourseList().size(); i++) {
			System.out.println(this.getOnlineCourseList().get(i).getDepartment().getDepartmentName() + this.getOnlineCourseList().get(i).getCourseNumber() + " " + this.getOnlineCourseList().get(i).getName());
		}
		
	}
	
	public void printStaffList() {
		for(int i = 0; i < this.getStaffList().size(); i++) {
			System.out.println( this.getStaffList().get(i).getName());
		}
		
	}
	

}
