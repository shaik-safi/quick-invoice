package com.shaik.quickinvoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private String phone;
    private String email;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
