package com.sip.gestiondevente.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
