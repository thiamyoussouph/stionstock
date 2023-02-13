package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {
    private long id;
    private String adress1;
    private String adress2;
    private String ville;
    private String rue;
    private String codePostal;
    private String pays;
    public  static AdresseDTO fromEntity(Adresse adresse){
        if(adresse==null){
            return null;
        }
        return AdresseDTO.builder()

                .adress1(adresse.getAdress1())
                .adress2(adresse.getAdress2())
                .ville(adresse.getVille())
                .rue(adresse.getRue())
                .codePostal(adresse.getCodePostal())
                .pays(adresse.getPays())
                .build();
    }
    public static Adresse toEntity( AdresseDTO adresseDTO){
        if (adresseDTO==null){
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdress1(adresseDTO.getAdress1());
        adresse.setAdress2(adresseDTO.getAdress2());
        adresse.setVille(adresseDTO.getVille());
        adresse.setRue(adresseDTO.getRue());
        adresse.setCodePostal(adresseDTO.getCodePostal());
        adresse.setPays(adresseDTO.getPays());
        return adresse;
    }
}
