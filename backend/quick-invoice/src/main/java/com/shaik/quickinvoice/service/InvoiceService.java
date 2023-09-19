package com.shaik.quickinvoice.service;
 
 import java.util.List;
import java.util.Optional;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.model.Company;
import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.model.CustomResponse;
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.model.InvoiceDetails;
import com.shaik.quickinvoice.repository.CompanyClientRepository;
import com.shaik.quickinvoice.repository.CompanyRepository;
import com.shaik.quickinvoice.repository.InvoiceDetailsRepository;
import com.shaik.quickinvoice.repository.InvoiceRepository;
 
 @Service
 public class InvoiceService {
     @Autowired
     private CompanyClientRepository companyClientRepository;
     @Autowired
     private InvoiceRepository invoiceRepository;
     @Autowired
     private InvoiceDetailsRepository invoiceDetailsRepository;
     @Autowired
     private CompanyRepository companyRepository;

     public CustomResponse getInvoiceDetails(String companyName, String clientName) {
    	 Company company = companyRepository.findBycompanyName(companyName);
         CompanyClient companyClient = companyClientRepository.findOneByClientName(clientName);
         System.out.println(companyClient.toString());
         Optional<Invoice> optionalInvoice = invoiceRepository.findByClientClientId(companyClient.getClientId());
         Invoice invoice = null;
         if (optionalInvoice.isPresent()) {
             invoice = optionalInvoice.get();
             System.out.println(invoice.toString());
         } else {
        	 System.out.println("No");
         }
         List<InvoiceDetails> invoices = invoiceDetailsRepository.findByInvoiceInvoiceId(invoice.getInvoiceId());

         return new CustomResponse(company, companyClient, invoice, invoices);
     }
 }