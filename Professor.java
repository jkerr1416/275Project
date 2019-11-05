package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public class Professor extends Employee {
	
	private Department department;
	private double salary;

	
	public Professor() {
		department = new Department();
		salary = 0;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double earns() {
		return salary/26;
	}
	
	public void raise(double x) {
		this.setSalary(this.getSalary() * (1 + x/100));
	}
	
	public boolean detectProf(Course aCourse) {  //The professor cannot be assigned to this course because professor Homer is already assigned to the course Discrete Structures.
		if(aCourse.getProfessor().getName() != "unknown") {
			return true;
		}
		return false;
	}
	
	public void addCourse(CampusCourse newClass) { 
		if(detectProf(newClass) == false) {
		if(detectConflict(newClass) == false) {
			String tempTime;
			campusClasses.add(newClass);
			newClass.setProfessor(this); 
			for(int i = 0; i < newClass.getSchedule().size(); i++) {
				tempTime = intToString(newClass.getSchedule().get(i));
				this.schedule.add(tempTime);
			}
			this.sortSchedule();
		}
	}
		else {
			System.out.println("The professor " + this.getName() + " cannot be assigned to this campus course because professor " + newClass.getProfessor().getName() + " is already assigned to the course " + newClass.getName() + ".");
		}
		
	}
	
	public void addCourse(OnlineCourse newClass) { //The professor cannot be assigned to this online course because professor Regan is already assigned to the online course Online_Course_1.
		if(detectProf(newClass) == false) {
			onlineClasses.add(newClass);
			newClass.setProfessor(this); 
	}
		else {
			System.out.println("The professor cannot be assigned to this online course because professor " + newClass.getProfessor().getName() + " is already assigned to the online course " + newClass.getName() + ".");
		}
}
}
