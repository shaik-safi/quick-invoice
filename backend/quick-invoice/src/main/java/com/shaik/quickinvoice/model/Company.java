package com.shaik.quickinvoice.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Company {

	@Id
	private Long id;
	private String companyName;
    private String phone;
    private String email;
	private String city;
    private String street;
    private String zipCode;
    private String country;
    
    @OneToMany
    Set<CompanyClient> companyClients;
}
