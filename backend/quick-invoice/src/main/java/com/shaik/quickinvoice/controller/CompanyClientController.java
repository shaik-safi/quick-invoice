package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;
import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.repository.CompanyClientRepository;
import com.shaik.quickinvoice.repository.CompanyRepository;

@RestController
public class CompanyClientController {

	@Autowired
    private CompanyClientRepository companyClientRepository;
	
	@PostMapping("/addCompanyClient")
	public void addNewCompanyClient(@RequestBody CompanyClient companyClient) {
		companyClientRepository.save(companyClient);
	}
}
