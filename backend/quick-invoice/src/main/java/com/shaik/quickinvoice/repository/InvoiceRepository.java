package com.shaik.quickinvoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {

}