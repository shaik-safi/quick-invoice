package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.service.InvoiceService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/add")
    public ResponseEntity<String> addInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.add(invoice);
        if (savedInvoice != null) {
            return ResponseEntity.ok("Invoice saved");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Invoice>> findAllInvoices() {
        List<Invoice> allInvoices = invoiceService.findAll();
        return ResponseEntity.ok(allInvoices);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Invoice>> findInvoiceById(@RequestParam Long id) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find-by-event-id")
    public ResponseEntity<Optional<Invoice>> findInvoiceByEventId(@RequestParam Long id) {
        Optional<Invoice> invoice = invoiceService.findInvoiceByEventId(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/exists-by-id")
    public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
        boolean invoiceExists = invoiceService.existsById(id);
        return ResponseEntity.ok(invoiceExists);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        boolean invoiceDeleted = invoiceService.deleteById(id);
        if (invoiceDeleted) {
            return ResponseEntity.ok("Deleted Invoice");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-by-invoice")
    public ResponseEntity<String> deleteByInvoice(@RequestBody Invoice invoice) {
        boolean invoiceDeleted = invoiceService.deleteInvoice(invoice);
        if (invoiceDeleted) {
            return ResponseEntity.ok("Deleted Invoice");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        long count = invoiceService.count();
        return ResponseEntity.ok(count);
    }
}
