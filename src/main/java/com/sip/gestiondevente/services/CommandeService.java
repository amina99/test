package com.sip.gestiondevente.services;

import java.util.List;
import java.util.Optional;

import com.sip.gestiondevente.entities.Commande;

public interface CommandeService {

	public List<Commande> consulterCommande() ;
	public Optional<Commande> consulterCommandebyid(Long  id);
	public Commande saveCommande(Commande commande) ;



}
