package com.sip.gestiondevente.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sip.gestiondevente.Repositorie.ArticleRepository;
import com.sip.gestiondevente.entities.Article;
import com.sip.gestiondevente.entities.ArticleCategorie;
import com.sip.gestiondevente.services.ArticleCategorieService;
import com.sip.gestiondevente.services.ArticleServices;
import com.sip.gestiondevente.services.imp.Fileservice;

@RestController
@CrossOrigin(origins = "*")

public class ArticleController {
	

	@Autowired
	ArticleServices articleservices;
	@Autowired
	ArticleCategorieService articlecategorieservices;
	@Autowired
	ArticleRepository articlerepository;
	@Autowired
	Fileservice serviceFile;


	@GetMapping("/listarticles")
	public List<Article> consulterArticle() {
		return articleservices.consulterArticle();
	}
    
  	
	@GetMapping("/listcategorie")
	public List<ArticleCategorie> consulterArticleCategorie() {
		return articlecategorieservices.consulterArticleCategorie();
	}

	
    	
	@GetMapping("/listarticlesbycategorie")
	public List<Article> findArticlesByArticleCategorie(@RequestParam(name="id")Long id) {
		return articleservices.findArticleByArticleCategorie(id);
	}
	
  	
	@GetMapping("/listarticlesbyid")
	public  Optional<Article> findArticlesbyid(@RequestParam(name="id")Long id) {
		return articleservices.consulterArticle(id);
	}
	

	@GetMapping(path="photoArticle/{id}", produces= MediaType.IMAGE_JPEG_VALUE)
	   public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
	  	Article a=articlerepository.findById(id).get();
	        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+a.getImage()));	
	    }  
	
	
}
