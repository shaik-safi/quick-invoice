package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shaik.quickinvoice.entity.BillData;
import com.shaik.quickinvoice.service.InvoiceService;

@RestController
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("sam")
    public void addNewItem(@RequestBody BillData billData) {
        invoiceService.output(billData);
    }
}
