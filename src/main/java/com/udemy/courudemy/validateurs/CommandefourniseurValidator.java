package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.CommandeFournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandefourniseurValidator {
    public static List<String> validate(CommandeFournisseurDTO commandeFournisseurDTO){
        List<String> errors = new ArrayList<>();
        if(commandeFournisseurDTO == null){
            errors.add("Veuillez renseigner l adresse du fournisseur");
            errors.add("Veuillez renseigner l entreprise du fournisseur");
            errors.add(" Veuillez renseigner la date de la commande du fournisseur");
            return errors;
        }
      if(StringUtils.hasLength(commandeFournisseurDTO.getFournisseurs().getAdresse())){
          errors.add("Veuillez renseigner l adresse du fournisseur");
      }
    if (commandeFournisseurDTO.getIdentreprise() == null) {
                errors.add("Veuillez renseigner l entreprise");
          }
              if (commandeFournisseurDTO.getFournisseurs() == null) {
                 errors.add("Veuillez renseigner le fournisseur");
                }
          return errors;
}
}
