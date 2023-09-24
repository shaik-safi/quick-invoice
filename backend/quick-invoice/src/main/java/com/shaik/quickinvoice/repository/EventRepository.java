package com.shaik.quickinvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shaik.quickinvoice.model.Client;
import com.shaik.quickinvoice.model.Event;
import com.shaik.quickinvoice.model.Invoice;

public interface EventRepository extends JpaRepository<Event,Long> {

	List<Event> findByName(String name);
}
