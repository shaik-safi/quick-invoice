package com.shaik.quickinvoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaik.quickinvoice.model.Quotation;
import com.shaik.quickinvoice.service.QuotationService;

@Controller
@RequestMapping("/quotation")
public class QuotationController {

	@Autowired
	private QuotationService quotationService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Quotation quotation) {
	    if (quotationService.add(quotation) != null) {
	        return ResponseEntity.ok("Quotation saved");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<Quotation>> findAll() {
		List<Quotation> allQuotations = quotationService.findAll();
	    if (allQuotations != null) {
	        return ResponseEntity.ok(allQuotations);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<Optional<Quotation>> findById(@RequestParam Long id) {
		Optional<Quotation> quotation = quotationService.findById(id);
	    if (quotation.isPresent()) {
	        return ResponseEntity.ok(quotation);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity<List<Quotation>> findByName(@RequestParam String name) {
		List<Quotation> allQuotations = quotationService.findByName(name);
	    if (allQuotations != null) {
	        return ResponseEntity.ok(allQuotations);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/exists-by-id")
	public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
		boolean quotationExists = quotationService.existsById(id);
	    if (quotationExists) {
	        return ResponseEntity.ok(true);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-id")
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		boolean quotationDeleted = quotationService.deleteById(id);
	    if (quotationDeleted) {
	        return ResponseEntity.ok("Deleted Quotation");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-quotation")
	public ResponseEntity<String> deleteByQuotation(@RequestParam Quotation quotation) {
		boolean quotationDeleted = quotationService.deleteQuotation(quotation);
	    if (quotationDeleted) {
	        return ResponseEntity.ok("Deleted Quotation");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getCount() {
		long count = quotationService.count();
	    if (count != 0) {
	        return ResponseEntity.ok(count);
	    }
	    return ResponseEntity.badRequest().build();
	}
}
