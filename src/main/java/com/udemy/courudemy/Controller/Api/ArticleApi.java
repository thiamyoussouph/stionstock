package com.udemy.courudemy.Controller.Api;


import com.udemy.courudemy.DTO.ArticleDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.DTO.LigneVenteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.udemy.courudemy.Controller.Api.utils.Constants.App_ROOT;

public interface ArticleApi {
    @PostMapping(value = App_ROOT+"/article/save", consumes = "application/json", produces = "application/json")
    ArticleDTO save(@RequestBody ArticleDTO dto);
    @GetMapping(value = App_ROOT+"/article/{id}", produces = "application/json")
    ArticleDTO findById(@PathVariable Integer id);
    @GetMapping(value = App_ROOT+"/article/{codeArticle}", produces = "application/json")
    ArticleDTO findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(value = App_ROOT+"/article/all", produces = "application/json")
    List<ArticleDTO> findAll();
    List<LigneVenteDTO>FindsHistoriqueVentes(Integer idArticle);
    List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Integer idArticle);
    List<LigneCommandeFourniseurDTO>fndHistoriqueCommandeFournisseur(Integer idArticle);
    List<ArticleDTO> findAllArticleByIdCategory(Integer idCategory);
    @DeleteMapping(value = App_ROOT+"/article/{id}")
    void delete(@PathVariable  Integer id);
}
