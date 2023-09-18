package com.shaik.quickinvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {

	Company findBycompanyName(String name);
}
