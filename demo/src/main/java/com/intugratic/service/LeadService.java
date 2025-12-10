package com.intugratic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.intugratic.dto.LeadRequest;
import com.intugratic.entities.Lead;
import com.intugratic.repositories.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
    private LeadRepository leadRepository;
	
	
	public Lead saveLead(LeadRequest req) {

        Lead lead = new Lead();

        lead.setFirstName(req.getFirstName());
        lead.setLastName(req.getLastName());
        lead.setPhone(req.getPhone());
        lead.setSecondaryPhone(req.getSecondaryPhone());
        lead.setEmail(req.getEmail());
        lead.setLeadStatus(req.getLeadStatus());
        lead.setPriority(req.getPriority());
        lead.setFollowUpDate(req.getFollowUpDate());

        lead.setAddress(req.getAddress());
        lead.setStreet(req.getStreet());
        lead.setCity(req.getCity());
        lead.setState(req.getState());
        lead.setZipCode(req.getZipCode());
        lead.setCountry(req.getCountry());

        lead.setSiteVisit(req.getSiteVisit());
        lead.setSiteVisitDate(req.getSiteVisitDate());

        return leadRepository.save(lead);
    }
	
	
	public List<Lead> getAllLeads() {
	    return leadRepository.findAll();
	}
	
	public Page<Lead> getPaginatedLeads(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return leadRepository.findAll(pageable);
	}
	
	public Lead getLeadById(Long id) {
	    return leadRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
	}



}
