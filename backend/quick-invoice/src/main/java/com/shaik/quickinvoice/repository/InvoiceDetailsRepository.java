package com.shaik.quickinvoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Invoice;

public interface InvoiceDetailsRepository extends CrudRepository<Invoice,Long> {

}
