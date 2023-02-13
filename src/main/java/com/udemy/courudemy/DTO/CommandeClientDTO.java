package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Client;
import com.udemy.courudemy.Enteties.CommandeClients;
import com.udemy.courudemy.Enteties.LigneCommandeclients;
import com.udemy.courudemy.Enum.EtatsCommande;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDTO {
    private long id;
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
    private EtatsCommande etatsCommande;
    private int identreprise;

    private ClientDTO client;

    private List<LigneCommandeClientDTO> ligneCommandeClients;
    public static CommandeClientDTO fromEntity(CommandeClients commandeClient){
        if(commandeClient==null){
            return null;
        }
        return CommandeClientDTO.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .quantite(commandeClient.getQuantite())
                .prixUnitaire(commandeClient.getPrixUnitaire())
                .total(commandeClient.getTotal())
                .remise(commandeClient.getRemise())
                .tva(commandeClient.getTva())
                .netAPayer(commandeClient.getNetAPayer())
                .etat(commandeClient.getEtat())
                .dateLivraison(commandeClient.getDateLivraison())
                .modePaiement(commandeClient.getModePaiement())
                .reference(commandeClient.getReference())
                .dateCommandeClient(commandeClient.getDateCommandeClient())
                .client(ClientDTO.fromEntity(commandeClient.getClient()))
                .etatsCommande(commandeClient.getEtatsCommande())
                .identreprise(commandeClient.getIdentreprise())
                .build();
    }
    public static CommandeClients ToEntite(CommandeClientDTO commandeClientDTO){
        if(commandeClientDTO==null){
            return null;
        }
        CommandeClients commandeClient=new CommandeClients();
        commandeClient.setId(commandeClientDTO.getId());
        commandeClient.setCode(commandeClientDTO.getCode());
        commandeClient.setDateCommande(commandeClientDTO.getDateCommande());
        commandeClient.setQuantite(commandeClientDTO.getQuantite());
        commandeClient.setPrixUnitaire(commandeClientDTO.getPrixUnitaire());
        commandeClient.setTotal(commandeClientDTO.getTotal());
        commandeClient.setRemise(commandeClientDTO.getRemise());
        commandeClient.setTva(commandeClientDTO.getTva());
        commandeClient.setNetAPayer(commandeClientDTO.getNetAPayer());
        commandeClient.setEtat(commandeClientDTO.getEtat());
        commandeClient.setDateLivraison(commandeClientDTO.getDateLivraison());
        commandeClient.setModePaiement(commandeClientDTO.getModePaiement());
        commandeClient.setReference(commandeClientDTO.getReference());
        commandeClient.setDateCommandeClient(commandeClientDTO.getDateCommandeClient());
        commandeClient.setClient(ClientDTO.toEntity(commandeClientDTO.getClient()));
        commandeClient.setEtatsCommande(commandeClientDTO.getEtatsCommande());
        commandeClient.setIdentreprise(commandeClientDTO.getIdentreprise());

        return commandeClient;
    }
}
