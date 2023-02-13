package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import com.udemy.courudemy.Enum.EtatsCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commandefourniseur  extends Abstractentities {
    private Instant dateCommande;
    private String code;
    @Enumerated(EnumType.STRING)
    private EtatsCommande etatsCommande;
    private int identreprise;
    @ManyToOne
    private Fournisseurs fournisseurs;
    @OneToMany(mappedBy = "commandefourniseur")
    private List<LigneCommandefournisseur> ligneCommandefournisseurs;

}



