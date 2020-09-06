package com.sip.gestiondevente.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.gestiondevente.Repositorie.CommandeRepository;
import com.sip.gestiondevente.Repositorie.CompteurRepository;
import com.sip.gestiondevente.Repositorie.LcommandeRepository;
import com.sip.gestiondevente.entities.Commande;
import com.sip.gestiondevente.entities.Compteur;
import com.sip.gestiondevente.entities.Lcommande;
import com.sip.gestiondevente.services.CommandeService;
@Service
public class CommandeServiceImp implements CommandeService{
	
	@Autowired
	CommandeRepository commanderepository;
	@Autowired LcommandeRepository repo;
	@Autowired CompteurRepository comptrepo;
	


	@Override
	public List<Commande> consulterCommande() {
		return commanderepository.findAll();
	}
	
	
	@Override
	public Optional<Commande> consulterCommandebyid(Long  id) {
		return commanderepository.findById(id) ;
	}
	
	
	
	public Commande saveCommande(Commande commande) {

	
	   List<Lcommande> lcomms = commande.getLcomms();
        for (Lcommande lc : lcomms) {
        lc.setNumero(commande.getNumero());
   		repo.save(lc);
       }	 

    Optional<Compteur> CompteurInfo = comptrepo.findByAnnee(commande.getAnnee());
 	if (CompteurInfo.isPresent()) {
    	Compteur compteur = CompteurInfo.get();
           compteur.setNumcomm(compteur.getNumcomm()+1);
         compteur =   comptrepo.save(compteur);
 	}
	return commanderepository.save(commande);


	}
	}
