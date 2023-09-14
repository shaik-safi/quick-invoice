package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;
import com.shaik.quickinvoice.repository.CompanyRepository;

@RestController
public class CompanyController {

	@Autowired
    private CompanyRepository companyRepository;
	
	@PostMapping("/addCompany")
	public void addNewCompany(@RequestBody Company company) {
		companyRepository.save(company);
	}
}
