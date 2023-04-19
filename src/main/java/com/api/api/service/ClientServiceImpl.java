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
    public List<Client> lire() {
        return clientRepository.findAll();
    }

    @Override
    public Client modifier(Long id, Client client) {
        return clientRepository.findById(id)
                .map(p->{
                    //p.setComptes(client.getComptes());
                    return clientRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        clientRepository.deleteById(id);
        return "Client supprimer";
    }
}
