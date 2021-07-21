package com.crm.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.crm.beans.Pet;

public interface PetService {

	public void savePet(Pet thePet);
	public LinkedHashMap<Integer, String> getPetTypes();
	public List<Pet> getPetsByCustomer(int theId);
	public void deletePet(int theId);
}
