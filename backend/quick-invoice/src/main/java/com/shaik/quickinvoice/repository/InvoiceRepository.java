package com.shaik.quickinvoice.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.shaik.quickinvoice.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {

	Iterable<Invoice> findByInvoiceNumber(String InvoiceNumber);

	Optional<Invoice> findByClientClientId(Long clientId);
}
