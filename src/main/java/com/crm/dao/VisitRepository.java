package com.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crm.beans.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

	@Query("Select v from Visit v where v.pet_id = ?1")
	List<Visit> getVisitsByPetID(int pet_id);

}
