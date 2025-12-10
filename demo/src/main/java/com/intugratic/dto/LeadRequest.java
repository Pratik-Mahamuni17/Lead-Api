package com.intugratic.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LeadRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    private String secondaryPhone;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Lead status is required")
    private String leadStatus;

    @NotBlank(message = "Priority is required")
    private String priority;

    @NotBlank(message = "Follow-up date is required")
    private String followUpDate;

    @NotEmpty(message = "Address list cannot be empty")
    private List<AddressRequest> addresses;
}
