package com.crescendo.app.core.components.admission;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Email;

import com.crescendo.app.core.utils.EnquirySequenceIdGenerator;

@Entity
@Table(name = "admissions", uniqueConstraints = { @UniqueConstraint(columnNames = "ADMISSION_NUMBER") })
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admission_seq")
	@GenericGenerator(name = "admission_seq", strategy = "com.crescendo.app.core.utils.EnquirySequenceIdGenerator", parameters = {
			@Parameter(name = EnquirySequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = EnquirySequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SGHA"),
			@Parameter(name = EnquirySequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

	@Column(name = "ADMISSION_NUMBER", unique = true, updatable = false, nullable = false, length = 15)
	private String admissionNumber;
	
	@Column(name = "ENQUIRY_ID", length = 10)
	private String enquiryId;

	@Column(name = "CHILD_NAME", length = 50)
	@Size(min=3, max=30, message="Name length must be must be 3 to 30 characters.")
	private String childName;

	@Column(name = "DATE_OF_BIRTH", length = 10)
	private String dateOfBirth;

	@Min(value=2, message = "Age must be minimum of 2 years")
	@Column(name = "AGE_IN_YEARS", length = 2)
	private int ageInYears;
	
	@Column(name = "NUMBER_OF_MONTHS", length = 2)
	private int numberOfMonths;

	@Column(name = "GENDER", length = 6)
	private String gender;
	
	@Column(name = "GRADE_JOINING_FOR", length = 10)
	private String gradeJoiningFor;
	
	@Column(name = "FRADE_CURRENTLY_IN", length = 10)
	private String gradeCurrentlyIn;
	
	@Column(name = "BLOOD_GROUP", length = 6)
	private String bloodGroup;
	
	@Column(name = "RELIGION", length = 12)
	private String religion;
	
	@Column(name = "NATIONALITY", length = 12)
	private String nationality;
	
	@Column(name = "MOTHER_TONGUE", length = 12)
	private String motherTongue;
	
	@Column(name = "ALLERGIES", length = 30)
	private String allergies;
	
	@Column(name = "SURGERIES", length = 30)
	private String surgeries;
	
	@Column(name = "CHRONIC_ILLNESS", length = 30)
	private String chronicIllness;
	
	@Column(name = "IMMUNIZATION", length = 3)
	private String immunization;
	
	@Column(name = "FATHERS_NAME", length = 32)
	private String fathersName;
	
	@Column(name = "FATHERS_QUALIFICATION", length = 10)
	private String fathersQualification;

	@Column(name = "FATHERS_OCCUPATION", length = 32)
	private String fathersOccupation;

	@Column(name = "FATHERS_PLACE_OF_WORK", length = 32)
	private String fathersPlaceOfWork;
	
	@Column(name = "FATHERS_OFFICIAL_ADDRESS", length = 32)
	private String fathersOfficialAddress;
	
	@Pattern(regexp="^.*(?=.{10,})(?=.*[0-9]).*$", message = "Phone Number must be of 10 digits")
	@Column(name = "FATHERS_PHONE_NUMBER", length = 10)
	private String fathersPhoneNumber;
	
	@Email(message = "Invalid Email (Eg : a1@gmail.com)")
	@Column(name = "FATHERS_EMAIL_ID", length = 32)
	private String fathersEmailId;

	@Column(name = "MOTHERS_NAME", length = 32)
	private String mothersName;
	
	@Column(name = "MOTHERS_QUALIFICATION", length = 10)
	private String mothersQualification;

	@Column(name = "MOTHERS_OCCUPATION", length = 32)
	private String mothersOccupation;

	@Column(name = "MOTHERS_PLACE_OF_WORK", length = 32)
	private String mothersPlaceOfWork;
	
	@Column(name = "MOTHERS_OFFICIAL_ADDRESS", length = 32)
	private String mothersOfficialAddress;
	
	@Pattern(regexp="^.*(?=.{10,})(?=.*[0-9]).*$", message = "Phone Number must be of 10 digits")
	@Column(name = "MOTHERS_PHONE_NUMBER", length = 10)
	private String mothersPhoneNumber;
	
	@Email(message = "Invalid Email (Eg : a1@gmail.com)")
	@Column(name = "MOTHERS_EMAIL_ID", length = 32)
	private String mothersEmailId;
	
	@Column(name = "RESIDENTIAL_ADDRESS", length = 64)
	private String residentialAddress;

	@Column(name = "ADMISSION_DATE", length = 64)
	private String admissionDate;

	
	
	public Admission(String admissionNumber, String enquiryId,
			String childName, String dateOfBirth, int ageInYears,
			int numberOfMonths, String gender, String gradeJoiningFor, String gradeCurrentlyIn, String bloodGroup,
			String religion, String nationality, String motherTongue, String allergies, String surgeries,
			String chronicIllness, String immunization, String fathersName, String fathersQualification,
			String fathersOccupation, String fathersPlaceOfWork, String fathersOfficialAddress,
			String fathersPhoneNumber, String fathersEmailId, String mothersName,
			String mothersQualification, String mothersOccupation, String mothersPlaceOfWork,
			String mothersOfficialAddress, String mothersPhoneNumber, String mothersEmailId, String residentialAddress) {
		super();
		this.admissionNumber = admissionNumber;
		this.enquiryId = enquiryId;
		this.childName = childName;
		this.dateOfBirth = dateOfBirth;
		this.ageInYears = ageInYears;
		this.numberOfMonths = numberOfMonths;
		this.gender = gender;
		this.gradeJoiningFor = gradeJoiningFor;
		this.gradeCurrentlyIn = gradeCurrentlyIn;
		this.bloodGroup = bloodGroup;
		this.religion = religion;
		this.nationality = nationality;
		this.motherTongue = motherTongue;
		this.allergies = allergies;
		this.surgeries = surgeries;
		this.chronicIllness = chronicIllness;
		this.immunization = immunization;
		this.fathersName = fathersName;
		this.fathersQualification = fathersQualification;
		this.fathersOccupation = fathersOccupation;
		this.fathersPlaceOfWork = fathersPlaceOfWork;
		this.fathersOfficialAddress = fathersOfficialAddress;
		this.fathersPhoneNumber = fathersPhoneNumber;
		this.fathersEmailId = fathersEmailId;
		this.mothersName = mothersName;
		this.mothersQualification = mothersQualification;
		this.mothersOccupation = mothersOccupation;
		this.mothersPlaceOfWork = mothersPlaceOfWork;
		this.mothersOfficialAddress = mothersOfficialAddress;
		this.mothersPhoneNumber = mothersPhoneNumber;
		this.mothersEmailId = mothersEmailId;
		this.residentialAddress = residentialAddress;
		this.admissionDate = LocalDate.now().toString();
	}

	public Admission() {
		super();
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getSurgeries() {
		return surgeries;
	}

	public void setSurgeries(String surgeries) {
		this.surgeries = surgeries;
	}

	public String getChronicIllness() {
		return chronicIllness;
	}

	public void setChronicIllness(String chronicIllness) {
		this.chronicIllness = chronicIllness;
	}

	public String getImmunization() {
		return immunization;
	}

	public void setImmunization(String immunization) {
		this.immunization = immunization;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFathersQualification() {
		return fathersQualification;
	}

	public void setFathersQualification(String fathersQualification) {
		this.fathersQualification = fathersQualification;
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

	public String getFathersOfficialAddress() {
		return fathersOfficialAddress;
	}

	public void setFathersOfficialAddress(String fathersOfficialAddress) {
		this.fathersOfficialAddress = fathersOfficialAddress;
	}

	public String getFathersPhoneNumber() {
		return fathersPhoneNumber;
	}

	public void setFathersPhoneNumber(String fathersPhoneNumber) {
		this.fathersPhoneNumber = fathersPhoneNumber;
	}

	public String getFathersEmailId() {
		return fathersEmailId;
	}

	public void setFathersEmailId(String fathersEmailId) {
		this.fathersEmailId = fathersEmailId;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getMothersQualification() {
		return mothersQualification;
	}

	public void setMothersQualification(String mothersQualification) {
		this.mothersQualification = mothersQualification;
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

	public String getMothersOfficialAddress() {
		return mothersOfficialAddress;
	}

	public void setMothersOfficialAddress(String mothersOfficialAddress) {
		this.mothersOfficialAddress = mothersOfficialAddress;
	}

	public String getMothersPhoneNumber() {
		return mothersPhoneNumber;
	}

	public void setMothersPhoneNumber(String mothersPhoneNumber) {
		this.mothersPhoneNumber = mothersPhoneNumber;
	}

	public String getMothersEmailId() {
		return mothersEmailId;
	}

	public void setMothersEmailId(String mothersEmailId) {
		this.mothersEmailId = mothersEmailId;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	
}
