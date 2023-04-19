package com.api.api.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "comptes")
@Getter
@Setter
@NoArgsConstructor
public class Compte {
    @Id
    @Column(unique = true)
    private String numero;
    private String type;
    @Temporal(TemporalType.DATE)
    private Date dateCreation=new Date();
    @Column(columnDefinition = "integer default 0")
    private double solde ;
    @ManyToOne
    @JsonIgnoreProperties(value = {"comptes"})
    @JoinColumn(name = "client_id")
    private Client client;
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public Compte(String type, Date dateCreation, double solde, Client client) {
        this.type = type;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
        this.numero = generateNumero();
    }

    public void setNumero() {
        this.numero = generateNumero();
    }


    private String generateNumero() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            builder.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        builder.append(dateCreation.getYear());
        return builder.toString();
    }
}

