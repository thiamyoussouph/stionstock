package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import com.udemy.courudemy.Enum.EtatsCommande;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class CommandeClients extends Abstractentities {
    private String code;
    private Instant dateCommande;
    private long quantite;
    private String prixUnitaire;
    private String total;
    private String remise;
    private String tva;
    private String netAPayer;
    private String etat;
    private String dateLivraison;
    private String modePaiement;
    private String reference;
    private Instant dateCommandeClient;
    @Enumerated(EnumType.STRING)
    private EtatsCommande etatsCommande;
    private int identreprise;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commandeClients")
    private List<LigneCommandeclients> ligneCommandeClients;
}

