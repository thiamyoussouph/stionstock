package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.ArticleDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.DTO.LigneVenteDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO save(ArticleDTO dto);
    ArticleDTO findById(Integer id);
    ArticleDTO findByCodeArticle(String codeArticle);
    List<ArticleDTO> findAll();
    List<LigneVenteDTO>FindsHistoriqueVentes(Integer idArticle);
    List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Integer idArticle);
    List<LigneCommandeFourniseurDTO>fndHistoriqueCommandeFournisseur(Integer idArticle);
    List<ArticleDTO> findAllArticleByIdCategory(Integer idCategory);
    void delete(Integer id);

}
