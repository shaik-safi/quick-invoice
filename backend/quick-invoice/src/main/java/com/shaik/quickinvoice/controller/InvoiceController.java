package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.repository.InvoiceRepository;
import com.shaik.quickinvoice.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping("invoice")
    public void addNewItem(@RequestBody Invoice invoice) {
    	invoiceRepository.save(invoice);
    }
}
