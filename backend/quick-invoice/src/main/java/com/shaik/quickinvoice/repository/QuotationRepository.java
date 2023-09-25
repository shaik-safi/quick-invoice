package com.shaik.quickinvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaik.quickinvoice.model.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {

	List<Quotation> findByName(String name);
}
