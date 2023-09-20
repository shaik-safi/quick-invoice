package com.shaik.quickinvoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Client;

public interface ClientRepository extends CrudRepository<Client,Long> {
//	Iterable<CompanyClient> findByClientName(String clientName);
//
//	CompanyClient findOneByClientName(String clientName);
}
