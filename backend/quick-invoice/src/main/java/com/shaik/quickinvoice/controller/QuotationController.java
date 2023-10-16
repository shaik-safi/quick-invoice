package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.shaik.quickinvoice.model.Quotation;
import com.shaik.quickinvoice.service.QuotationService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/quotation")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("/add")
    public ResponseEntity<String> addQuotation(@RequestBody Quotation quotation) {
        Quotation savedQuotation = quotationService.add(quotation);
        if (savedQuotation != null) {
            return ResponseEntity.ok("Quotation saved");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Quotation>> findAllQuotations() {
        List<Quotation> allQuotations = quotationService.findAll();
        return ResponseEntity.ok(allQuotations);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Quotation>> findQuotationById(@RequestParam Long id) {
        Optional<Quotation> quotation = quotationService.findById(id);
        if (quotation.isPresent()) {
            return ResponseEntity.ok(quotation);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find-by-event-id")
    public ResponseEntity<Optional<Quotation>> findQuotationByEventId(@RequestParam Long id) {
        Optional<Quotation> quotation = quotationService.findQuotationByEventId(id);
        if (quotation.isPresent()) {
            return ResponseEntity.ok(quotation);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/exists-by-id")
    public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
        boolean quotationExists = quotationService.existsById(id);
        return ResponseEntity.ok(quotationExists);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        boolean quotationDeleted = quotationService.deleteById(id);
        if (quotationDeleted) {
            return ResponseEntity.ok("Deleted Quotation");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-by-quotation")
    public ResponseEntity<String> deleteByQuotation(@RequestBody Quotation quotation) {
        boolean quotationDeleted = quotationService.deleteQuotation(quotation);
        if (quotationDeleted) {
            return ResponseEntity.ok("Deleted Quotation");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        long count = quotationService.count();
        return ResponseEntity.ok(count);
    }
}
