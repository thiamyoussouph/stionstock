package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ventes extends Abstractentities {
    private String code;
   private Instant dateVente;
    private String commentaire;
    private int identreprise;
    @OneToMany(mappedBy = "vente")
    private List<Lignevente> ligneventes;
}

