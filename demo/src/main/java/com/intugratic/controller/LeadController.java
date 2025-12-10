package com.intugratic.controller;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.intugratic.dto.LeadRequest;
import com.intugratic.dto.LeadResponse;
import com.intugratic.service.LeadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/leads")
public class LeadController {

	private final LeadService leadService;

	public LeadController(LeadService leadService) {
	    this.leadService = leadService;
	}

	@PostMapping("/create")
	public ResponseEntity<LeadResponse> createLead(@Valid @RequestBody LeadRequest req) {
		// call save method
		LeadResponse saved = leadService.saveLead(req);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("getall")
	public ResponseEntity<List<LeadResponse>> getAllLeads() {
		List<LeadResponse> leads = leadService.getAllLeads();
		return ResponseEntity.ok(leads);
	}

	@GetMapping("/paged")
	public ResponseEntity<Page<LeadResponse>> getPaginated(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, 
			@RequestParam(required = false) String keyword) 
	{
		Page<LeadResponse> leads = leadService.getPaginatedLeads(page, size, keyword);
		return ResponseEntity.ok(leads);
	}

}