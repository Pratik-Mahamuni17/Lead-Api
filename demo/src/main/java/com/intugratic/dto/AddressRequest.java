package com.intugratic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressRequest {

    @NotBlank(message = "Address line is required")
    private String addressLine;

    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zipcode is required")
    private String zipCode;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Site Visit is required")
    private String siteVisit;

    private String siteVisitDate;
}
