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

    @Override
    public String depositAmount(String numCompte, double solde) {
        compteRepository.findById(numCompte)
                .map(p->{
                    p.setSolde(solde);
                    return compteRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
        return "depot effectué";
    }

    @Override
    public String transferAmount(String numCompte, String destAcctID, double amount) {
        double solde = compteRepository.findById(numCompte)
                .map(p->{
                    p.getSolde();
                    return p.getSolde();
                }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
        if (solde > amount) {
            compteRepository.findById(destAcctID)
                    .map(p->{
                        p.setSolde(p.getSolde()+amount);
                        return compteRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
            compteRepository.findById(numCompte)
                    .map(p->{
                        p.setSolde(solde-amount);
                        return compteRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Compte non trouvé!"));
            return "transfert effectué";
        } else {
            return "transfert non effectué, le solde est inferieur au montant";
        }


    }

    @Override
    public String retrait(String numCompte, double amount) {
        double solde = compteRepository.findById(numCompte)
                .map(p->{
                    p.getSolde();
                    return p.getSolde();
                }).orElseThrow(() -> new RuntimeException("Compte non trouvÃ©!"));
        if (solde > amount) {
            compteRepository.findById(numCompte)
                    .map(p->{
                        p.setSolde(solde-amount);
                        return compteRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Compte non trouvÃ©!"));
            return "retrait effectuÃ©";
        } else {
            return "retrait non effectuÃ©, le solde est inferieur au montant";
        }


    }
}
