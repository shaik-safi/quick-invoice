package com.shaik.quickinvoice.service;
 
 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.repository.InvoiceRepository;
 
 @Service
 public class InvoiceService {
	 @Autowired
	    private InvoiceRepository invoiceRepository;

	    public Invoice add(Invoice invoice) {
	        Invoice savedInvoice = invoiceRepository.save(invoice);
	        return savedInvoice;
	    }
	    
	    public List<Invoice> findAll() {
	    	List<Invoice> savedInvoices = (List<Invoice>) invoiceRepository.findAll();
	    	return savedInvoices;
	    }
	    
	    public Optional<Invoice> findById(Long id) {
	    	Optional<Invoice> invoice = invoiceRepository.findById(id);
	    	return invoice;
	    }
	    
	    public List<Invoice> findByName(String name) {
	    	List<Invoice> invoice = invoiceRepository.findByName(name);
	    	return invoice;
	    }
	    
	    public boolean existsById(Long id) {
	    	boolean invoiceExists = invoiceRepository.existsById(id);
	    	return invoiceExists;
	    }
	    
	    public boolean deleteById(Long id) {
	    	invoiceRepository.deleteById(id);
	    	return true;
	    }
	    
	    public boolean deleteInvoice(Invoice invoice) {
	    	invoiceRepository.delete(invoice);
	    	return true;
	    }
	    
	    public long count() {
	    	long count = invoiceRepository.count();
	    	return count;
	    }

		public Optional<Invoice> findInvoiceByEventId(Long id) {
			Optional<Invoice> invoice = invoiceRepository.findByEventid(id);
	    	return invoice;
		}
	}