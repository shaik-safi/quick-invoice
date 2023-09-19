package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.model.CustomResponse;
import com.shaik.quickinvoice.service.InvoiceService;

@RestController
public class AllDetailsController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/get-invoice")
    public ResponseEntity<CustomResponse> getInvoice(@RequestParam String companyName, @RequestParam String clientName) {
        CustomResponse response = invoiceService.getInvoiceDetails(companyName,clientName);
        
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
