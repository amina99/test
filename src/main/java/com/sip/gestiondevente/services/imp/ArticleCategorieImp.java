package com.sip.gestiondevente.services.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.gestiondevente.Repositorie.ArticleCategorieRepository;
import com.sip.gestiondevente.entities.Article;
import com.sip.gestiondevente.entities.ArticleCategorie;
import com.sip.gestiondevente.services.ArticleCategorieService;

@Service
public class ArticleCategorieImp implements ArticleCategorieService {
	@Autowired
    private ArticleCategorieRepository repository;

	
	@Override
	public List<ArticleCategorie> consulterArticleCategorie() {
		return repository.findAll();
	}


}
