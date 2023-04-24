package com.api.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
enum Sexe { Masculin, Feminin }

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Compte> comptes;
    // Constructeurs, getters et setters

    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    private Date dateNaiss;
    @Column(length = 2)
    private Sexe sexe;
    @Column(length = 60)
    private String  adresse;
    @Column(length = 20)
    private String  telephone;
    @Column(length = 50)
    private String  courriel;
    @Column(length = 30)
    private String  nationalite;

}
