package org.university.software;
import java.util.ArrayList;
import java.util.Collections;
import org.university.hardware.*;
import org.university.people.*;

public class OnlineCourse extends Course{
	
	public boolean availableTo(Student aStudent) {
		if(aStudent.getCampusCredits() < 6) {
			System.out.println("Student " + aStudent.getName() + " has only " + aStudent.getCampusCredits() + " on campus credits enrolled. Should have at least 6 credits registered before registering online courses.");
			return false;
		}
		return true;
	}

}






//public abstract class Course {
//
//	private String name;
//	private Department department;
//	private Professor prof;
//	private ArrayList<Student> studentRoster;
//	private Integer courseNumber;
//	private ArrayList<Integer> schedule;
//	private ArrayList<String> strSchedule;
//	private Classroom classRoom;
//	
//	public Course() {
//		
//		name = "unknown";
//		department = new Department();
//		studentRoster = new ArrayList<Student>();
//		courseNumber = 0;
//		schedule = new ArrayList<Integer>();
//		prof = new Professor();
//		strSchedule = new ArrayList<String>();
//		classRoom = new Classroom();
//		
//	}
//
//	public Course(String aName, Department aDept, ArrayList<Student> roster, Integer number, ArrayList<Integer> classes, Professor aProf, ArrayList<String> strSched1, Classroom aClass) {
//		
//		name = aName;
//		department = aDept;
//		studentRoster = roster;
//		courseNumber = number;
//		schedule = classes;
//		prof = aProf;
//		strSchedule = strSched1;
//		classRoom = aClass;
//	}
//	
//	public void setName(String aName) {
//		name = aName;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public Department getDepartment() {
//		return department;
//	}
//	
//	public void setDepartment(Department bDept) {
//		department = bDept;
//	}
//	
//	public ArrayList<Student> getStudentRoster() {
//		
//		return studentRoster;
//		
//	}
//	
//	public void setCourseNumber(Integer number) {
//		courseNumber = number;
//	}
//	
//	public Integer getCourseNumber() {
//		return courseNumber;
//	}
//	
//	public void setSchedule(Integer number) {
//		schedule.add(number);
//		this.sortSchedule();
//	}
//	
//	public ArrayList<Integer> getSchedule(){
//		return schedule;
//	}
//	
//	public String intToString(int aNum) {  // spacing may be off
//		String[] days = {"Mon ", "Tue ", "Wed ", "Thu ", "Fri "};
//		String[] times = {"8:00am to 9:15am","9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"}; 
//		int time = aNum%100;
//		int day = (aNum - time)/100;
//		String dayString = days[(day-1)];
//		String timeString = times[(time - 1)];
//		return dayString + timeString;
//		
//	}
//
//	public Professor getProfessor() {
//		return prof;
//	}
//
//	public void setProfessor(Professor aProf) {
//		this.prof = aProf;
//	}
//	
//	public void sortSchedule() {//make tempSchedule, sort by number, then convert
//		strSchedule.clear();
//		ArrayList<Integer> tempSchedule = new ArrayList<Integer>();
//		tempSchedule.addAll(this.getSchedule());
//		Collections.sort(tempSchedule);
//		for(int j = 0; j < tempSchedule.size(); j++) {
//			strSchedule.add(intToString(tempSchedule.get(j)));
//		}
//	}
//	
//
//	public void printSchedule() { //Tue 8:00am to 9:15am Harvill 203
//		for(int i = 0; i < strSchedule.size(); i++) {
//			System.out.println(strSchedule.get(i) + " " + this.classRoom.getRoomNumber());
//		}
//	}
//	
//	public ArrayList<String> getStrSched(){
//		return strSchedule;
//	}
//	
//	public void setRoomAssigned(Classroom aRoom) {
//		if(aRoom.detectConflict(this) == false) {
//			classRoom = aRoom;
//			aRoom.addClass(this);
//			aRoom.sortSchedule();
//		}
//	}
//	
//	
//	
//}
//
