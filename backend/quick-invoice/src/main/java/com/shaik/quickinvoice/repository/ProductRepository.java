package com.shaik.quickinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaik.quickinvoice.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
//	List<InvoiceDetails> findByInvoiceInvoiceId(Long clientId);
}
