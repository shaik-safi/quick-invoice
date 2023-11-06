package com.shaik.quickinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shaik.quickinvoice.model.Client;
import com.shaik.quickinvoice.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        if (clientService.addClient(client) != null) {
            return ResponseEntity.ok("Client added successfully");
        }
        return ResponseEntity.badRequest().body("Failed to add client");
    }
    
    @GetMapping("/get-client-names")
    public ResponseEntity<List<String>> getClientNames() {
        List<String> clientNames = clientService.getAllClientNames();
        return ResponseEntity.ok(clientNames);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> allClients = clientService.findAllClients();
        return ResponseEntity.ok(allClients);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Client>> findClientById(@RequestParam Long id) {
        Optional<Client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<Client>> findClientsByName(@RequestParam String name) {
        List<Client> clients = clientService.findClientsByName(name);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/exists-by-id")
    public ResponseEntity<Boolean> existsClientById(@RequestParam Long id) {
        boolean clientExists = clientService.existsClientById(id);
        return ResponseEntity.ok(clientExists);
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteClientById(@RequestParam Long id) {
        if (clientService.deleteClientById(id)) {
            return ResponseEntity.ok("Client deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-by-client")
    public ResponseEntity<String> deleteClient(@RequestBody Client client) {
        clientService.deleteClient(client);
        return ResponseEntity.ok("Client deleted successfully");
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getClientCount() {
        long count = clientService.getClientCount();
        return ResponseEntity.ok(count);
    }
}
