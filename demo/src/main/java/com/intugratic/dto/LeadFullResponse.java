package com.intugratic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LeadFullResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String secondaryPhone;
    private String email;
    private String leadStatus;
    private String priority;
    private String followUpDate;
    private List<AddressListResponse> addresses;
}
