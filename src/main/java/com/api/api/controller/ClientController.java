package com.api.api.controller;

import com.api.api.modele.Client;
import com.api.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        return clientService.creer(client);
    }
    @GetMapping("/read")
    public List<Client> read(){
        return clientService.liste();
    }
    @PutMapping("/update/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client){
        return clientService.modifier(id,client);
    }
    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id){
        return clientService.supprimer(id);
    }
}
