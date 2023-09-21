package com.shaik.quickinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
