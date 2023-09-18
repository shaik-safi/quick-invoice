package com.shaik.quickinvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.CompanyClient;
import com.shaik.quickinvoice.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {

	Iterable<Invoice> findByInvoiceNumber(String InvoiceNumber);
}
