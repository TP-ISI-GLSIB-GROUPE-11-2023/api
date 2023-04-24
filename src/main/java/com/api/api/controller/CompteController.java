package com.api.api.controller;

import com.api.api.modele.Compte;
import com.api.api.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compte")
@AllArgsConstructor
public class CompteController {
    private final CompteService compteService;
    @PostMapping(path = "/create")
    public Compte create(@RequestBody Compte compte){
        return compteService.creer(compte);
    }
    @GetMapping(path = "/read")
    public List<Compte> read(){
        return compteService.lire();
    }

    @PutMapping(path = "/update/{numero}")
    public Compte update(@PathVariable String numero,@RequestBody Compte compte){
        return compteService.modifier(numero,compte);
    }
    @DeleteMapping(path = "/delete/{numero}")
    public String delete(@PathVariable String numero){
        return compteService.supprimer(numero);
    }

    @PostMapping(path = "/deposit/{numCompte}/{solde}")
    public String depositAmount(@PathVariable String numCompte, @PathVariable double solde) {
        //int initBal = getBalance(acctID);
        return compteService.depositAmount(numCompte, solde);
        //Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
        //loggerController.addLog(logger);
    }

    @PostMapping("/{numCompte}/transfer/{destAcctID}/{amount}")
    public String transferAmount(@PathVariable String numCompte, @PathVariable String destAcctID, @PathVariable double amount) {
        return compteService.transferAmount(numCompte, destAcctID, amount);
    }

    @PostMapping("/{numCompte}/retrait/{amount}")
    public String retrait(@PathVariable String numCompte, @PathVariable double amount) {
        return compteService.retrait(numCompte, amount);
    }


}
