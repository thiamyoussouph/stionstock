package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.ArticleDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.DTO.LigneVenteDTO;
import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Repository.ArticleRepository;
import com.udemy.courudemy.Service.ArticleService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.Articlevalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceimplementation implements ArticleService {
    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceimplementation(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public ArticleDTO save(ArticleDTO dto) {
        List<String> errors = Articlevalidator.validate(dto);
        if(!errors.isEmpty()){
          log.error("Article non valide {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", CodeEror.ARTICLE_NOT_FOUND.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDTO.fromEntity(
                articleRepository.save(
                        ArticleDTO.ToEntite(dto)
                )
        );
    }

    @Override
    public ArticleDTO findById(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        return Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(() -> new InvalidEntityException("Aucun article avec l'ID = " + id + "n'a ete trouve dans la BDD", CodeEror.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDTO findByCodeArticle(String codeArticle) {
        if(codeArticle == null){
            log.error("Article CODE is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);

        return  Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(() -> new InvalidEntityException("Aucun article avec le CODE = " + codeArticle + "n'a ete trouve dans la BDD", CodeEror.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDTO> findAll() {

        return articleRepository.findAll().stream().map(ArticleDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<LigneVenteDTO>FindsHistoriqueVentes(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Integer idArticle) {
        return null;
    }

    @Override
    public List<LigneCommandeFourniseurDTO>fndHistoriqueCommandeFournisseur(Integer idArticle) {
        return null;
    }

    @Override
    public List<ArticleDTO> findAllArticleByIdCategory(Integer idCategory) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);

    }
}

