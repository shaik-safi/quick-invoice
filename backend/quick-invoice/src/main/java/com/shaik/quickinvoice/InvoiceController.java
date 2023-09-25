package com.shaik.quickinvoice;

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

import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Invoice invoice) {
	    if (invoiceService.add(invoice) != null) {
	        return ResponseEntity.ok("Invoice saved");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<Invoice>> findAll() {
		List<Invoice> allInvoices = invoiceService.findAll();
	    if (allInvoices != null) {
	        return ResponseEntity.ok(allInvoices);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<Optional<Invoice>> findById(@RequestParam Long id) {
		Optional<Invoice> invoice = invoiceService.findById(id);
	    if (invoice.isPresent()) {
	        return ResponseEntity.ok(invoice);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity<List<Invoice>> findByName(@RequestParam String name) {
		List<Invoice> allInvoices = invoiceService.findByName(name);
	    if (allInvoices != null) {
	        return ResponseEntity.ok(allInvoices);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/exists-by-id")
	public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
		boolean invoiceExists = invoiceService.existsById(id);
	    if (invoiceExists) {
	        return ResponseEntity.ok(true);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-id")
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		boolean invoiceDeleted = invoiceService.deleteById(id);
	    if (invoiceDeleted) {
	        return ResponseEntity.ok("Deleted Invoice");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-invoice")
	public ResponseEntity<String> deleteByInvoice(@RequestParam Invoice invoice) {
		boolean invoiceDeleted = invoiceService.deleteInvoice(invoice);
	    if (invoiceDeleted) {
	        return ResponseEntity.ok("Deleted Invoice");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getCount() {
		long count = invoiceService.count();
	    if (count != 0) {
	        return ResponseEntity.ok(count);
	    }
	    return ResponseEntity.badRequest().build();
	}
}
