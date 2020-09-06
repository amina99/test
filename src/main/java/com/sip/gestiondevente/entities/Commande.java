package com.sip.gestiondevente.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Commande {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date date_comm;
	  private int code_client;
	  private String libelle;
	  private String lib_client;
	  private double avance;
	  private double totht;
	  private double tottva;
	  private double totttc;

	  @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "commande", fetch=FetchType.EAGER)
	  private List<Lcommande> lcomms = new ArrayList<>();
	  
}
