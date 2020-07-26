package com.crescendo.app.core.vo;

import javax.validation.constraints.Size;

public class EnquirySearch {
	
	private String childName;
	private String phoneNumber;
	private String startDateOfEnquiry;
	private String endDateOfEnquiry;
	private String admissionStatus;
	private String gradeEnquiring;
	
	@Size(min=3, max=30, message="Name length must be must be 3 to 30 characters.")
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStartDateOfEnquiry() {
		return startDateOfEnquiry;
	}
	public void setStartDateOfEnquiry(String startDateOfEnquiry) {
		this.startDateOfEnquiry = startDateOfEnquiry;
	}
	public String getEndDateOfEnquiry() {
		return endDateOfEnquiry;
	}
	
	public void setEndDateOfEnquiry(String endDateOfEnquiry) {
		this.endDateOfEnquiry = endDateOfEnquiry;
	}
	public String getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	
	
	public String getGradeEnquiring() {
		return gradeEnquiring;
	}
	public void setGradeEnquiring(String gradeEnquiring) {
		this.gradeEnquiring = gradeEnquiring;
	}
	
	public EnquirySearch(String childName, String phoneNumber, String startDateOfEnquiry, String endDateOfEnquiry,
			String admissionStatus, String gradeEnquiring) {
		super();
		this.childName = childName;
		this.phoneNumber = phoneNumber;
		this.startDateOfEnquiry = startDateOfEnquiry;
		this.endDateOfEnquiry = endDateOfEnquiry;
		this.admissionStatus = admissionStatus;
		this.gradeEnquiring = gradeEnquiring;
	}
	
	public EnquirySearch() {
		super();
	}
	
	@Override
	public String toString() {
		return "EnquirySearch [childName=" + childName + ", phoneNumber=" + phoneNumber + ", startDateOfEnquiry="
				+ startDateOfEnquiry + ", endDateOfEnquiry=" + endDateOfEnquiry + ", admissionStatus=" + admissionStatus
				+ ", gradeEnquiring=" + gradeEnquiring + "]";
	}
	
}
