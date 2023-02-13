package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Commandefourniseur;
import com.udemy.courudemy.Enteties.Fournisseurs;
import com.udemy.courudemy.Enteties.LigneCommandefournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDTO {
    private long id;
    private FourniseurDTO fournisseurs;
 private Integer identreprise;
    private List<LigneCommandeFourniseurDTO> ligneCommandefournisseurs;
    public static CommandeFournisseurDTO fromEntity(Commandefourniseur commandeFournisseur){
        if(commandeFournisseur==null){
            return null;
        }
        return CommandeFournisseurDTO.builder()
                .id(commandeFournisseur.getId())
                .fournisseurs(FourniseurDTO.fromEntity(commandeFournisseur.getFournisseurs()))
                .identreprise(commandeFournisseur.getIdentreprise())
                .build();
    }
    public static Commandefourniseur toEntity(CommandeFournisseurDTO commandeFournisseurDTO){
        if(commandeFournisseurDTO==null){
            return null;
        }
        Commandefourniseur commandeFournisseur=new Commandefourniseur();
        commandeFournisseur.setId(commandeFournisseurDTO.getId());
        commandeFournisseur.setFournisseurs(FourniseurDTO.toEntity(commandeFournisseurDTO.getFournisseurs()));
        commandeFournisseur.setIdentreprise(commandeFournisseurDTO.getIdentreprise());
        return commandeFournisseur;
    }



}
