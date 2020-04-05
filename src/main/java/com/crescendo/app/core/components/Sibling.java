package com.crescendo.app.core.components;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "siblings")
public class Sibling implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SIBLING_NUMBER", unique = true, nullable = false, length = 10)
	private int siblingNumber;
	
	@Column(name="AGE_IN_YEARS", length = 2)
	private int ageInYears;
	
	@Column(name="NUMBER_OF_MONTHS", length = 2)
	private int numberOfMonths;
	
	@Column(name="GENDER", length = 6)
	private String gender;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ENQUIRY_ID", referencedColumnName = "ENQUIRY_ID", nullable = false)
	private Enquiry enquiries;
	
	public Enquiry getEnquiries() {
		return enquiries;
	}
	
	public void setEnquiries(Enquiry enquiries) {
		this.enquiries = enquiries;
	}
	
	public int getSiblingNumber() {
		return siblingNumber;
	}
	public void setSiblingNumber(int siblingNumber) {
		this.siblingNumber = siblingNumber;
	}
	public int getAgeInYears() {
		return ageInYears;
	}
	public void setAgeInYears(int ageInYears) {
		this.ageInYears = ageInYears;
	}
	public int getNumberOfMonths() {
		return numberOfMonths;
	}
	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Sibling [siblingNumber=" + siblingNumber + ", ageInYears=" + ageInYears
				+ ", numberOfMonths=" + numberOfMonths + ", gender=" + gender + ", enquiry=" + enquiries + "]";
	}
	
	
	

	public Sibling(int siblingNumber, int ageInYears, int numberOfMonths, String gender, Enquiry enquiries) {
		super();
		this.siblingNumber = siblingNumber;
		this.ageInYears = ageInYears;
		this.numberOfMonths = numberOfMonths;
		this.gender = gender;
		this.enquiries = enquiries;
	}

	/*
	 * public Sibling(int siblingNumber, int ageInYears, int numberOfMonths, String
	 * gender) { super(); this.ageInYears = ageInYears; this.numberOfMonths =
	 * numberOfMonths; this.gender = gender; }
	 */

	public Sibling(){
	}
}
