package com.sip.gestiondevente.entities;

import java.math.BigDecimal;

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

public class Compteur {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private int annee;
	private int numcomm;
	private int numcomms;
	private int numbl;
	private int numblf;
	private int numcommf;
	private int numav;
	private int numavf;
	private int numbr;
	private int numbs;
	private int numfac;
	private int numfacf;
	private int numreg;
	private int numregf;
	private int numchq;
	private int numdev;
	private int numinv;
	private int numimp;
	private int numimpf;

}
