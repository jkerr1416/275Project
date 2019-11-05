package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public class Student extends Person{
	
	private Department department;
	private int unitsCompleted;
	private int totalUnitsNeeded;
	private int totalCredits;
	private int campusCredits;
	private int tuitionFee;
	
	
	public Student() {
		
		department = new Department();
		unitsCompleted = 0;
		totalUnitsNeeded = 0;
		setCampusCredits(0);
		setTotalCredits(0);
		tuitionFee = 0;
		
	}

	public int getOnlineCredits() {
		return totalCredits - campusCredits;
	}
	
	public void setDepartment(Department aDept) {
		department = aDept;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setRequiredCredits(int aNum) {
		totalUnitsNeeded = aNum;
	}
	public int getRequiredCredits() {
		return totalUnitsNeeded;
	}

	public void setCompletedUnits(int aNum) {
		unitsCompleted = aNum;
	}
	public int getCompletedUnits() {
		return unitsCompleted;
	}
	
	public int requiredToGraduate() {
		return (totalUnitsNeeded - unitsCompleted - totalCredits);
	}
	

	public int getTuitionFee() {
		return tuitionFee;
	}
	
	public void setTuitionFee() {
		
		int sum;
		sum = campusCredits * 300;
		for(int i = 0; i < onlineClasses.size(); i++) {
			if(onlineClasses.get(i).getCredits() == 3) {
				sum = sum + 2000;
			}
			else {
				sum= sum + 3000;
			}
		}
		tuitionFee = sum;
		
	}
	
	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public int getCampusCredits() {
		return campusCredits;
	}

	public void setCampusCredits(int campusCredits) {
		this.campusCredits = campusCredits;
	}
	
	public void addCourse(OnlineCourse newClass) { 
			if(newClass.availableTo(this) == true) {
			this.setTotalCredits(this.getTotalCredits() + newClass.getCredits());
			onlineClasses.add(newClass);
			newClass.getStudentRoster().add(this);
			this.setTuitionFee();
			}
			else {
				System.out.println(this.getName() + " can't add online Course " + newClass.getDepartment().getDepartmentName() + newClass.getCourseNumber() + " " + newClass.getName() + ". Because this student doesn't have enough Campus course credit.");
			}
	}
	
	public void addCourse(CampusCourse newClass) { 
		if(detectConflict(newClass) == false) {
			if(newClass.availableTo(this) == true) {
			this.setCampusCredits(this.getCampusCredits() + newClass.getCredits());
			this.setTotalCredits(this.getTotalCredits() + newClass.getCredits());
			String tempTime;
			campusClasses.add(newClass);
			newClass.getStudentRoster().add(this);
			for(int i = 0; i < newClass.getSchedule().size(); i++) {
				tempTime = intToString(newClass.getSchedule().get(i));
				this.schedule.add(tempTime);
			}
			this.sortSchedule();
			this.setTuitionFee();
			}
			else {
				System.out.println(this.getName() + " can't add Campus Course " + newClass.getDepartment().getDepartmentName() + newClass.getCourseNumber() + " " + newClass.getName() + ". Because this Campus course has enough student.");
			}
		}
	}
	
	
	public void dropCourse(CampusCourse aCourse) { 
		if(this.getCampusclasses().contains(aCourse)) {
			if(this.getTotalCredits() == this.getCampusCredits()) {
				this.setCampusCredits(this.getCampusCredits() - aCourse.getCredits());
				this.setTotalCredits(this.getTotalCredits() - aCourse.getCredits());
				String tempTime;
			campusClasses.remove(aCourse);
			aCourse.getStudentRoster().remove(this);
			for(int i = 0; i < aCourse.getSchedule(). size(); i++) {
				tempTime = intToString(aCourse.getSchedule().get(i));
				if(this.schedule.contains(tempTime)) {
					this.schedule.remove(tempTime);
				}
			}
			this.sortSchedule();
			this.setTuitionFee();
			}
			else {
				
				if((this.getCampusCredits() - aCourse.getCredits()) < 6) {
					System.out.println(this.getName() + " can't drop this CampusCourse, because this student doesn't have enough campus course credit to hold the online course");
				}
				else {
					this.setCampusCredits(this.getCampusCredits() - aCourse.getCredits());
					this.setTotalCredits(this.getTotalCredits() - aCourse.getCredits());
					String tempTime;
					campusClasses.remove(aCourse);
					aCourse.getStudentRoster().remove(this);
					for(int i = 0; i < aCourse.getSchedule(). size(); i++) {
						tempTime = intToString(aCourse.getSchedule().get(i));
						if(this.schedule.contains(tempTime)) {
							this.schedule.remove(tempTime);
						}
					}
					this.sortSchedule();
					this.setTuitionFee();
					}
				}
				
			}
		else {
			System.out.println("The course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " could not be dropped because " + this.getName() + " is not enrolled in " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + "."); 
		}
	}
	
	public void dropCourse(OnlineCourse aCourse) { 
		if(this.getOnlineclasses().contains(aCourse)) {
			onlineClasses.remove(aCourse);
			aCourse.getStudentRoster().remove(this);
			this.setTotalCredits(this.getTotalCredits() - aCourse.getCredits());
			this.setTuitionFee();
		}
		else {
			System.out.println("The course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " could not be dropped because " + this.getName() + " is not enrolled in " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + "."); 
		}
	}
	
	



	
	
	
	
	
}
