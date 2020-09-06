package com.sip.gestiondevente.Repositorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.Commande;
import com.sip.gestiondevente.entities.Compteur;

@Repository
public interface CompteurRepository  extends JpaRepository<Compteur, Long> {

	Optional<Compteur> findByAnnee(int annee);




}
