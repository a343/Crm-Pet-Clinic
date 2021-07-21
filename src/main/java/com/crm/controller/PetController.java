package com.crm.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.beans.Customer;
import com.crm.beans.Pet;
import com.crm.service.PetService;

@Controller
@RequestMapping("/pet")
public class PetController {

	// need to inject our customer service
	@Autowired
	private PetService petService;

	private LinkedHashMap<Integer, String> petTypes;

	@PostConstruct
	protected void loadRoles() {

		petTypes = petService.getPetTypes();

	}

	@GetMapping("/showListPets")
	public String showListPets(@RequestParam("customerId") int theId, Model theModel) {

		// get customers from the service
		List<Pet> thePets = petService.getPetsByCustomer(theId);

		// System.out.println("Pet : " +thePets.get(0).toString());

		// add the customers to the model
		theModel.addAttribute("pets", thePets);

		return "list-pets";
	}

	@PostMapping("/showFormForAddPet")
	public String showFormForAddPet(@ModelAttribute("customer") Customer customer, Model theModel) {
		System.out.println("The ID ------>>>>>>> " + customer.getId());
		theModel.addAttribute("pet", new Pet());
		theModel.addAttribute("customer_id", customer.getId());

		// add roles to the model for form display
		theModel.addAttribute("petTypes", petTypes);

		// send over to our form
		return "pet-form";
	}

	@PostMapping("/savePets")
	public String savePets(@ModelAttribute("pet") Pet thePet) {

		System.out.println("New Pet " + thePet.toString());

		String value = petTypes.get(thePet.getPet_type().getPet_id());

		thePet.getPet_type().setType(value);
		// save the customer using our service
		petService.savePet(thePet);

		return "redirect:/pet/showListPets?customerId=" + thePet.getOwner().getId();
	}

	@GetMapping("/delete")
	public String deletePet(@RequestParam("pet_id") int theId, @RequestParam("customer_id") int customer_id) {

		// delete the customer
		petService.deletePet(theId);

		return "redirect:/pet/showListPets?customerId=" + customer_id;
	}

}
