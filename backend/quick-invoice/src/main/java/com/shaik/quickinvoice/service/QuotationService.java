package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaik.quickinvoice.model.Quotation;
import com.shaik.quickinvoice.repository.QuotationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    public Quotation add(Quotation quotation) {
        Quotation savedQuotation = quotationRepository.save(quotation);
        return savedQuotation;
    }

    public List<Quotation> findAll() {
        return (List<Quotation>) quotationRepository.findAll();
    }

    public Optional<Quotation> findById(Long id) {
        return quotationRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return quotationRepository.existsById(id);
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
        return quotationRepository.count();
    }

    public Optional<Quotation> findQuotationByEventId(Long id) {
        return quotationRepository.findByEventId(id);
    }
}
