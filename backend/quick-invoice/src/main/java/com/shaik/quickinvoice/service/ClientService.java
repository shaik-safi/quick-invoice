package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaik.quickinvoice.model.Client;
import com.shaik.quickinvoice.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client) {
    	Client savedClient = clientRepository.save(client);
    	return savedClient;
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> findClientsByName(String name) {
        return clientRepository.findByName(name);
    }

    public boolean existsClientById(Long id) {
        return clientRepository.existsById(id);
    }

    public boolean deleteClientById(Long id) {
        if (existsClientById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public long getClientCount() {
        return clientRepository.count();
    }
}
