package com.shaik.quickinvoice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.model.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {

	Optional<Quotation> findByEventId(Long id);
}
