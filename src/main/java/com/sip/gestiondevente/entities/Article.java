package com.sip.gestiondevente.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String code;
	
	private String name;
    @Type(type = "text")
	private String description;
	
	private BigDecimal Price;
	
	private String image;
	
	private String status;

	private int Stock;
	private int tva;

	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private ArticleCategorie categorie;
	
	// @JsonProperty("category")
   //  @ManyToOne
  //   @JoinColumn(name = "category_id")
  //  @JsonIgnoreProperties("articleList")
  //  private ArticleCategorie category;
    
	
}
