package com.sip.gestiondevente.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
