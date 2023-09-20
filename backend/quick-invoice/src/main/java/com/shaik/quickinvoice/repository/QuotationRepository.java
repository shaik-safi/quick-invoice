package com.shaik.quickinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaik.quickinvoice.model.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {
//	List<InvoiceDetails> findByInvoiceInvoiceId(Long clientId);
}
