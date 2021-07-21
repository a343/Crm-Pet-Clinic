package com.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.beans.Visit;
import com.crm.dao.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {

	private VisitRepository visitRepository;

	@Override
	public void saveVisit(Visit visit) {
		visitRepository.save(visit);
	}

	@Override
	public List<Visit> getVisitsByPetID(int pet_id) {
		return visitRepository.getVisitsByPetID(pet_id);
	}

}
