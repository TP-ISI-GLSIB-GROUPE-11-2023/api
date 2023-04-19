package com.api.api.repository;

import com.api.api.modele.Client;
import com.api.api.modele.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
