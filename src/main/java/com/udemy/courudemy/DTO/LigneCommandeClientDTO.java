package com.udemy.courudemy.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.CommandeClients;
import com.udemy.courudemy.Enteties.LigneCommandeclients;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDTO {
    private long id;
    private ArticleDTO article;
int identreprise;
    private CommandeClientDTO commandeClients;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    @JsonIgnore
    private CommandeClientDTO commandeClient;

    public static LigneCommandeClientDTO fromEntity(LigneCommandeclients ligneCommandeclients){
        if(ligneCommandeclients==null){
            return null;
        }
        return LigneCommandeClientDTO.builder()
                .id(ligneCommandeclients.getId())
                .article(ArticleDTO.fromEntity(ligneCommandeclients.getArticle()))
                .commandeClients(CommandeClientDTO.fromEntity(ligneCommandeclients.getCommandeClients()))
                .quantite(ligneCommandeclients.getQuantite())
                .prixUnitaire(ligneCommandeclients.getPrixUnitaire())
                .identreprise(ligneCommandeclients.getIdentreprise())
                .build();
    }
    public static LigneCommandeclients toEntity(LigneCommandeClientDTO ligneCommandeClientDTO){
        if(ligneCommandeClientDTO==null){
            return null;
        }
        LigneCommandeclients ligneCommandeclients=new LigneCommandeclients();
        ligneCommandeclients.setId(ligneCommandeClientDTO.getId());
        ligneCommandeclients.setArticle(ArticleDTO.ToEntite(ligneCommandeClientDTO.getArticle()));
        ligneCommandeclients.setCommandeClients(CommandeClientDTO.ToEntite(ligneCommandeClientDTO.getCommandeClients()));
        ligneCommandeclients.setQuantite(ligneCommandeClientDTO.getQuantite());
        ligneCommandeclients.setPrixUnitaire(ligneCommandeClientDTO.getPrixUnitaire());
        ligneCommandeclients.setIdentreprise(ligneCommandeClientDTO.getIdentreprise());
        return ligneCommandeclients;
    }
}

