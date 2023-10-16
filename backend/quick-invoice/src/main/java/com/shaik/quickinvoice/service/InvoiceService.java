package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.repository.InvoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice add(Invoice invoice) {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return savedInvoice;
    }

    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return invoiceRepository.existsById(id);
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
        return invoiceRepository.count();
    }

    public Optional<Invoice> findInvoiceByEventId(Long id) {
        return invoiceRepository.findByEventId(id);
    }
}
