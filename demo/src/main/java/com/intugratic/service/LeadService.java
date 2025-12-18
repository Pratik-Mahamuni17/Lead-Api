package com.intugratic.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.intugratic.dto.*;

public interface LeadService {

    LeadResponse saveLead(LeadRequest req);

    List<LeadFullResponse> getAllLeads();

    Page<LeadResponse> getPaginatedLeads(int page, int size, String keyword);
}
