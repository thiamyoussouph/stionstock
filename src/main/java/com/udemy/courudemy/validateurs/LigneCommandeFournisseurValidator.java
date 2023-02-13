package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFourniseurDTO ligneCommandeFournisseurDTO){
        List<String> errors = new ArrayList<>();
        if(ligneCommandeFournisseurDTO == null){
            errors.add("Veuillez renseigner la quantité de la vente");
            errors.add("Veuillez renseigner le prix unitaire de la vente");
            errors.add("Veuillez renseigner le produit de la vente");
            return errors;
        }
        if (ligneCommandeFournisseurDTO.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la vente");
        }
        if (ligneCommandeFournisseurDTO.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la vente");
        }

        if (ligneCommandeFournisseurDTO.getArticle() == null) {
            errors.add("Veuillez renseigner le produit de la vente");
        }
        return errors;

    }

}
