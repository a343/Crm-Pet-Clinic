package com.crm.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.beans.Pet;
import com.crm.dao.PetRepository;

@Service
public class PetServiceImpl implements PetService {

	private PetRepository petRepository;

	@Override
	public void savePet(Pet thePet) {

		petRepository.save(thePet);
	}

	@Override
	public LinkedHashMap<Integer, String> getPetTypes() {

		LinkedHashMap<Integer, String> petTpes = new LinkedHashMap<>();
		List<Object[]> petTypesResult = petRepository.getPetTypes();

		for (Object[] petType : petTypesResult) {
			petTpes.put((Integer) petType[0], (String) petType[1]);
		}

		return petTpes;
	}

	@Override
	public List<Pet> getPetsByCustomer(int theId) {
		return petRepository.getPetsByCustomer(theId);
	}

	@Override
	public void deletePet(int theId) {
		petRepository.delete(petRepository.findById(theId).orElse(null));
	}

}
