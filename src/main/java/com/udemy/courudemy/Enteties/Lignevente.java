package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lignevente extends Abstractentities {

    @ManyToOne
    private Ventes vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    @ManyToOne
    private Article article;
    private int identreprise;



}
