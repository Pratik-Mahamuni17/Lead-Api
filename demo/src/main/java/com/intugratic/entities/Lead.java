package com.intugratic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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