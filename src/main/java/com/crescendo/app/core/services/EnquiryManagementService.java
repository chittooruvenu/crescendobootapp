package com.crescendo.app.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.app.core.components.Enquiry;
import com.crescendo.app.core.components.FollowUp;
import com.crescendo.app.core.components.Sibling;
import com.crescendo.app.core.repository.EnquiryRepository;
import com.crescendo.app.core.repository.FollowUpRepository;
import com.crescendo.app.core.repository.SiblingRepository;
import com.crescendo.app.core.vo.EnquirySearch;


@Service
public class EnquiryManagementService {

	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	SiblingRepository siblingRepository;
	
	@Autowired
	FollowUpRepository followupRepository;
	
	

	public void create(Enquiry enquiry) {
		List<Sibling> siblings = enquiry.getSiblings();
		List<FollowUp> followUps = enquiry.getFollowUps();
		
		if (null != siblings && !siblings.isEmpty()) {
			for(Sibling sibling : siblings){
				sibling.setEnquiries(enquiry);
			}
		}
		
		if (null != followUps && !followUps.isEmpty()) {
			for(FollowUp followup : followUps){
				followup.setEnquiries(enquiry);
			}
		}
				
		enquiryRepository.save(enquiry);
		
	}

	public List<Enquiry> getEnqueries() {
		return enquiryRepository.findAll();
	}
	
	public List<Enquiry> getEnqueriesBySearch(EnquirySearch enquirySearch) {
		
		StringBuilder searchQueryBuilder = new StringBuilder("select * from enquiries where ");
		List<String> whereClause = new ArrayList<String>();
		Map<String, Object> args = new HashMap<String, Object>();
		System.out.println(" enquirySearch  : " + enquirySearch.toString());
		
		if(!enquirySearch.getChildName().isEmpty()) {
			whereClause.add("child_name  like '%" + enquirySearch.getChildName() + "%'");
			//args.put("childName", enquirySearch.getChildName() + "%' ");
		}
		
		if(!enquirySearch.getPhoneNumber().isEmpty()) {
			whereClause.add(" (fathers_phone_number = :phoneNumbder " + 
					"OR mothers_phone_number = :phoneNumbder )");
			args.put("phoneNumbder", enquirySearch.getPhoneNumber());
		}
		
		if(!enquirySearch.getStartDateOfEnquiry().isEmpty()) {
			whereClause.add(" (date_of_enquiry >= :startDateOfEnquiry and date_of_enquiry <= :endDateOfEnquiry ) ");
			args.put("startDateOfEnquiry", enquirySearch.getStartDateOfEnquiry());
			
			if(!enquirySearch.getEndDateOfEnquiry().isEmpty()) {
				args.put("endDateOfEnquiry", enquirySearch.getEndDateOfEnquiry());
			} else {
				args.put("endDateOfEnquiry", LocalDate.now().toString());
			}
			
		}
		
		if(!enquirySearch.getAdmissionStatus().isEmpty()) {
			whereClause.add(" admission_status = :admissionStatus ");
			args.put("admissionStatus", enquirySearch.getAdmissionStatus());
		}
		
		if(!enquirySearch.getGradeEnquiring().isEmpty()) {
			whereClause.add(" grade_enquiring = :gradeEnquiring ");
			args.put("gradeEnquiring", enquirySearch.getGradeEnquiring());
		}
		
		String searchQuery = searchQueryBuilder.append(String.join(" and ", whereClause)).toString();
		
		System.out.println(" args :: " + args.toString());
		
		return enquiryRepository.getEnqueriesBySearch(searchQuery, args, Enquiry.class);
	}
	
	public Enquiry findByEnquiryId(String enquiryId) {
		return (Enquiry) enquiryRepository.findById(enquiryId).get();
	}

	public List<FollowUp> getFollowUps(String enquiryId) {
		return followupRepository.findFollowUpsByEnquiryId(enquiryId);
	}

	public List<Sibling> getSiblings(String enquiryId) {
		return siblingRepository.findSiblingsByEnquiryId(enquiryId);
	}

	public FollowUp getFollowUp(String enquiryId, String followUpId) {
		return followupRepository.findFollowUpsByEnquiryIdAndFollowUpId(enquiryId, followUpId);
	}

	public void saveFollowUp(FollowUp followupform) {
		followupRepository.save(followupform);
		
	}

	public List<FollowUp> getFollowUpBySearch(FollowUp followUpSearch) {
		// TODO Auto-generated method stub
		StringBuilder searchQueryBuilder = new StringBuilder("select * from followup where ");
		List<String> whereClause = new ArrayList<String>();
		Map<String, Object> args = new HashMap<String, Object>();
		boolean isFollowUpDate = false;
		
		
		if(null != followUpSearch.getFollowUpDate() && !followUpSearch.getFollowUpDate().toString().isEmpty()) {
			whereClause.add(" followup_date >= :followUpDate ");
			args.put("followUpDate", followUpSearch.getFollowUpDate());
			isFollowUpDate = true;
		}
		
		if(null != followUpSearch.getNextFollowUpDate() && !followUpSearch.getNextFollowUpDate().toString().isEmpty()) {
			if(isFollowUpDate) {
				whereClause.add(" next_followup_date <= :nextFollowUpDate ");
			} else {
				whereClause.add(" next_followup_date >= :nextFollowUpDate ");
			}
			args.put("nextFollowUpDate", followUpSearch.getNextFollowUpDate());
		}
		
		
		String searchQuery = searchQueryBuilder.append(String.join(" and ", whereClause)).toString();
		
		System.out.println(" args :: " + args.toString());
		
		return followupRepository.getFollowUpsBySearch(searchQuery, args, FollowUp.class);
		
	}

}
