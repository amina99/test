package com.sip.gestiondevente.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sip.gestiondevente.Exception.ResourceNotFoundException;
import com.sip.gestiondevente.Repositorie.ClientRepository;
import com.sip.gestiondevente.Repositorie.CommandeRepository;
import com.sip.gestiondevente.Repositorie.CompteurRepository;
import com.sip.gestiondevente.Repositorie.LcommandeRepository;
import com.sip.gestiondevente.entities.Client;
import com.sip.gestiondevente.entities.Commande;
import com.sip.gestiondevente.entities.Compteur;
import com.sip.gestiondevente.entities.Lcommande;
import com.sip.gestiondevente.services.CommandeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class CommandeController {

	@Autowired
	CommandeService commandeservice;
	
	@Autowired
	CompteurRepository compteurrepository;
	@Autowired 	CommandeRepository repository;
	@Autowired LcommandeRepository repo;
	@Autowired	ClientRepository clientrepository;
	
	 @GetMapping("/comms")
	  public List<Commande> getAllComms() {
	    System.out.println("Get all Comms...");
	    List<Commande> Comms = new ArrayList<>();
	    commandeservice.consulterCommande().forEach(Comms::add);
	    return Comms;
	  }
	 
	 
	 @GetMapping("/consultercommandebyid")
		public ResponseEntity<Commande> getCommById(@RequestParam(value = "id") Long id)
				throws ResourceNotFoundException {
			Commande Commande = commandeservice.consulterCommandebyid(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comm not found for this id :: " + id));
			return ResponseEntity.ok().body(Commande);
		}
	 
	// @PostMapping("/createcommande")
	//	public Commande createCommande( @RequestBody Commande commande)  {
			  
		//	 return commandeservice.saveCommande(commande);
		//}

	 @PostMapping("/comms")
		public ResponseEntity<Commande> createComm(@RequestBody Commande Commande)  
				throws JsonParseException , JsonMappingException , Exception{
			  
			repository.save(Commande);
			List<Lcommande> lcomms = Commande.getLcomms();
		    for (Lcommande lc : lcomms) {
		        lc.setNumero(Commande.getNumero());
	       		repo.save(lc);
		       }	 
		
	     Optional<Compteur> CompteurInfo = compteurrepository.findByAnnee(Commande.getAnnee());
	     	if (CompteurInfo.isPresent()) {
		    	Compteur compteur = CompteurInfo.get();
		           compteur.setNumcomm(compteur.getNumcomm()+1);
		         compteur =   compteurrepository.save(compteur);
	     	}
			 return new ResponseEntity<>(HttpStatus.OK);
		}


		@GetMapping("/compteursid/{id}")
		public ResponseEntity<Compteur> getCompteurById(@PathVariable(value = "id") Long id)
				throws ResourceNotFoundException {
			Compteur Compteur = compteurrepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this id :: " + id));
			return ResponseEntity.ok().body(Compteur);
		}
		
		
		@GetMapping("/compteurs/{annee}")
		public ResponseEntity<Compteur> getCompteurByAnnee(@PathVariable(value = "annee") int annee)
				throws ResourceNotFoundException {
			Compteur Compteur = compteurrepository.findByAnnee(annee)
					.orElseThrow(() -> new ResourceNotFoundException("Compteur not found for this id :: " + annee));
			return ResponseEntity.ok().body(Compteur);
		}
		
		@PostMapping("/compteurs")
		public Compteur createCompteur( @RequestBody Compteur Compteur) {
			return compteurrepository.save(Compteur);
		}
		
		 @GetMapping("/clients")
		  public List<Client> getAllClients() {
		    System.out.println("Get all Clients...");
		 
		    List<Client> Clients = new ArrayList<>();
		    clientrepository.findAll().forEach(Clients::add);
		 
		    return Clients;
		  }

}
