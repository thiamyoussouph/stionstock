package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.ClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientsValiator {
    public static List<String> validate(ClientDTO clientsDTO){
        List<String> errors = new ArrayList<>();
        if(clientsDTO == null){
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez renseigner le commentaire de la vente");
            errors.add("Veuillez renseigner le numero de telephone du client");
            return errors;
        }
      if(StringUtils.hasLength(clientsDTO.getName())){
          errors.add("Veuillez renseigner le nom du client");
      }
   if (clientsDTO.getAdresse() == null) {
            errors.add("Veuillez renseigner l'adresse du client");
        }
           if (clientsDTO.getTel() == null) {
                errors.add("Veuillez renseigner le numéro de téléphone du client");
            }
        return errors;

    }
}
