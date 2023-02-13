package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.LigneCommandeClientDTO;

import java.util.ArrayList;
import java.util.List;

public class LigneCommendeCliensValidator {
    public static List<String> validate(LigneCommandeClientDTO ligneCommandeClientDTO){
        List<String> errors = new ArrayList<>();
        if(ligneCommandeClientDTO == null){
            errors.add("Veuillez renseigner la quantité de la vente");
            errors.add("Veuillez renseigner le prix unitaire de la vente");
            errors.add("Veuillez renseigner le produit de la vente");
            return errors;
        }
        if (ligneCommandeClientDTO.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la vente");
        }
        if (ligneCommandeClientDTO.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la vente");
        }

        if (ligneCommandeClientDTO.getArticle() == null) {
            errors.add("Veuillez renseigner le produit de la vente");
        }
        return errors;


    }
}
