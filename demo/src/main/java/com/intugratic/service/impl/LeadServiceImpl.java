package com.intugratic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.intugratic.dto.*;
import com.intugratic.entities.Address;
import com.intugratic.entities.Lead;
import com.intugratic.repositories.LeadRepository;
import com.intugratic.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;

    public LeadServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    // ================= SAVE LEAD =================
    @Override
    public LeadResponse saveLead(LeadRequest req) {

        Lead lead = new Lead();
        lead.setFirstName(req.getFirstName());
        lead.setLastName(req.getLastName());
        lead.setPhone(req.getPhone());
        lead.setSecondaryPhone(req.getSecondaryPhone());
        lead.setEmail(req.getEmail());
        lead.setLeadStatus(req.getLeadStatus());
        lead.setPriority(req.getPriority());
        lead.setFollowUpDate(req.getFollowUpDate());

        List<Address> addressList = new ArrayList<>();

        req.getAddresses().forEach(a -> {
            Address address = new Address();
            address.setAddressLine(a.getAddressLine());
            address.setStreet(a.getStreet());
            address.setCity(a.getCity());
            address.setState(a.getState());
            address.setZipCode(a.getZipCode());
            address.setCountry(a.getCountry());
            address.setSiteVisit(a.getSiteVisit());
            address.setSiteVisitDate(a.getSiteVisitDate());
            address.setLead(lead);
            addressList.add(address);
        });

        lead.setAddresses(addressList);

        Lead savedLead = leadRepository.save(lead);
        return mapToResponse(savedLead);
    }

    // ================= GET ALL LEADS (PROJECTION + DTO) =================
    @Override
    public List<LeadFullResponse> getAllLeads() {

        return leadRepository.findAllBy()
                .stream()
                .map(lead -> {

                    List<AddressListResponse> addressList =
                            lead.getAddresses()
                                    .stream()
                                    .map(addr -> {
                                        AddressListResponse ar = new AddressListResponse();
                                        ar.setAddressLine(addr.getAddressLine());
                                        ar.setStreet(addr.getStreet());
                                        ar.setCity(addr.getCity());
                                        ar.setState(addr.getState());
                                        ar.setZipCode(addr.getZipCode());
                                        ar.setCountry(addr.getCountry());
                                        ar.setSiteVisit(addr.getSiteVisit());
                                        ar.setSiteVisitDate(addr.getSiteVisitDate());
                                        return ar;
                                    })
                                    .toList();

                    return new LeadFullResponse(
                            lead.getId(),
                            lead.getFirstName(),
                            lead.getLastName(),
                            lead.getPhone(),
                            lead.getSecondaryPhone(),
                            lead.getEmail(),
                            lead.getLeadStatus(),
                            lead.getPriority(),
                            lead.getFollowUpDate(),
                            addressList
                    );
                })
                .toList();
    }

    // ================= PAGINATED LEADS =================
    @Override
    public Page<LeadResponse> getPaginatedLeads(int page, int size, String keyword) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Lead> pageResult;

        if (keyword == null || keyword.trim().isEmpty()) {
            pageResult = leadRepository.findAllWithAddresses(pageable);
        } else {
            pageResult = leadRepository.searchWithPagination(keyword, pageable);
        }

        return pageResult.map(this::mapToResponse);
    }

    // ================= MAPPER =================
    private LeadResponse mapToResponse(Lead lead) {

        LeadResponse response = new LeadResponse();
        response.setId(lead.getId());
        response.setFirstName(lead.getFirstName());
        response.setLastName(lead.getLastName());
        response.setPhone(lead.getPhone());
        response.setSecondaryPhone(lead.getSecondaryPhone());
        response.setEmail(lead.getEmail());
        response.setLeadStatus(lead.getLeadStatus());
        response.setPriority(lead.getPriority());
        response.setFollowUpDate(lead.getFollowUpDate());

        List<AddressResponse> addressResponses = lead.getAddresses()
                .stream()
                .map(a -> {
                    AddressResponse ar = new AddressResponse();
                    ar.setId(a.getId());
                    ar.setAddressLine(a.getAddressLine());
                    ar.setStreet(a.getStreet());
                    ar.setCity(a.getCity());
                    ar.setState(a.getState());
                    ar.setZipCode(a.getZipCode());
                    ar.setCountry(a.getCountry());
                    ar.setSiteVisit(a.getSiteVisit());
                    ar.setSiteVisitDate(a.getSiteVisitDate());
                    return ar;
                })
                .toList();

        response.setAddresses(addressResponses);
        return response;
    }
}
