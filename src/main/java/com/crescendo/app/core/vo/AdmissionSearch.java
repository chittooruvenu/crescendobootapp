package com.crescendo.app.core.vo;

public class AdmissionSearch {
	
	private String childName;
	private String gradeJoiningFor;
	private String gradeCurrentlyIn;
	private String startAdmissionDate;
	private String endAdmissionDate;
	private String phoneNumber;
	

	
	public AdmissionSearch(String childName, String gradeJoiningFor, String gradeCurrentlyIn, String startAdmissionDate,
			String endAdmissionDate, String phoneNumber) {
		super();
		this.childName = childName;
		this.gradeJoiningFor = gradeJoiningFor;
		this.gradeCurrentlyIn = gradeCurrentlyIn;
		this.startAdmissionDate = startAdmissionDate;
		this.endAdmissionDate = endAdmissionDate;
		this.phoneNumber = phoneNumber;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getGradeJoiningFor() {
		return gradeJoiningFor;
	}
	public void setGradeJoiningFor(String gradeJoiningFor) {
		this.gradeJoiningFor = gradeJoiningFor;
	}
	public String getGradeCurrentlyIn() {
		return gradeCurrentlyIn;
	}
	public void setGradeCurrentlyIn(String gradeCurrentlyIn) {
		this.gradeCurrentlyIn = gradeCurrentlyIn;
	}
	public String getStartAdmissionDate() {
		return startAdmissionDate;
	}
	public void setStartAdmissionDate(String startAdmissionDate) {
		this.startAdmissionDate = startAdmissionDate;
	}
	public String getEndAdmissionDate() {
		return endAdmissionDate;
	}
	public void setEndAdmissionDate(String endAdmissionDate) {
		this.endAdmissionDate = endAdmissionDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
