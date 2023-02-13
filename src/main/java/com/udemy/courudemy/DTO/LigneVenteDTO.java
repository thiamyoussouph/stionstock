package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Lignevente;
import com.udemy.courudemy.Enteties.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDTO {
    private long id;
    private VenteDTO vente;
    private ArticleDTO article;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private int identreprise;
       public static LigneVenteDTO fromEntity(Lignevente lignevente){
        if(lignevente==null){
            return null;
        }
        return LigneVenteDTO.builder()
                .id(lignevente.getId())
                .vente(VenteDTO.fromEntity(lignevente.getVente()))
                .article(ArticleDTO.fromEntity(lignevente.getArticle()))
                .quantite(lignevente.getQuantite())
                .prixUnitaire(lignevente.getPrixUnitaire())
                .identreprise(lignevente.getIdentreprise())
                .build();
       }
         public static Lignevente toEntity(LigneVenteDTO ligneVenteDTO){
          if(ligneVenteDTO==null){
                return null;
          }
          Lignevente lignevente=new Lignevente();
          lignevente.setId(ligneVenteDTO.getId());
          lignevente.setVente(VenteDTO.ToEntite(ligneVenteDTO.getVente()));
          lignevente.setArticle(ArticleDTO.ToEntite(ligneVenteDTO.getArticle()));
          lignevente.setQuantite(ligneVenteDTO.getQuantite());
          lignevente.setPrixUnitaire(ligneVenteDTO.getPrixUnitaire());
          lignevente.setIdentreprise(ligneVenteDTO.getIdentreprise());
          return lignevente;
         }


}
