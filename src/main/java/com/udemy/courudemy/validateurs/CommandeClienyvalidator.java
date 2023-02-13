package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.CommandeClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClienyvalidator {
    public static List<String> validate(CommandeClientDTO commandeClientDTO){
        List<String> errors = new ArrayList<>();
        if(commandeClientDTO == null){
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add(" Veuillez renseigner la date de la commande du cliente");
            return errors;
        }
      if(StringUtils.hasLength(commandeClientDTO.getCode())){
          errors.add("Veuillez renseigner le code de la vente");
      }
    if (commandeClientDTO.getDateCommande() == null) {
                errors.add("Veuillez renseigner la date de la vente");
          }
              if (commandeClientDTO.getDateCommandeClient() == null) {
                 errors.add("Veuillez renseigner la date de la commande du client");
                }
          return errors;
}
}
