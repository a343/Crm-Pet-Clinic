package com.crm.service;

import java.util.List;

import com.crm.beans.Visit;

public interface VisitService {
	
	public void saveVisit(Visit visit);

	List<Visit> getVisitsByPetID(int pet_id);

}
