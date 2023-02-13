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
public class LigneCommandefournisseur extends Abstractentities {
    @ManyToOne
    private Article article;
    @ManyToOne
    private Commandefourniseur commandefourniseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer identreprise;
}

