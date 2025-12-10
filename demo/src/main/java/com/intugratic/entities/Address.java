package com.intugratic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lead_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressLine;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    private String siteVisit;
    private String siteVisitDate;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;
}

