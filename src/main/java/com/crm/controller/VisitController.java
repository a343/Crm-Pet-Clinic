package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.beans.Pet;
import com.crm.beans.Visit;
import com.crm.service.VisitService;

@Controller
@RequestMapping("/visit")
public class VisitController {

	// need to inject our customer service
	@Autowired
	private VisitService visitService;

	@PostMapping("/showFormForAddVisit")
	public String showFormForAddVisit(@ModelAttribute("pet") Pet pet,  BindingResult result, Model theModel) {

		System.out.println("Pet " + pet.toString());
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("pet_id", pet.getPet_id());
		theModel.addAttribute("visit", new Visit());

		// send over to our form
		return "visit-form";
	}

	@PostMapping("/saveVisit")
	public String saveVisit(@ModelAttribute("visit") Visit theVisit) {

		System.out.println("visit " + theVisit.toString());

		visitService.saveVisit(theVisit);

		// send over to our form
		return "redirect:/visit/showListVisits?pet_id=" + theVisit.getPet().getPet_id();
	}

	@GetMapping("/showListVisits")
	public String showListVisits(@RequestParam("pet_id") int pet_id, Model theModel) {

		System.out.println("--->>>>showListVisits<<<<<----");

		List<Visit> visits = visitService.getVisitsByPetID(pet_id);
		// add the customers to the model
		theModel.addAttribute("visits", visits);

		return "list-visits";
	}

	
	
}
