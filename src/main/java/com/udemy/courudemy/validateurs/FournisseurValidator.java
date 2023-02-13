package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.FourniseurDTO;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FourniseurDTO fournisseurDTO){
        List<String> errors = new ArrayList<>();
            if (fournisseurDTO ==null){
                errors.add("Veuillez renseigner le nom du fournisseur");
                errors.add("Veuillez renseigner l'adresse du fournisseur");
                errors.add("Veuillez renseigner le email du fournisseur");


                return errors;
            }
            if (fournisseurDTO.getNom() == null) {
                errors.add("Veuillez renseigner le nom du fournisseur");
            }
            if (fournisseurDTO.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse du fournisseur");
            }
            if (fournisseurDTO.getMail() == null) {
                errors.add("Veuillez renseigner le email du fournisseur");
            }

        return errors;
    }
}
