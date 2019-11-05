package org.university.software;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.*;
import org.university.people.*;

public abstract class Course {

	protected String name;
	protected Department department;
	protected Professor prof;
	protected ArrayList<Person> studentRoster;
	protected Integer courseNumber;
	protected Integer creditUnits;
	
	public Course() {
		
		name = "unknown";
		department = new Department();
		studentRoster = new ArrayList<Person>();
		courseNumber = 0;
		prof = new Professor();
		creditUnits = 0;
		
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department bDept) {
		department = bDept;
	}
	
	public ArrayList<Person> getStudentRoster() {
		
		return studentRoster;
		
	}
	
	public void setCourseNumber(Integer number) {
		courseNumber = number;
	}
	
	public Integer getCourseNumber() {
		return courseNumber;
	}

	public Professor getProfessor() {
		return prof;
	}

	public void setProfessor(Professor aProf) {
		this.prof = aProf;
	}
	
	public Integer getCredits() {
		return creditUnits;
	}
	
	public void setCreditUnits(Integer x) {
		creditUnits = x;
	}
	
	public void addStudentToRoster(Person aPerson) {
		
		studentRoster.add(aPerson);
		
	}
	
	public String intToString(int aNum) {  // spacing may be off
		String[] days = {"Mon ", "Tue ", "Wed ", "Thu ", "Fri "};
		String[] times = {"8:00am to 9:15am","9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"}; 
		int time = aNum%100;
		int day = (aNum - time)/100;
		String dayString = days[(day-1)];
		String timeString = times[(time - 1)];
		return dayString + timeString;
		
	}
	
	public abstract boolean availableTo(Student aStudent);
	
}
