package com.api.api.service;

import com.api.api.modele.Compte;

import java.util.List;

public interface CompteService {
    Compte creer(Compte compte);
    List<Compte> lire();
    Compte modifier(String numero, Compte compte);
    String supprimer(String numero);
    String depositAmount(String numCompte, double solde);
    String transferAmount(String numCompte, String destAcctID, double amount);
    String retrait(String numCompte, double amount);

}
