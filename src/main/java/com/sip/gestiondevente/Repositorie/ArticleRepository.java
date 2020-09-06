package com.sip.gestiondevente.Repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.gestiondevente.entities.Article;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	@Query("Select a From Article a where a.categorie.id=:id")
	public List<Article>findAllArticleByArticleCategorieId(@Param(value = "id")Long id);
}
