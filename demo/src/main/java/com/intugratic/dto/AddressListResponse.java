package com.intugratic.dto;

import lombok.Data;

@Data
public class AddressListResponse {

    private String addressLine;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String siteVisit;
    private String siteVisitDate;
}
