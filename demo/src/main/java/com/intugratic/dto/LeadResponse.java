package com.intugratic.dto;


import lombok.Data;
import java.util.List;

@Data
public class LeadResponse {

    private Long id;
    private String firstName;
    private String lastName;

    private String phone;
    private String secondaryPhone;
    private String email;

    private String leadStatus;
    private String priority;
    private String followUpDate;

    private List<AddressResponse> addresses;
}
