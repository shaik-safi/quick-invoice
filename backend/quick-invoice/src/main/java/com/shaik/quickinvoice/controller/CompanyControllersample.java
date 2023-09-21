package com.shaik.quickinvoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;
import com.shaik.quickinvoice.model.Sample;
import com.shaik.quickinvoice.repository.CompanyRepository;

//@RestController
public class CompanyControllersample {

	@Autowired
    private CompanyRepository companyRepository;
	
	@PostMapping("add-company")
	public ResponseEntity<Company> addNewCompany(@RequestBody Company company) {
	    System.out.println("Received company object: " + company);
	    companyRepository.save(company);
	    return ResponseEntity.status(HttpStatus.CREATED).body(company);
	}
	
	@RequestMapping("get-all-company")
	public ResponseEntity<List<Company>> getAllCompany() {
	    List<Company> allCompany= companyRepository.findAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body(allCompany);
	}
	
	@RequestMapping("get-companyid")
	public Long getCompanyIdByName(@RequestBody String name) {
		  Company company = companyRepository.findBycompanyName(name);
		  if (company != null) {
		    return company.getId();
		  } else {
		    return null;
		  }
		}

}
