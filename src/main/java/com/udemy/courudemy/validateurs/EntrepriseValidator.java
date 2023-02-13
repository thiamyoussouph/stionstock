package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.CommandeFournisseurDTO;
import com.udemy.courudemy.DTO.EntrepriseDTO;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDTO entrepriseDTO){
        List<String> errors = new ArrayList<>();
            if (entrepriseDTO ==null){
                errors.add("Veuillez renseigner le nom de l'entreprise");
                errors.add("Veuillez renseigner l'adresse de l'entreprise");
                errors.add("Veuillez renseigner le code fiscal de l'entreprise");
                errors.add("Veuillez renseigner le code fiscal de l'entreprise");

                return errors;
            }
            if (entrepriseDTO.getNom() == null) {
                errors.add("Veuillez renseigner le nom de l'entreprise");
            }
            if (entrepriseDTO.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse de l'entreprise");
            }
            if (entrepriseDTO.getCodeFiscal() == null) {
                errors.add("Veuillez renseigner le code fiscal de l'entreprise");
            }
            if (entrepriseDTO.getMail() == null) {
                errors.add("Veuillez renseigner le email de l'entreprise");
            }

        return errors;
    }
}
