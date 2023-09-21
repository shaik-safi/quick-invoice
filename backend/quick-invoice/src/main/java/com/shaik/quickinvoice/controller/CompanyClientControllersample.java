package com.shaik.quickinvoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;
import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.repository.CompanyClientRepository;
import com.shaik.quickinvoice.repository.CompanyRepository;

//@RestController
public class CompanyClientControllersample {

    @Autowired
    private CompanyClientRepository companyClientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/add-client")
    public ResponseEntity<CompanyClient> addCompanyClient(@RequestBody CompanyClient companyClient) {
            CompanyClient savedClient = companyClientRepository.save(companyClient);
            return ResponseEntity.ok(savedClient);
    }
    @RequestMapping("get-all-client")
	public ResponseEntity<Iterable<CompanyClient>> getAllClient() {
	    Iterable<CompanyClient> allCompany= companyClientRepository.findAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body(allCompany);
	}
    
//    @GetMapping("/get-invoice")
//    public ResponseEntity<CompanyClient> getInvoice(@RequestParam String clientName) {
//        Iterable<CompanyClient> companyClients = companyClientRepository.findByClientName(clientName);
//        for (CompanyClient companyClient : companyClients) {
//            return ResponseEntity.ok(companyClient);
//        }
//        return ResponseEntity.notFound().build();
//    }

}
