package com.api.api.service;

import com.api.api.modele.Compte;
import com.api.api.repository.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CompteServiceImpl implements CompteService{

    private final CompteRepository compteRepository;
    @Override
    public Compte creer(Compte compte) {
        compte.setNumero();
        //compte.setClient();
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> lire() {
        return compteRepository.findAll();
    }

    @Override
    public Compte modifier(String numero, Compte compte) {
        return compteRepository.findById(numero)
                .map(p->{
                    p.setType(compte.getType());
                    p.setSolde(compte.getSolde());
                    p.setClient(compte.getClient());
                    p.setDateCreation(compte.getDateCreation());
                    return compteRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
    }
    @Override
    public String supprimer(String numero) {
        compteRepository.deleteById(numero);
        return "Compte supprimer";
    }
}
