package com.shaik.quickinvoice.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.shaik.quickinvoice.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {

	List<Invoice> findByName(String name);
}
