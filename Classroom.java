package org.university.hardware;

import java.util.ArrayList;
import java.util.Collections;

import org.university.people.*;
import org.university.software.*;

public class Classroom {
	
	private String name;
	private ArrayList<CampusCourse> classes;
	private ArrayList<String> schedule;
	
	public Classroom() {
		name = "unknown";
		classes = new ArrayList<CampusCourse>();
		schedule = new ArrayList<String>();
	}
	
	public Classroom(String aName, ArrayList<CampusCourse> aClass, ArrayList<String> aSched) {
		name = aName;
		classes = aClass;
		schedule = aSched;
	}
	
	public String getRoomNumber() {
		return name;
	}
	public void setRoomNumber(String name) {
		this.name = name;
	}
	public ArrayList<CampusCourse> getClasses() {
		return classes;
	}
	public void addClass(CampusCourse aClass) {
		classes.add(aClass);
	}
	public ArrayList<String> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}
	
	
	public String intToString(int aNum) { 
		String[] days = {"Mon ", "Tue ", "Wed ", "Thu ", "Fri "};
		String[] times = {"8:00am to 9:15am","9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"}; 
		int time = aNum%100;
		int day = (aNum - time)/100;
		String dayString = days[(day-1)];
		String timeString = times[(time - 1)];
		return dayString + timeString;
		
	}
	
	public boolean detectConflict(CampusCourse aCourse) {  //ECE107 conflicts with ECE320. 																	Conflicting time slot Mon 9:30am to 10:45am. ECE107 																	course cannot be added to Harvill 101's Schedule.
		for(int i = 0; i < aCourse.getSchedule().size(); i ++) {
			for(int j = 0; j < this.getClasses().size(); j++) {
				for(int k = 0; k < this.getClasses().get(j).getSchedule().size(); k++) {
					if(aCourse.getSchedule().get(i).intValue() == this.getClasses().get(j).getSchedule().get(k).intValue()) {
						System.out.println(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + this.getClasses().get(j).getDepartment().getDepartmentName() + this.getClasses().get(j).getCourseNumber() + ". Conflicting time slot " + intToString(aCourse.getSchedule().get(i)) + ". " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + this.getRoomNumber() + "'s Schedule.");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public void printSchedule() { //Mon 9:30am to 10:45am CS426 Computer Networks
		for(int i = 0; i < schedule.size(); i++) {
			for(int j = 0; j < this.getClasses().size(); j++) {
				for(int k = 0; k < this.getClasses().get(j).getSchedule().size(); k++) {
					if(schedule.get(i).equals(intToString(this.getClasses().get(j).getSchedule().get(k))) ) {
						System.out.println(schedule.get(i) + " " + this.getClasses().get(j).getDepartment().getDepartmentName() + this.getClasses().get(j).getCourseNumber() + " " + this.getClasses().get(j).getName());
					}
				}
			}
		}
	}
	
	public void sortSchedule() {//make tempSchedule, sort by number, then convert
		schedule.clear();
		ArrayList<Integer> tempSchedule = new ArrayList<Integer>();
		for(int i = 0; i < this.getClasses().size(); i++) {
			tempSchedule.addAll(this.getClasses().get(i).getSchedule());
		}
		Collections.sort(tempSchedule);
		for(int j = 0; j < tempSchedule.size(); j++) {
			schedule.add(intToString(tempSchedule.get(j)));
		}
	}

}
