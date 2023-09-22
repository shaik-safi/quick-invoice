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

import com.shaik.quickinvoice.model.Client;
import com.shaik.quickinvoice.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Client client) {
	    if (clientService.add(client) != null) {
	        return ResponseEntity.ok("Client saved");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<Client>> findAll() {
		List<Client> allClients = clientService.findAll();
	    if (allClients != null) {
	        return ResponseEntity.ok(allClients);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<Optional<Client>> findById(@RequestParam Long id) {
		Optional<Client> client = clientService.findById(id);
	    if (client.isPresent()) {
	        return ResponseEntity.ok(client);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/find-by-name")
	public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
		List<Client> allClients = clientService.findByName(name);
	    if (allClients != null) {
	        return ResponseEntity.ok(allClients);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/exists-by-id")
	public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
		boolean clientExists = clientService.existsById(id);
	    if (clientExists) {
	        return ResponseEntity.ok(true);
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-id")
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		boolean clientDeleted = clientService.deleteById(id);
	    if (clientDeleted) {
	        return ResponseEntity.ok("Deleted Client");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/delete-by-client")
	public ResponseEntity<String> deleteByClient(@RequestParam Client client) {
		boolean clientDeleted = clientService.deleteClient(client);
	    if (clientDeleted) {
	        return ResponseEntity.ok("Deleted Client");
	    }
	    return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getCount() {
		long count = clientService.count();
	    if (count != 0) {
	        return ResponseEntity.ok(count);
	    }
	    return ResponseEntity.badRequest().build();
	}
}
