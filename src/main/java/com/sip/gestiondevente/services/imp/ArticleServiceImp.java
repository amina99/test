package com.sip.gestiondevente.services.imp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.gestiondevente.Repositorie.ArticleRepository;
import com.sip.gestiondevente.entities.Article;
import com.sip.gestiondevente.services.ArticleServices;

@Service

public class ArticleServiceImp implements ArticleServices {
	
	@Autowired
	ArticleRepository articlerepository;
	
	


	@Override
	public List<Article> consulterArticle() {
		return articlerepository.findAll();
	}

	
	@Override
	public List<Article> findArticleByArticleCategorie(Long id) {
		return articlerepository.findAllArticleByArticleCategorieId(id);
	}
	
	@Override
	public Optional<Article> consulterArticle(Long  id) {
		return articlerepository.findById(id) ;
	}


}
