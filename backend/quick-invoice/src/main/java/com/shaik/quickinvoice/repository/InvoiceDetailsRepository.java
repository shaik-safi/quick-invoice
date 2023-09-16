package com.shaik.quickinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Invoice;
import com.shaik.quickinvoice.model.InvoiceDetails;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails,Long> {

}
