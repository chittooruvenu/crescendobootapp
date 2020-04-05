package com.crescendo.app.core.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crescendo.app.core.components.Enquiry;
import com.crescendo.app.core.components.FollowUp;
import com.crescendo.app.core.components.Sibling;
import com.crescendo.app.core.services.EnquiryManagementService;

@Controller
@RequestMapping("/enquiries")
public class EnquiryController {

	@Autowired
	private EnquiryManagementService enquiryService;
	@Autowired
	private Validator validator;

	@GetMapping("/new")
	public String indexPage(@ModelAttribute("enquiryForm") Enquiry enquiryForm) {
		return "enquiryform";
	}

	@PostMapping("/create")
	public ModelAndView createEnquiry(@ModelAttribute("enquiryForm") Enquiry enquiryForm,
			@RequestParam("actionName") String actionName, BindingResult result) {
		
		List<Sibling> siblings = null;
		ModelAndView modelAndView = new ModelAndView("enquiryform");
		modelAndView.addObject("enquiryForm", enquiryForm);
		
		if (actionName.contains("Add Sibling")) {
			if (enquiryForm.getSiblings() != null) {
				siblings = enquiryForm.getSiblings();
			} else {
				siblings = new ArrayList<Sibling>();
				siblings.add(new Sibling());
			}
			enquiryForm.setSiblings(siblings);
			return modelAndView;
		}

		if (actionName.contains("Add Followup")) {
			List<FollowUp> followups = new ArrayList<>();
			followups.add(new FollowUp());
			enquiryForm.setFollowUps(followups);
			return modelAndView;
		}
		
		Set<ConstraintViolation<Enquiry>> violations = validator.validate(enquiryForm);
	     
	    for (ConstraintViolation<Enquiry> violation : violations) 
	    {
	        String propertyPath = violation.getPropertyPath().toString();
	        String message = violation.getMessage();
	        // Add JSR-303 errors to BindingResult
	        // This allows Spring to display them in view via a FieldError
	        result.addError(new FieldError("enquiryForm",propertyPath,
	 
	                               "Invalid "+ propertyPath + "(" + message + ")"));
	    }
		
		if(result.hasErrors()){
			return modelAndView;
		}

		modelAndView = new ModelAndView("enquirysuccess");
		enquiryService.create(enquiryForm);
		return modelAndView;
	}

	@GetMapping("/viewenquiries/{enquiryId}")
	public String findByEnquiryId(@PathVariable String enquiryId, Model m) {
		Enquiry enquiry = enquiryService.findByEnquiryId(enquiryId);
		List<Enquiry> enquiries = new ArrayList<Enquiry>();
		enquiries.add(enquiry);
		m.addAttribute("enquiries", enquiries);
		return "viewenquiries";
	}

	@GetMapping("/viewenquiries")
	public ModelAndView getEnqueries(@ModelAttribute("enquiryForm") Enquiry enquiryForm) {
		List<Enquiry> enquiries = enquiryService.getEnqueries();
		ModelAndView enquiryModel = new ModelAndView("viewenquiries");
		enquiryModel.addObject("enquiries", enquiries);
		return enquiryModel;
	}

	/*
	 * @GetMapping("/addSibling") public String
	 * addSiblings(@ModelAttribute("enquiryForm") Enquiry enquiryForm){
	 * List<Sibling> siblings=new ArrayList<Sibling>(); siblings.add(new Sibling());
	 * enquiryForm.setSiblings(siblings); return "enquiryform"; }
	 */

}
