package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Article  extends Abstractentities {
    private String code;
    private String designation;
    private  BigDecimal prixUnitaireHT;
    private BigDecimal tauxTva;
    private  BigDecimal prixUnitaireTTC;
    private  BigDecimal prixAchat;
    private  BigDecimal stock;
    private BigDecimal seuil;
    private String photo;
    private String description;
    private Integer idEntreprise;
    @ManyToOne
    private Categori categori;
@OneToMany(mappedBy = "article")
private List<Lignevente>  ligneventes;
    @OneToMany(mappedBy = "article")
    private List<LigneCommandeclients> ligneCommandeClients;
    @OneToMany(mappedBy = "article")
    private List<LigneCommandefournisseur> ligneCommandeFournisseurs;
    @OneToMany(mappedBy = "article")
    private List<Mouvementstock> mouvementStocks;

}
