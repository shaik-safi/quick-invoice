package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
