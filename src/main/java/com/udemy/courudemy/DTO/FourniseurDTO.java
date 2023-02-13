package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Commandefourniseur;
import com.udemy.courudemy.Enteties.Fournisseurs;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class FourniseurDTO {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String photo;
    private String mail;
    private String numTel;
    private int identreprise;

    private List<LigneCommandeFourniseurDTO> commandeFournisseurs;
    public static FourniseurDTO fromEntity(Fournisseurs fournisseurs){
        if(fournisseurs==null){
            return null;
        }
        return FourniseurDTO.builder()
                .id(fournisseurs.getId())
                .nom(fournisseurs.getNom())
                .prenom(fournisseurs.getPrenom())
                .adresse(fournisseurs.getAdresse())
                .photo(fournisseurs.getPhoto())
                .mail(fournisseurs.getMail())
                .numTel(fournisseurs.getNumTel())
                .identreprise(fournisseurs.getIdentreprise())
                .build();
    }
    public static Fournisseurs toEntity(FourniseurDTO fourniseurDTO){
        if(fourniseurDTO==null){
            return null;
        }
        Fournisseurs fournisseurs=new Fournisseurs();
        fournisseurs.setId(fourniseurDTO.getId());
        fournisseurs.setNom(fourniseurDTO.getNom());
        fournisseurs.setPrenom(fourniseurDTO.getPrenom());
        fournisseurs.setAdresse(fourniseurDTO.getAdresse());
        fournisseurs.setPhoto(fourniseurDTO.getPhoto());
        fournisseurs.setMail(fourniseurDTO.getMail());
        fournisseurs.setNumTel(fourniseurDTO.getNumTel());
        fournisseurs.setIdentreprise(fourniseurDTO.getIdentreprise());
        return fournisseurs;
    }
}
