package com.udemy.courudemy.Controller.Api;

import com.udemy.courudemy.DTO.ArticleDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.DTO.LigneVenteDTO;
import com.udemy.courudemy.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArticleController implements ArticleApi {
    @Autowired
    private ArticleService articleService;
    @Autowired
    public ArticleService getArticleService(){
        return articleService;
    }
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @Override
    public ArticleDTO save(ArticleDTO dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDTO findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDTO findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    @Override
    public List<LigneVenteDTO> FindsHistoriqueVentes(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeFourniseurDTO> fndHistoriqueCommandeFournisseur(Integer idArticle) {
        return null;
    }

    @Override
    public List<ArticleDTO> findAllArticleByIdCategory(Integer idCategory) {
        return null;
    }

    @Override
    public void delete(Integer id) {
          articleService.delete(id);
    }
}

