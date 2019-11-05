package org.university.software;
import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.*;
import org.university.people.*;

public class CampusCourse extends Course {
	
	private Integer maxNumberOfStudents;
	private ArrayList<Integer> schedule;
	private ArrayList<String> strSchedule;
	private Classroom classRoom;
	
	public CampusCourse() {
		
		maxNumberOfStudents = 0;
		schedule = new ArrayList<Integer>();
		strSchedule = new ArrayList<String>();
		classRoom = new Classroom();
		
	}

	public Integer getMaxNumberOfStudents() {
		return maxNumberOfStudents;
	}

	public void setMaxCourseLimit(Integer maxNumberOfStudents) {
		this.maxNumberOfStudents = maxNumberOfStudents;
	}

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(Integer number) {
		schedule.add(number);
		this.sortSchedule();
	}

	public ArrayList<String> getStrSched() {
		return strSchedule;
	}

	public Classroom getClassRoom() {
		return classRoom;
	}
	
	public void sortSchedule() {//make tempSchedule, sort by number, then convert
		strSchedule.clear();
		ArrayList<Integer> tempSchedule = new ArrayList<Integer>();
		tempSchedule.addAll(this.getSchedule());
		Collections.sort(tempSchedule);
		for(int j = 0; j < tempSchedule.size(); j++) {
			strSchedule.add(intToString(tempSchedule.get(j)));
		}
	}
	

	public void printSchedule() { //Tue 8:00am to 9:15am Harvill 203
		for(int i = 0; i < strSchedule.size(); i++) {
			System.out.println(strSchedule.get(i) + " " + this.classRoom.getRoomNumber());
		}
	}
	
	public void setRoomAssigned(Classroom aRoom) {
		if(aRoom.detectConflict(this) == false) {
			classRoom = aRoom;
			aRoom.addClass(this);
			aRoom.sortSchedule();
		}
	}
	
	public boolean availableTo(Student aStudent) {
		
		if(this.getStudentRoster().size() < maxNumberOfStudents) {
			return true;
		}
		return false;	
	}

}


