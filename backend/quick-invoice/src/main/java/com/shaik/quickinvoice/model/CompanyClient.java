package com.shaik.quickinvoice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CompanyClient {

    @Id
    private Long id;
    private String clientName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private String postalCode;
    private String country;
}
