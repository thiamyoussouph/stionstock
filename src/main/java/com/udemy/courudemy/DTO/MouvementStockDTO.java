package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.Mouvementstock;
import com.udemy.courudemy.Enum.TypeMouvement;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MouvementStockDTO {
    private long id;
    private ArticleDTO article;
    private Instant dateMouvement;
    private BigDecimal quantite;
    private TypeMouvement typeMouvement;
    private int identreprise;
    public static MouvementStockDTO fromEntity(Mouvementstock mouvementStock){
        if(mouvementStock==null){
            return null;
        }
        return MouvementStockDTO.builder()
                .id(mouvementStock.getId())
                .article(ArticleDTO.fromEntity(mouvementStock.getArticle()))
                .dateMouvement(mouvementStock.getDateMouvement())
                .quantite(mouvementStock.getQuantite())
                .typeMouvement(mouvementStock.getTypeMouvement())
                .identreprise(mouvementStock.getIdentreprise())
                .build();
    }
    public static Mouvementstock toEntity(MouvementStockDTO mouvementStockDTO){
        if(mouvementStockDTO==null){
            return null;
        }
        Mouvementstock  mouvementStock=new Mouvementstock ();
        mouvementStock.setId(mouvementStockDTO.getId());
        mouvementStock.setArticle(ArticleDTO.ToEntite(mouvementStockDTO.getArticle()));
        mouvementStock.setDateMouvement(mouvementStockDTO.getDateMouvement());
        mouvementStock.setQuantite(mouvementStockDTO.getQuantite());
        mouvementStock.setTypeMouvement(mouvementStockDTO.getTypeMouvement());
        mouvementStock.setIdentreprise(mouvementStockDTO.getIdentreprise());
        return mouvementStock;
    }
}
