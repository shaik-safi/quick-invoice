package com.shaik.quickinvoice.controller;

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

import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.model.InvoiceDetails;
import com.shaik.quickinvoice.repository.InvoiceDetailsRepository;
import com.shaik.quickinvoice.repository.InvoiceRepository;

@RestController
public class InvoiceDetailsController {
	@Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping("/add-invoice-details")
    public ResponseEntity<InvoiceDetails> addInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails, @RequestParam Long invoiceId) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
            Invoice invoice = invoiceOptional.get();
            int totalCost = invoice.getTotalCost() +( invoiceDetails.getUnitPrice()*invoiceDetails.getQuantity());
            invoice.setTotalCost(totalCost);
            invoiceDetails.setInvoice(invoice);

            InvoiceDetails savedInvoiceDetails = invoiceDetailsRepository.save(invoiceDetails);
            
            return ResponseEntity.ok(savedInvoiceDetails);
        }
    @RequestMapping("get-all-invoice-details")
	public ResponseEntity<Iterable<InvoiceDetails>> getAllInvoice() {
	    Iterable<InvoiceDetails> allCompany= invoiceDetailsRepository.findAll();
	    return ResponseEntity.status(HttpStatus.CREATED).body(allCompany);
	}
    @GetMapping("/get-invoiceid")
    public ResponseEntity<Long> getInvoiceId(@RequestParam String invoiceNumber) {
        Iterable<Invoice> invoices = invoiceRepository.findByInvoiceNumber(invoiceNumber);

        for (Invoice invoice : invoices) {
            Long invoiceId = invoice.getInvoiceId(); 
            return ResponseEntity.ok(invoiceId);
        }
        
        return ResponseEntity.notFound().build();
    }
    }

