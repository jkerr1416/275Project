package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public abstract class Person {
	
	protected String name;
	protected ArrayList<CampusCourse> campusClasses;
	protected ArrayList<OnlineCourse> onlineClasses;
	protected ArrayList<String> schedule;
	
	
	public Person() {
		
		name = "unknown";
		campusClasses = new ArrayList<CampusCourse>();
		schedule = new ArrayList<String>();
		onlineClasses = new ArrayList<OnlineCourse>();
		
	}

	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<CampusCourse> getCampusclasses(){
		return campusClasses;
	}
	
	public ArrayList<OnlineCourse> getOnlineclasses(){
		return onlineClasses;
	}
	
	public ArrayList<String> getSchedule(){
		return schedule;
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
	
	public boolean detectConflict(CampusCourse aCourse) {  //ECE107 course cannot be added to Tharp's Schedule. ECE107 conflicts with ECE320. Conflicting time slot is Mon 9:30am to 10:45am.
		int test = 0;
		for(int i = 0; i < aCourse.getSchedule().size(); i ++) {
			for(int j = 0; j < this.getCampusclasses().size(); j++) {
				for(int k = 0; k < this.getCampusclasses().get(j).getSchedule().size(); k++) {
					if(aCourse.getSchedule().get(i).intValue() == this.getCampusclasses().get(j).getSchedule().get(k).intValue()) {
						System.out.println(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + this.getName() + "'s Schedule. " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + this.getCampusclasses().get(j).getDepartment().getDepartmentName() + this.getCampusclasses().get(j).getCourseNumber() + ". Conflicting time slot is " + intToString(aCourse.getSchedule().get(i)) + ".");
						test = 1;
					}
				}
			}
		}
		if(test == 1) {
			return true;
		}
		return false;
	}
	
	public void printSchedule() {//Mon 9:30am to 10:45am ECE320 Circuits Analysis
		//grab schedule string, then run loop through classes checking their intoToString for that string
		for(int i = 0; i < schedule.size(); i++) {
			for(int j = 0; j < this.getCampusclasses().size(); j++) {
				for(int k = 0; k < this.getCampusclasses().get(j).getSchedule().size(); k++) {
					if(schedule.get(i).equals(intToString(this.getCampusclasses().get(j).getSchedule().get(k)))) {
						System.out.println(schedule.get(i) + " " + this.getCampusclasses().get(j).getDepartment().getDepartmentName() + this.getCampusclasses().get(j).getCourseNumber() + " " + this.getCampusclasses().get(j).getName());
					}
				}
			}
		}
		for(int x = 0; x < this.getOnlineclasses().size(); x++) {
			System.out.println(this.getOnlineclasses().get(x).getCourseNumber() + " " + this.getOnlineclasses().get(x).getName());
		}
	}
	
	public void sortSchedule() {//make tempSchedule, sort by number, then convert
		schedule.clear();
		ArrayList<Integer> tempSchedule = new ArrayList<Integer>();
		for(int i = 0; i < this.getCampusclasses().size(); i++) {
			tempSchedule.addAll(this.getCampusclasses().get(i).getSchedule());
		}
		Collections.sort(tempSchedule);
		for(int j = 0; j < tempSchedule.size(); j++) {
			schedule.add(intToString(tempSchedule.get(j)));
		}
	}

	public abstract void addCourse(CampusCourse newClass);
	
	public abstract void addCourse(OnlineCourse newClass);
	
	
}
	


