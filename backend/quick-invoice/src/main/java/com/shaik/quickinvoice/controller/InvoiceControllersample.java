package com.shaik.quickinvoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.repository.CompanyClientRepository;
import com.shaik.quickinvoice.repository.CompanyRepository;
import com.shaik.quickinvoice.repository.InvoiceRepository;
import com.shaik.quickinvoice.service.InvoiceService;

import jakarta.persistence.EntityManager;

//@RestController
public class InvoiceControllersample {
	@Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyClientRepository companyClientRepository;
    @Autowired
    private EntityManager entityManager;

    @PostMapping("/add-invoice")
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice,@RequestParam Long clientId) {
        Optional<CompanyClient> clientOptional = companyClientRepository.findById(clientId);
        CompanyClient client = clientOptional.get();
        invoice.setClient(client);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        
        return ResponseEntity.ok(savedInvoice);
        }
    @RequestMapping("get-all-invoice")
	public ResponseEntity<Iterable<Invoice>> getAllInvoice() {
	    Iterable<Invoice> allCompany= invoiceRepository.findAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body(allCompany);
	}
    @GetMapping("/get-clientid")
    public ResponseEntity<Long> getInvoiceId(@RequestParam String clientName) {
        Iterable<CompanyClient> companyClients = companyClientRepository.findByClientName(clientName);
        for (CompanyClient companyClient : companyClients) {
            Long clientId = companyClient.getClientId();
            return ResponseEntity.ok(clientId);
        }
        return ResponseEntity.notFound().build();
    }
    
}