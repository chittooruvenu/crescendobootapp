package com.crescendo.app.core.components;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.crescendo.app.core.utils.EnquirySequenceIdGenerator;

@Entity
@Table(name = "enquiries", uniqueConstraints = { @UniqueConstraint(columnNames = "ENQUIRY_ID") })
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enquiry_seq")
	@GenericGenerator(name = "enquiry_seq", strategy = "com.crescendo.app.core.utils.EnquirySequenceIdGenerator", parameters = {
			@Parameter(name = EnquirySequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = EnquirySequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CENQ"),
			@Parameter(name = EnquirySequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

	@Column(name = "ENQUIRY_ID", unique = true, updatable = false, nullable = false, length = 10)
	private String enquiryId;

	@Column(name = "CHILD_NAME", length = 50)
	// @NotBlank(message="Please enter Child Name")
	@Size(min=3, max=30, message="Child Name must be 3 to 30 characters in length.")
	private String childName;

	@Column(name = "DATE_OF_BIRTH", length = 12)
	private String dateOfBirth;

	@Min(value=2, message = "Age must be minimum of 2 years")
	@Column(name = "AGE_IN_YEARS", length = 2)
	private int ageInYears;
	@Max(value = 11)
	@Column(name = "NUMBER_OF_MONTHS", length = 2)
	private int numberOfMonths;

	@Column(name = "GENDER", length = 6)
	private String gender;

	@Column(name = "GRADE_ENQUIRING", length = 10)
	private String gradeEnquiring;

	@Column(name = "FATHERS_NAME", length = 32)
	private String fathersName;

	@Column(name = "FATHERS_OCCUPATION", length = 32)
	private String fathersOccupation;

	@Column(name = "FATHERS_PLACE_OF_WORK", length = 32)
	private String fathersPlaceOfWork;

	@Column(name = "FATHERS_PHONE_NUMBER", length = 10)
	private long fathersPhoneNumber;

	@Column(name = "FATHERS_EMAIL_ID", length = 32)
	private String fathersEmailId;

	@Column(name = "MOTHERS_NAME", length = 32)
	private String mothersName;

	@Column(name = "MOTHERS_OCCUPATION", length = 32)
	private String mothersOccupation;

	@Column(name = "MOTHERS_PLACE_OF_WORK", length = 32)
	private String mothersPlaceOfWork;

	@Column(name = "MOTHERS_PHONE_NUMBER", length = 10)
	private long mothersPhoneNumber;

	@Column(name = "MOTHERS_EMAIL_ID", length = 32)
	private String mothersEmailId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enquiries", cascade = CascadeType.ALL)
	private List<Sibling> siblings;

	@Column(name = "RESIDENTIAL_ADDRESS", length = 64)
	private String residentialAddress;

	@Column(name = "LANDLINE_NUMBER", length = 11)
	private long landLineNumber;

	@Column(name = "CHALLENGES_SPECIALITIES", length = 128)
	private String challengesAndSpecialities;

	@Column(name = "EXPECTATION_FROM_SCHOOL", length = 128)
	private String expectationFromSchool;

	@Column(name = "DATE_OF_ENQUIRY", length = 12)
	private String dateOfEnquiry;

	@Column(name = "ADMISSION_STATUS", length = 16)
	private String admissionStatus;

	@Column(name = "REFERRED_BY", length = 20)
	private String referredBy;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "enquiries", cascade = CascadeType.ALL)
	private List<FollowUp> followUps;

	public String getEnquiryId() {
		return enquiryId;
	}

	public Enquiry(String enquiryId, String childName, String dateOfBirth, int ageInYears, int numberOfMonths,
			String gender, String gradeEnquiring, String fathersName, String fathersOccupation,
			String fathersPlaceOfWork, long fathersPhoneNumber, String fathersEmailId, String mothersName,
			String mothersOccupation, String mothersPlaceOfWork, long mothersPhoneNumber, String mothersEmailId,
			List<Sibling> siblings, String residentialAddress, long landLineNumber, String challengesAndSpecialities,
			String expectationFromSchool, String dateOfEnquiry, String admissionStatus, String referredBy,
			List<FollowUp> followUps) {
		super();
		this.enquiryId = enquiryId;
		this.childName = childName;
		this.dateOfBirth = dateOfBirth;
		this.ageInYears = ageInYears;
		this.numberOfMonths = numberOfMonths;
		this.gender = gender;
		this.gradeEnquiring = gradeEnquiring;
		this.fathersName = fathersName;
		this.fathersOccupation = fathersOccupation;
		this.fathersPlaceOfWork = fathersPlaceOfWork;
		this.fathersPhoneNumber = fathersPhoneNumber;
		this.fathersEmailId = fathersEmailId;
		this.mothersName = mothersName;
		this.mothersOccupation = mothersOccupation;
		this.mothersPlaceOfWork = mothersPlaceOfWork;
		this.mothersPhoneNumber = mothersPhoneNumber;
		this.mothersEmailId = mothersEmailId;
		this.siblings = siblings;
		this.residentialAddress = residentialAddress;
		this.landLineNumber = landLineNumber;
		this.challengesAndSpecialities = challengesAndSpecialities;
		this.expectationFromSchool = expectationFromSchool;
		this.dateOfEnquiry = dateOfEnquiry;
		this.admissionStatus = admissionStatus;
		this.referredBy = referredBy;
		this.followUps = followUps;
	}

	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}

	public List<FollowUp> getFollowUps() {
		return followUps;
	}

	public void setFollowUps(List<FollowUp> followUps) {
		this.followUps = followUps;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getGradeEnquiring() {
		return gradeEnquiring;
	}

	public void setGradeEnquiring(String gradeEnquiring) {
		this.gradeEnquiring = gradeEnquiring;
	}

	public String getFathersOccupation() {
		return fathersOccupation;
	}

	public void setFathersOccupation(String fathersOccupation) {
		this.fathersOccupation = fathersOccupation;
	}

	public String getFathersPlaceOfWork() {
		return fathersPlaceOfWork;
	}

	public void setFathersPlaceOfWork(String fathersPlaceOfWork) {
		this.fathersPlaceOfWork = fathersPlaceOfWork;
	}

	public long getFathersPhoneNumber() {
		return fathersPhoneNumber;
	}

	public void setFathersPhoneNumber(long fathersPhoneNumber) {
		this.fathersPhoneNumber = fathersPhoneNumber;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getMothersOccupation() {
		return mothersOccupation;
	}

	public void setMothersOccupation(String mothersOccupation) {
		this.mothersOccupation = mothersOccupation;
	}

	public String getMothersPlaceOfWork() {
		return mothersPlaceOfWork;
	}

	public void setMothersPlaceOfWork(String mothersPlaceOfWork) {
		this.mothersPlaceOfWork = mothersPlaceOfWork;
	}

	public long getMothersPhoneNumber() {
		return mothersPhoneNumber;
	}

	public void setMothersPhoneNumber(long mothersPhoneNumber) {
		this.mothersPhoneNumber = mothersPhoneNumber;
	}

	public String getMothersEmailId() {
		return mothersEmailId;
	}

	public void setMothersEmailId(String mothersEmailId) {
		this.mothersEmailId = mothersEmailId;
	}

	public List<Sibling> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<Sibling> siblings) {
		this.siblings = siblings;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public long getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(long landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getChallengesAndSpecialities() {
		return challengesAndSpecialities;
	}

	public void setChallengesAndSpecialities(String challengesAndSpecialities) {
		this.challengesAndSpecialities = challengesAndSpecialities;
	}

	public String getExpectationFromSchool() {
		return expectationFromSchool;
	}

	public void setExpectationFromSchool(String expectationFromSchool) {
		this.expectationFromSchool = expectationFromSchool;
	}

	public String getDateOfEnquiry() {
		return dateOfEnquiry;
	}

	public void setDateOfEnquiry(String dateOfEnquiry) {
		this.dateOfEnquiry = dateOfEnquiry;
	}

	public String getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFathersEmailId() {
		return fathersEmailId;
	}

	public void setFathersEmailId(String fathersEmailId) {
		this.fathersEmailId = fathersEmailId;
	}

	public Enquiry() {
		super();
	}
	
	
}
