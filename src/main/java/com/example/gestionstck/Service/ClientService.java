package com.example.gestionstck.Service;

import com.example.gestionstck.Entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();
    Client createClient(Client client);
    Client getClientById(Long id);
    Client updateClient(Client client);
    void deleteClient(Long id);
}
