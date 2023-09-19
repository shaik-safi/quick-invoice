package com.shaik.quickinvoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.CompanyClient;

public interface CompanyClientRepository extends CrudRepository<CompanyClient,Long> {
//	Iterable<CompanyClient> findByClientName(String clientName);
//
//	CompanyClient findOneByClientName(String clientName);
}
