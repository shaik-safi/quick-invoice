package com.shaik.quickinvoice.service;

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
}