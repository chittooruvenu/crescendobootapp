package com.crescendo.app.core.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.crescendo.app.core.vo.EnquirySearch;

@Controller
@RequestMapping("/enquiries")
public class EnquiryController {

	@Autowired
	private EnquiryManagementService enquiryService;

	@GetMapping("/new")
	public String indexPage(@ModelAttribute("enquiryForm") Enquiry enquiryForm, Model model) {
		model.addAttribute("createOrupdate","Create");
		return "enquiryform";
	}

	@PostMapping("/create")
	public ModelAndView createEnquiry(@Valid @ModelAttribute("enquiryForm") Enquiry enquiryForm, BindingResult result,
			@RequestParam("actionName") String actionName,
			@RequestParam(name = "siblingId", required = false) String siblingId) {

		ModelAndView modelAndView = new ModelAndView("enquiryform");
		modelAndView.addObject("createOrupdate","Create");

		if (result.hasErrors()) {
			return modelAndView;
		}

		List<Sibling> siblings = null;
		

		if (actionName.contains("Add Sibling")) {
			if (enquiryForm.getSiblings() != null) {
				siblings = enquiryForm.getSiblings();
			} else {
				siblings = new ArrayList<Sibling>();
			}
			siblings.add(new Sibling());
			enquiryForm.setSiblings(siblings);
			return modelAndView;
		}

		if (actionName.contains("Delete Sibling")) {
			if (enquiryForm.getSiblings().size() > 0) {

				enquiryForm.getSiblings().remove(Integer.parseInt(siblingId));
			}
			return modelAndView;
		}

		if (actionName.contains("Add Followup")) {
			List<FollowUp> followups = new ArrayList<>();
			followups.add(new FollowUp());
			enquiryForm.setFollowUps(followups);
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

	@GetMapping("/searchenquiries")
	public String enquirySearch(@ModelAttribute("enquirySearch") EnquirySearch enquirySearch) {
		return "searchenquiries";
	}

	@PostMapping("/viewsearchenquiries")
	public ModelAndView searchEnqueries(@ModelAttribute("enquirySearch") EnquirySearch enquirySearch,
			BindingResult result) {
		ModelAndView enquiryModel = new ModelAndView();
		List<Enquiry> enquiries = enquiryService.getEnqueriesBySearch(enquirySearch);

		if (null != enquiries && enquiries.size() > 0) {
			enquiryModel.setViewName("viewenquiries");
			enquiryModel.addObject("viewEnquiries", enquiries);
		} else {
			enquiryModel.setViewName("nodatafound");
		}

		return enquiryModel;
	}

	// public ModelAndView getEnqueries(@ModelAttribute("viewEnquiries") Enquiry
	// enquiryForm)
	@GetMapping("/viewenquiries")
	public ModelAndView getEnqueries() {
		List<Enquiry> enquiries = enquiryService.getEnqueries();
		ModelAndView enquiryModel = new ModelAndView("viewenquiries");

		if (null != enquiries && enquiries.size() > 0) {
			enquiryModel.setViewName("viewenquiries");
			enquiryModel.addObject("viewEnquiries", enquiries);
		} else {
			enquiryModel.setViewName("nodatafound");
		}

		return enquiryModel;
	}

	@GetMapping("/updateEnquiry/{enquiryId}")
	public ModelAndView updateEnqueries(@PathVariable String enquiryId,
			@ModelAttribute("enquiryForm") Enquiry enquiryForm) {
		Enquiry enquiry = enquiryService.findByEnquiryId(enquiryId);
		ModelAndView enquiryModel = new ModelAndView("enquiryform");
		enquiryModel.addObject("enquiryForm", enquiry);
		enquiryModel.addObject("createOrupdate","Update");
		return enquiryModel;
	}

	@GetMapping("/followups/{enquiryId}")
	public ModelAndView getFollowUps(@PathVariable String enquiryId) {
		List<FollowUp> followups = enquiryService.getFollowUps(enquiryId);
		ModelAndView followUpModel = new ModelAndView();

		if (null != followups && followups.size() > 0) {
			followUpModel.setViewName("viewfollowups");
			followUpModel.addObject("viewfollowups", followups);
		} else {
			followUpModel.setViewName("nodatafound");
		}

		followUpModel.addObject("viewfollowups", followups);
		return followUpModel;
	}

	@GetMapping("/siblings/{enquiryId}")
	public ModelAndView getSiblings(@PathVariable String enquiryId) {
		List<Sibling> siblings = enquiryService.getSiblings(enquiryId);
		ModelAndView siblingsModel = new ModelAndView("viewsiblings");
		siblingsModel.addObject("viewsiblings", siblings);
		return siblingsModel;
	}

	@GetMapping("/followupform/{enquiryId}/{followUpId}")
	public ModelAndView updateFollowUp(@PathVariable String enquiryId, @PathVariable String followUpId,
			@ModelAttribute("followupform") FollowUp followupform) {
		FollowUp followup = enquiryService.getFollowUp(enquiryId, followUpId);
		ModelAndView followupModel = new ModelAndView("savefollowup");
		followupModel.addObject("followupform", followup);
		return followupModel;
	}

	@GetMapping("/followupform/{enquiryId}")
	public ModelAndView createFollowUp(@PathVariable String enquiryId,
			@ModelAttribute("followupform") FollowUp followupform) {
		FollowUp followup = new FollowUp();
		Enquiry enquiry = enquiryService.findByEnquiryId(enquiryId);
		followup.setEnquiries(enquiry);
		ModelAndView followupModel = new ModelAndView("savefollowup");
		followupModel.addObject("followupform", followup);
		return followupModel;
	}

	@PostMapping("/savefollowup")
	public String saveFollowUp(@ModelAttribute("followupform") FollowUp followupform) {
		enquiryService.saveFollowUp(followupform);
		return "redirect:followups/" + followupform.getEnquiries().getEnquiryId();
	}

	@GetMapping("/searchefollowps")
	public String followUpSearchRedirect(@ModelAttribute("searchfollowup") FollowUp followupform) {
		return "searchefollowps";
	}

	@PostMapping("/viewsearchfollowups")
	public ModelAndView followUpSearch(@ModelAttribute("viewfollowups") FollowUp followUpSearch, BindingResult result) {
		ModelAndView enquiryModel = new ModelAndView();
		List<FollowUp> followUps = enquiryService.getFollowUpBySearch(followUpSearch);

		if (null != followUps && followUps.size() > 0) {
			enquiryModel.setViewName("viewfollowups");
			enquiryModel.addObject("viewfollowups", followUps);
		} else {
			enquiryModel.setViewName("nodatafound");
		}

		return enquiryModel;
	}

}
