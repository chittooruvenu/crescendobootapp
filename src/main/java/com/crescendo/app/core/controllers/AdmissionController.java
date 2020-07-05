package com.crescendo.app.core.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import com.crescendo.app.core.components.Enquiry;
import com.crescendo.app.core.components.admission.Admission;
import com.crescendo.app.core.services.AdmissionService;
import com.crescendo.app.core.services.EnquiryManagementService;
import com.crescendo.app.core.vo.AdmissionSearch;

@Controller
@RequestMapping("/admissions")
public class AdmissionController {
	
	@Autowired
	private AdmissionService admissionService;
	
	@Autowired
	private EnquiryManagementService enquiryService;

	
	@GetMapping("/new/{enquiryId}")
	public String indexPage(@ModelAttribute("admissionForm") Admission admissionForm, BindingResult result, Model model, @PathVariable String enquiryId) {
		
		model.addAttribute("createOrupdate","Create");
		admissionForm = admissionService.populateCommonDetailsFromEnquiry(admissionForm, enquiryId);
		
		return "createadmission";
	}
	
	@PostMapping("/create")
	public ModelAndView createAdmission(@Valid @ModelAttribute("admissionForm") Admission admissionForm, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView("admissionForm");
		Enquiry enquiryToUpdate = enquiryService.findByEnquiryId(admissionForm.getEnquiryId());

		if (result.hasErrors()) {
			return modelAndView;
		}
		
		modelAndView = new ModelAndView("admissionsuccess");
		String admissionNumber = admissionService.create(admissionForm);
		
		if(null != admissionNumber && !admissionNumber.isEmpty()) {
			enquiryToUpdate.setAdmissionStatus("Active");
			enquiryService.create(enquiryToUpdate);
		}
		
		modelAndView.addObject("createOrupdate","Create");
		modelAndView.addObject("admissionNumber", admissionNumber);
		modelAndView.addObject("childName", admissionForm.getChildName());
		
		return modelAndView;
	}
	
	@GetMapping("/searchadmissions")
	public String admissionSearch(@ModelAttribute("admissionSearch") AdmissionSearch admissionSearch) {
		return "searchadmissions";
	}

	@PostMapping("/viewadmissions")
	public ModelAndView searchEnqueries(@ModelAttribute("admissionSearch") AdmissionSearch admissionSearch,
			BindingResult result) {
		ModelAndView admissionModel = new ModelAndView();
		List<Admission> admissions = admissionService.getAdmissionsBySearch(admissionSearch);

		if (null != admissions && admissions.size() > 0) {
			admissionModel.setViewName("viewadmissions");
			admissionModel.addObject("viewAdmissions", admissions);
		} else {
			admissionModel.setViewName("nodatafound");
		}

		return admissionModel;
	}
	
	@GetMapping("/updateAdmission/{admissionNumber}")
	public ModelAndView updateAdmission(@PathVariable String admissionNumber,
			@ModelAttribute("admissionForm") Enquiry enquiryForm) {
		Admission admission = admissionService.findByAdmissionNumber(admissionNumber);
		ModelAndView enquiryModel = new ModelAndView("createadmission");
		enquiryModel.addObject("admissionForm", admission);
		enquiryModel.addObject("createOrupdate","Update");
		return enquiryModel;
	}
	
}
