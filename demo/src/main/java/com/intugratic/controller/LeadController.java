package com.intugratic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.intugratic.dto.LeadRequest;
import com.intugratic.entities.Lead;
import com.intugratic.service.LeadService;


@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody LeadRequest req) {
        Lead savedLead = leadService.saveLead(req);
        return ResponseEntity.ok(savedLead);
    }
    
    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        List<Lead> leads = leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }
    
    @GetMapping("/paged")
    public ResponseEntity<Page<Lead>> getPaginatedLeads(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Lead> leads = leadService.getPaginatedLeads(page, size);
        return ResponseEntity.ok(leads);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        Lead lead = leadService.getLeadById(id);
        return ResponseEntity.ok(lead);
    }


}

