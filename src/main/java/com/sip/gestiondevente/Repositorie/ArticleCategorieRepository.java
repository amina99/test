package com.sip.gestiondevente.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.ArticleCategorie;

@Repository

public interface ArticleCategorieRepository extends JpaRepository<ArticleCategorie, Long>{

}
