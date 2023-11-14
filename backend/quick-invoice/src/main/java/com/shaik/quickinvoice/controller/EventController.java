package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.shaik.quickinvoice.model.Event;
import com.shaik.quickinvoice.service.EventService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Object> addEvent(@RequestBody Event event) {
        System.out.println("Received Event: " + event);
        Event savedEvent = eventService.addEvent(event);
        if (savedEvent != null) {
            return ResponseEntity.ok().body("{\"status\": \"success\", \"message\": \"Event saved\"}");
        }
        return ResponseEntity.badRequest().body("{\"status\": \"error\", \"message\": \"Failed to save event\"}");
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Event>> findAllEvents() {
        List<Event> allEvents = eventService.findAllEvents();
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Event>> findEventById(@RequestParam Long id) {
        Optional<Event> event = eventService.findEventById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<Event>> findEventsByName(@RequestParam String name) {
        List<Event> allEvents = eventService.findEventsByName(name);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/exists-by-id")
    public ResponseEntity<Boolean> existsEventById(@RequestParam Long id) {
        boolean eventExists = eventService.existsEventById(id);
        return ResponseEntity.ok(eventExists);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteEventById(@RequestParam Long id) {
        boolean eventDeleted = eventService.deleteEventById(id);
        if (eventDeleted) {
            return ResponseEntity.ok("Deleted Event");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-by-event")
    public ResponseEntity<String> deleteEvent(@RequestBody Event event) {
        boolean eventDeleted = eventService.deleteEvent(event);
        if (eventDeleted) {
            return ResponseEntity.ok("Deleted Event");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getEventCount() {
        long count = eventService.getEventCount();
        return ResponseEntity.ok(count);
    }
}
