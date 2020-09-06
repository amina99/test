package com.sip.gestiondevente.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.Lcommande;

@Repository
public interface LcommandeRepository extends JpaRepository<Lcommande, Long>{

}
