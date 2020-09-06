package com.sip.gestiondevente.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String code;
	  private String libelle;
	  private String adresse;
	  private String tel;
	  private String email;
	  private String fax;
	  private String login;
	  private String pwd;
	  private String smtva;
	  private String  matfisc;
	  private String  timbre;
	  private Date cree;
	  private float   soldinit;
	  private float   soldef;


}
