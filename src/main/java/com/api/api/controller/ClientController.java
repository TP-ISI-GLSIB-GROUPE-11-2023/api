package com.api.api.controller;

import com.api.api.modele.Client;
import com.api.api.modele.Compte;
import com.api.api.service.ClientService;
import com.api.api.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping(path = "/create")
    public Client create(@RequestBody Client client){
        return clientService.creer(client);
    }
    @GetMapping(path = "/read")
    public List<Client> read(){
        return clientService.lire();
    }
}
