package com.api.api.service;

import com.api.api.modele.Client;

import java.util.List;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();
    Client modifier(Long id, Client client);
    String supprimer(Long id);
}
