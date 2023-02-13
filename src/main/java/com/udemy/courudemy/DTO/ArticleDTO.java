package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Article;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class ArticleDTO {
    private long id;
    private String code;
    private String designation;
    private BigDecimal prixUnitaireHT;
    private  BigDecimal tauxTva;
    private  BigDecimal prixUnitaireTTC;
    private  BigDecimal prixAchat;
    private  BigDecimal stock;
    private  BigDecimal seuil;
    private String photo;
    private String description;
    private Integer idEntreprise;
    private CategoriDTO categori;
    public static ArticleDTO fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCode())
                .designation(article.getDesignation())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTTC(article.getPrixUnitaireTTC())
                .prixAchat(article.getPrixAchat())
                .stock(article.getStock())
                .seuil(article.getSeuil())
                .photo(article.getPhoto())
                .description(article.getDescription())
                .idEntreprise(article.getIdEntreprise())
                .categori(CategoriDTO.fromEntity(article.getCategori()))

                .build();
    }
    public static Article ToEntite( ArticleDTO articleDTO){
        if(articleDTO==null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setCode(articleDTO.getCode());
        article.setDesignation(articleDTO.getDesignation());
        article.setPrixUnitaireHT(articleDTO.getPrixUnitaireHT());
        article.setTauxTva(articleDTO.getTauxTva());
        article.setPrixUnitaireTTC(articleDTO.getPrixUnitaireTTC());
        article.setPrixAchat(articleDTO.getPrixAchat());
        article.setStock(articleDTO.getStock());
        article.setSeuil(articleDTO.getSeuil());
        article.setPhoto(articleDTO.getPhoto());
        article.setDescription(articleDTO.getDescription());
        article.setIdEntreprise(articleDTO.getIdEntreprise());
        article.setCategori(CategoriDTO.ToEntite(articleDTO.getCategori()));
        return article;
    }
}
