package com.shaik.quickinvoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.model.Quotation;
import com.shaik.quickinvoice.repository.QuotationRepository;

//@Service
public class QuotationService {
	@Autowired
    private QuotationRepository quotationRepository;

    public Quotation add(Quotation quotation) {
        Quotation savedQuotation = quotationRepository.save(quotation);
        return savedQuotation;
    }
    
    public List<Quotation> findAll() {
    	List<Quotation> savedQuotations = quotationRepository.findAll();
    	return savedQuotations;
    }
    
    public Optional<Quotation> findById(Long id) {
    	Optional<Quotation> quotation = quotationRepository.findById(id);
    	return quotation;
    }
    
    public List<Quotation> findByName(String name) {
    	List<Quotation> quotation = quotationRepository.findByName(name);
    	return quotation;
    }
    
    public boolean existsById(Long id) {
    	boolean quotationExists = quotationRepository.existsById(id);
    	return quotationExists;
    }
    
    public boolean deleteById(Long id) {
    	quotationRepository.deleteById(id);
    	return true;
    }
    
    public boolean deleteQuotation(Quotation quotation) {
    	quotationRepository.delete(quotation);
    	return true;
    }
    
    public long count() {
    	long count = quotationRepository.count();
    	return count;
    }
}