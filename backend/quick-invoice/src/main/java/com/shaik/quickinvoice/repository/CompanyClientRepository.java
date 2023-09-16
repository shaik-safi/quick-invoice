package com.shaik.quickinvoice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shaik.quickinvoice.model.CompanyClient;

public interface CompanyClientRepository extends CrudRepository<CompanyClient,Long> {
}
