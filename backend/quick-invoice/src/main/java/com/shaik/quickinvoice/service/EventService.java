package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
}
