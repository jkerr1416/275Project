package org.university.people;

import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public class Staff extends Employee {
	
	private Department department;
	private double payRate;
	private double hoursWorked;
	private int tuitionFee;
	private int campusCredits;
	private int totalCredits;
	
	public Staff() {
		department = new Department();
		payRate = 0;
		hoursWorked = 0;
		tuitionFee = 0;
	}
	
	public int getOnlineCredits() {
		return totalCredits - campusCredits;
	}
	
	public void setCampusCredits(int x) {
		campusCredits = x;
	}
	
	public int getCampusCredits() {
		return campusCredits;
	}
	
	public void setTotalCredits(int x) {
		totalCredits = x;
	}
	
	public int getTotalCredits() {
		return totalCredits;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setMonthlyHours(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	
	public double earns() {
		return payRate * hoursWorked;
	}
	
	public void raise(double x) {
		payRate = payRate * (1+x/100);
	}
	
	public void addCourse(CampusCourse aCourse) {   //CS387 is removed from Carol's schedule(Staff can only take one class at a time). CS372 has been added to Carol's Schedule.
		
		if(this.getCampusclasses().size() != 0) {
			System.out.println(this.getCampusclasses().get(0).getDepartment().getDepartmentName() + this.getCampusclasses().get(0).getCourseNumber() + " is removed from " + this.getName() + "'s schedule(Staff can only take one class at a time). " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			this.getCampusclasses().get(0).getStudentRoster().remove(this);
		}
		else if(this.getOnlineclasses().size() != 0) {
			System.out.println(this.getOnlineclasses().get(0).getDepartment().getDepartmentName() + this.getOnlineclasses().get(0).getCourseNumber() + " is removed from " + this.getName() + "'s schedule(Staff can only take one class at a time). " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			this.getOnlineclasses().get(0).getStudentRoster().remove(this);
		}
		this.getCampusclasses().clear();
		this.getOnlineclasses().clear();
		campusClasses.add(aCourse);
		this.setCampusCredits(aCourse.getCredits());
		this.setTotalCredits(aCourse.getCredits());
		this.setTuitionFee();
		this.sortSchedule();
		
	}
	
	public void addCourse(OnlineCourse aCourse) {
		
		if(this.getCampusclasses().size() != 0) {
			System.out.println(this.getCampusclasses().get(0).getDepartment().getDepartmentName() + this.getCampusclasses().get(0).getCourseNumber() + " is removed from " + this.getName() + "'s schedule(Staff can only take one class at a time). " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			this.getCampusclasses().get(0).getStudentRoster().remove(this);
		}
		else if(this.getOnlineclasses().size() != 0) {
			System.out.println(this.getOnlineclasses().get(0).getDepartment().getDepartmentName() + this.getOnlineclasses().get(0).getCourseNumber() + " is removed from " + this.getName() + "'s schedule(Staff can only take one class at a time). " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			this.getOnlineclasses().get(0).getStudentRoster().remove(this);
		}
		this.getCampusclasses().clear();
		this.getOnlineclasses().clear();
		onlineClasses.add(aCourse);
		this.setCampusCredits(0);
		this.setTotalCredits(aCourse.getCredits());
		this.setTuitionFee();
	}

}
