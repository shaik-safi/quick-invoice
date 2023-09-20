package com.shaik.quickinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaik.quickinvoice.model.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Long> {
//	List<InvoiceDetails> findByInvoiceInvoiceId(Long clientId);
}
