package com.api.api.service;

import com.api.api.modele.Client;
import com.api.api.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> liste() {
        return clientRepository.findAll();
    }

    @Override
    public Client modifier(Long id, Client client) {
        return clientRepository.findById(id)
                .map(client1 -> {
                    client1.setNom(client.getNom());
                    client1.setPrenom(client.getPrenom());
                    client1.setDateNaiss(client.getDateNaiss());
                    client1.setSexe(client.getSexe());
                    client1.setAdresse(client.getAdresse());
                    client1.setTelephone(client.getTelephone());
                    client1.setCourriel(client.getCourriel());
                    client1.setNationalite(client.getNationalite());
                    return clientRepository.save(client1);
                }).orElseThrow(() -> new RuntimeException("Client introuvable !"));
    }

    @Override
    public String supprimer(Long id) {
        clientRepository.deleteById(id);
        return "Client supprimé ";
    }
}
