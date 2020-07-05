package com.crescendo.app.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.app.core.components.Enquiry;
import com.crescendo.app.core.components.admission.Admission;
import com.crescendo.app.core.repository.AdmissionRepository;
import com.crescendo.app.core.vo.AdmissionSearch;


@Service
public class AdmissionService {

	@Autowired
	private EnquiryManagementService enquiryService;
	
	@Autowired
	AdmissionRepository admissionRepository;
	
	
	public Admission populateCommonDetailsFromEnquiry(Admission admissionForm, String enquiryId) {
		// TODO Auto-generated method stub
		
		Enquiry enquiry = enquiryService.findByEnquiryId(enquiryId);
		
		admissionForm.setChildName(enquiry.getChildName());
		admissionForm.setDateOfBirth(enquiry.getDateOfBirth());
		admissionForm.setAgeInYears(enquiry.getAgeInYears());
		admissionForm.setNumberOfMonths(enquiry.getNumberOfMonths());
		admissionForm.setGender(enquiry.getGender());
		
		admissionForm.setFathersEmailId(enquiry.getFathersEmailId());
		admissionForm.setFathersName(enquiry.getFathersName());
		admissionForm.setFathersOccupation(enquiry.getFathersOccupation());
		admissionForm.setFathersPhoneNumber(enquiry.getFathersPhoneNumber());
		admissionForm.setFathersPlaceOfWork(enquiry.getFathersPlaceOfWork());
		
		admissionForm.setMothersEmailId(enquiry.getMothersEmailId());
		admissionForm.setMothersName(enquiry.getMothersName());
		admissionForm.setMothersOccupation(enquiry.getMothersOccupation());
		admissionForm.setMothersPhoneNumber(enquiry.getMothersPhoneNumber());
		admissionForm.setMothersPlaceOfWork(enquiry.getMothersPlaceOfWork());
		
		admissionForm.setResidentialAddress(enquiry.getResidentialAddress());
		
		return admissionForm;
		
	}
	
	public String create(Admission admission) {
		
		Admission adm = admissionRepository.save(admission);
		System.out.println(adm.getAdmissionNumber());
		
		return adm.getAdmissionNumber();
		
	}

	public List<Admission> getAdmissionsBySearch(AdmissionSearch admissionSearch) {
		// TODO Auto-generated method stub
		StringBuilder searchQueryBuilder = new StringBuilder("select * from admissions where ");
		List<String> whereClause = new ArrayList<String>();
		Map<String, Object> args = new HashMap<String, Object>();
		System.out.println(" admissionSearch  : " + admissionSearch.toString());
		
		if(!admissionSearch.getChildName().isEmpty()) {
			whereClause.add("child_name  like '%" + admissionSearch.getChildName() + "%'");
			//args.put("childName", admissionSearch.getChildName() + "%' ");
		}
		
		if(!admissionSearch.getPhoneNumber().isEmpty()) {
			whereClause.add(" (fathers_phone_number = :phoneNumbder " + 
					"OR mothers_phone_number = :phoneNumbder )");
			args.put("phoneNumbder", admissionSearch.getPhoneNumber());
		}
		
		if(!admissionSearch.getStartAdmissionDate().isEmpty()) {
			whereClause.add(" (admission_date >= :startAdmissionDate and admission_date <= :endAdmissionDate ) ");
			args.put("startAdmissionDate", admissionSearch.getStartAdmissionDate());
			
			if(!admissionSearch.getEndAdmissionDate().isEmpty()) {
				args.put("endAdmissionDate", admissionSearch.getEndAdmissionDate());
			} else {
				args.put("endAdmissionDate", LocalDate.now().toString());
			}
			
		}
		
		if(!admissionSearch.getGradeJoiningFor().isEmpty()) {
			whereClause.add(" grade_joining_for = :gradeJoiningFor ");
			args.put("gradeJoiningFor", admissionSearch.getGradeJoiningFor());
		}
		
		if(!admissionSearch.getGradeCurrentlyIn().isEmpty()) {
			whereClause.add(" grade_currently_in = :gradeCurrentlyIn ");
			args.put("gradeCurrentlyIn", admissionSearch.getGradeJoiningFor());
		}
		
		String searchQuery = searchQueryBuilder.append(String.join(" and ", whereClause)).toString();
		
		System.out.println(" args :: " + args.toString());
		
		return admissionRepository.getAdmissionsBySearch(searchQuery, args, Admission.class);
	}

	public Admission findByAdmissionNumber(String admissionNumber) {
		return (Admission) admissionRepository.findById(admissionNumber).get();
	}

}
