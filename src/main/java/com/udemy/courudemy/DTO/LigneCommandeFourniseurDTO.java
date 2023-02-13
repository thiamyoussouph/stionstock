package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.Commandefourniseur;
import com.udemy.courudemy.Enteties.LigneCommandefournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFourniseurDTO {
    private long id;
    private ArticleDTO article;
private int identreprise;
    private CommandeFournisseurDTO commandefourniseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

    public static LigneCommandeFourniseurDTO fromEntity(LigneCommandefournisseur ligneCommandeFourniseurs){
        if(ligneCommandeFourniseurs==null){
            return null;
        }
        return LigneCommandeFourniseurDTO.builder()
                .id(ligneCommandeFourniseurs.getId())
                .article(ArticleDTO.fromEntity(ligneCommandeFourniseurs.getArticle()))
                .commandefourniseur(CommandeFournisseurDTO.fromEntity(ligneCommandeFourniseurs.getCommandefourniseur()))
                .quantite(ligneCommandeFourniseurs.getQuantite())
                .prixUnitaire(ligneCommandeFourniseurs.getPrixUnitaire())
                .identreprise(ligneCommandeFourniseurs.getIdentreprise())
                .build();
    }
    public static LigneCommandefournisseur toEntity(LigneCommandeFourniseurDTO ligneCommandeFourniseurDTO){
        if(ligneCommandeFourniseurDTO==null){
            return null;
        }
        LigneCommandefournisseur ligneCommandeFourniseurs=new LigneCommandefournisseur();
        ligneCommandeFourniseurs.setId(ligneCommandeFourniseurDTO.getId());
        ligneCommandeFourniseurs.setArticle(ArticleDTO.ToEntite(ligneCommandeFourniseurDTO.getArticle()));
        ligneCommandeFourniseurs.setCommandefourniseur(CommandeFournisseurDTO.toEntity(ligneCommandeFourniseurDTO.getCommandefourniseur()));
        ligneCommandeFourniseurs.setQuantite(ligneCommandeFourniseurDTO.getQuantite());
        ligneCommandeFourniseurs.setPrixUnitaire(ligneCommandeFourniseurDTO.getPrixUnitaire());
        ligneCommandeFourniseurs.setIdentreprise(ligneCommandeFourniseurDTO.getIdentreprise());
        return ligneCommandeFourniseurs;
    }
}
