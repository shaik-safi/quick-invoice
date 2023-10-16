package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaik.quickinvoice.model.Event;
import com.shaik.quickinvoice.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> findEventsByName(String name) {
        return eventRepository.findByName(name);
    }

    public boolean existsEventById(Long id) {
        return eventRepository.existsById(id);
    }

    public boolean deleteEventById(Long id) {
        if (existsEventById(id)) {
            eventRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteEvent(Event event) {
        eventRepository.delete(event);
        return true;
    }

    public long getEventCount() {
        return eventRepository.count();
    }
}
