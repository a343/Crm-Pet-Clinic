package com.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crm.beans.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

	@Query("select p from Pet p where p.customer_id = ?1")
	List<Pet> getPetsByCustomer(int theId);

	@Query("select id, pet_type from pets_type")
	List<Object[]> getPetTypes();

}
