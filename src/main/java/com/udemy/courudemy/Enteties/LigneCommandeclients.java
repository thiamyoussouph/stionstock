package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneCommandeclients extends Abstractentities {

    @ManyToOne
    private Article article;
    @ManyToOne
   private CommandeClients commandeClients;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private int identreprise;


}

