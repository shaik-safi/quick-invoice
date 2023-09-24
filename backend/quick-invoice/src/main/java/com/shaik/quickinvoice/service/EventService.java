package com.shaik.quickinvoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.model.Event;
import com.shaik.quickinvoice.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public Event add(Event event) {
		Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }
    
    public List<Event> findAll() {
    	List<Event> savedEvents = eventRepository.findAll();
    	return savedEvents;
    }
    
    public Optional<Event> findById(Long id) {
    	Optional<Event> event = eventRepository.findById(id);
    	return event;
    }
    
    public List<Event> findByName(String name) {
    	List<Event> event = eventRepository.findByName(name);
    	return event;
    }
    
    public boolean existsById(Long id) {
    	boolean eventExists = eventRepository.existsById(id);
    	return eventExists;
    }
    
    public boolean deleteById(Long id) {
    	eventRepository.deleteById(id);
    	return true;
    }
    
    public boolean deleteEvent(Event event) {
    	eventRepository.delete(event);
    	return true;
    }
    
    public long count() {
    	long count = eventRepository.count();
    	return count;
    }
}
