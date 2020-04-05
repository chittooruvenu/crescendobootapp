package com.crescendo.app.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.app.core.components.Enquiry;
import com.crescendo.app.core.components.FollowUp;
import com.crescendo.app.core.components.Sibling;
import com.crescendo.app.core.repository.EnquiryRepository;
import com.crescendo.app.core.repository.FollowUpRepository;
import com.crescendo.app.core.repository.SiblingRepository;


@Service
public class EnquiryManagementService {

	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	SiblingRepository siblingRepository;
	
	@Autowired
	FollowUpRepository followupRepository;

	public void create(Enquiry enquiry) {
		// TODO Auto-generated method stub
		List<Sibling> siblings = enquiry.getSiblings();
		List<FollowUp> followUps = enquiry.getFollowUps();
		
		for(Sibling sibling : siblings){
			sibling.setEnquiries(enquiry);
		}
		
		for(FollowUp followup : followUps){
			followup.setEnquiries(enquiry);
		}
				
		enquiryRepository.save(enquiry);
		
	}

	public List<Enquiry> getEnqueries() {
		// TODO Auto-generated method stub
		return enquiryRepository.findAll();
	}
	
	public Enquiry findByEnquiryId(String enquiryId) {
		// TODO Auto-generated method stub
		return (Enquiry) enquiryRepository.findById(enquiryId).get();
	}

}
