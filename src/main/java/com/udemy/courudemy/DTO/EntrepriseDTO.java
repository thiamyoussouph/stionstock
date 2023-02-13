package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Adresse;
import com.udemy.courudemy.Enteties.Entreprises;
import com.udemy.courudemy.Enteties.Utilisateur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class EntrepriseDTO {
    private long id;
    private String nom;

    private AdresseDTO adresse;
    private String codeFiscal;
    private String photo;
    private String mail;
    private String numTel;
    private String description;

    private List<UtilisteurDTO> utilisateurs;
    public static EntrepriseDTO fromEntity(Entreprises entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .adresse(AdresseDTO.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .mail(entreprise.getMail())
                .numTel(entreprise.getNumTel())
                .description(entreprise.getDescription())
                .build();
    }
    public static Entreprises toEntity(EntrepriseDTO entrepriseDTO) {
        if (entrepriseDTO == null) {
            return null;
        }
        Entreprises entreprise = new Entreprises();
        entreprise.setId(entrepriseDTO.getId());
        entreprise.setNom(entrepriseDTO.getNom());
        entreprise.setAdresse(AdresseDTO.toEntity(entrepriseDTO.getAdresse()));
        entreprise.setCodeFiscal(entrepriseDTO.getCodeFiscal());
        entreprise.setPhoto(entrepriseDTO.getPhoto());
        entreprise.setMail(entrepriseDTO.getMail());
        entreprise.setNumTel(entrepriseDTO.getNumTel());
        entreprise.setDescription(entrepriseDTO.getDescription());
        return entreprise;
    }
}
