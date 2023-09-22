package com.shaik.quickinvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	List<Client> findByName(String name);
}
