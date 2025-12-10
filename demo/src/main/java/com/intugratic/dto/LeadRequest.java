package com.intugratic.dto;

import lombok.Data;

@Data
public class LeadRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String secondaryPhone;
    private String email;
    private String leadStatus;
    private String priority;
    private String followUpDate;

    private String address;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    private String siteVisit;
    private String siteVisitDate;
}
