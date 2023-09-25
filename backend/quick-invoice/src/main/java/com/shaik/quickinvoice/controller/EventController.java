package com.shaik.quickinvoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaik.quickinvoice.model.Event;
import com.shaik.quickinvoice.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Event event) {
	    if (eventService.add(event) != null) {
	        return ResponseEntity.ok("Event saved");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<Event>> findAll() {
		List<Event> allEvents = eventService.findAll();
	    if (allEvents != null) {
	        return ResponseEntity.ok(allEvents);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<Optional<Event>> findById(@RequestParam Long id) {
		Optional<Event> event = eventService.findById(id);
	    if (event.isPresent()) {
	        return ResponseEntity.ok(event);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity<List<Event>> findByName(@RequestParam String name) {
		List<Event> allEvents = eventService.findByName(name);
	    if (allEvents != null) {
	        return ResponseEntity.ok(allEvents);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/exists-by-id")
	public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
		boolean eventExists = eventService.existsById(id);
	    if (eventExists) {
	        return ResponseEntity.ok(true);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-id")
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		boolean eventDeleted = eventService.deleteById(id);
	    if (eventDeleted) {
	        return ResponseEntity.ok("Deleted Event");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-event")
	public ResponseEntity<String> deleteByEvent(@RequestParam Event event) {
		boolean eventDeleted = eventService.deleteEvent(event);
	    if (eventDeleted) {
	        return ResponseEntity.ok("Deleted Event");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getCount() {
		long count = eventService.count();
	    if (count != 0) {
	        return ResponseEntity.ok(count);
	    }
	    return ResponseEntity.badRequest().build();
	}
}