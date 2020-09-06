package com.sip.gestiondevente.services;

import java.util.List;
import java.util.Optional;

import com.sip.gestiondevente.entities.Article;

public interface ArticleServices {

    public List<Article> findArticleByArticleCategorie(Long id);
	public List<Article> consulterArticle();
	public Optional<Article> consulterArticle(Long id);


}
