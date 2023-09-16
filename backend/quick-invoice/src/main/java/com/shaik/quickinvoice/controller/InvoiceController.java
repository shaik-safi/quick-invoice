package com.shaik.quickinvoice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class InvoiceController {
	@Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyClientRepository companyClientRepository;

    @PostMapping("/add-invoice")
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice, @RequestParam Long companyId, @RequestParam Long clientId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        Optional<CompanyClient> clientOptional = companyClientRepository.findById(clientId);
        Company company = companyOptional.get();
        CompanyClient client = clientOptional.get();
        
        invoice.setCompany(company);
        invoice.setClient(client);

        Invoice savedInvoice = invoiceRepository.save(invoice);
        
        return ResponseEntity.ok(savedInvoice);
        }
    @RequestMapping("get-all-invoice")
	public ResponseEntity<Iterable<Invoice>> getAllInvoice() {
	    Iterable<Invoice> allCompany= invoiceRepository.findAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body(allCompany);
	}
}
