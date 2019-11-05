package org.university.software;

import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.*;

public class University {

	private String name;
	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		
		name = "unknown";
		departmentList = new ArrayList<Department>();
		classroomList = new ArrayList<Classroom>();
		
	}

	public University(String aName, ArrayList<Department> aDept, ArrayList<Classroom> rooms) {
		
		name = aName;
		departmentList = aDept;
		classroomList = rooms;
		
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public void printProfessorList() {
//		System.out.println("The list of professors in the university:");
		for(int i = 0; i < departmentList.size();i++) {
			for(int j = 0; j < departmentList.get(i).getProfessorList().size(); j++) {
				System.out.println(departmentList.get(i).getProfessorList().get(j).getName());
			}
		}
	}
	
	public void printCourseList() {
//		System.out.println("The list of courses in the university:");
		for(int i = 0; i < departmentList.size();i++) {
			for(int j = 0; j < departmentList.get(i).getCampusCourseList().size(); j++) {
				System.out.println(departmentList.get(i).getCampusCourseList().get(j).getDepartment().getDepartmentName() + departmentList.get(i).getCampusCourseList().get(j).getCourseNumber() + " " + departmentList.get(i).getCampusCourseList().get(j).getName());
			}
		}
		for(int i = 0; i < departmentList.size();i++) {
			for(int j = 0; j < departmentList.get(i).getOnlineCourseList().size(); j++) {
				System.out.println(departmentList.get(i).getOnlineCourseList().get(j).getDepartment().getDepartmentName() + departmentList.get(i).getOnlineCourseList().get(j).getCourseNumber() + " " + departmentList.get(i).getOnlineCourseList().get(j).getName());
			}
		}
	}
	
	public void printStudentList() {
//		System.out.println("The list of students in the university:");
		for(int i = 0; i < departmentList.size();i++) {
			for(int j = 0; j < departmentList.get(i).getStudentList().size(); j++) {
				System.out.println(departmentList.get(i).getStudentList().get(j).getName());
			}
		}
	}
	
	public void printStaffList() {
//		System.out.println("The list of staff at the university:");
		for(int i = 0; i < departmentList.size();i++) {
			for(int j = 0; j < departmentList.get(i).getStaffList().size(); j++) {
				System.out.println(departmentList.get(i).getStaffList().get(j).getName());
			}
		}
	}
	
	
}
