package com.shaik.quickinvoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.model.Client;
import com.shaik.quickinvoice.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client add(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }
    
    public List<Client> findAll() {
    	List<Client> savedClients = clientRepository.findAll();
    	return savedClients;
    }
    
    public Optional<Client> findById(Long id) {
    	Optional<Client> client = clientRepository.findById(id);
    	return client;
    }
    
    public List<Client> findByName(String name) {
    	List<Client> client = clientRepository.findByName(name);
    	return client;
    }
    
    public boolean existsById(Long id) {
    	boolean clientExists = clientRepository.existsById(id);
    	return clientExists;
    }
    
    public boolean deleteById(Long id) {
    	clientRepository.deleteById(id);
    	return true;
    }
    
    public boolean deleteClient(Client client) {
    	clientRepository.delete(client);
    	return true;
    }
    
    public long count() {
    	long count = clientRepository.count();
    	return count;
    }
}