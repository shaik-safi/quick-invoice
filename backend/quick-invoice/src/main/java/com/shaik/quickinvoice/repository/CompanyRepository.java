package com.shaik.quickinvoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Company;

public interface CompanyRepository extends CrudRepository<Company,Long> {

}
