package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.CategoriDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CathegoryValidator {
    public static List<String> validate(CategoriDTO categoriDTO){
        List<String> errors = new ArrayList<>();
        if(categoriDTO == null){
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez renseigner le commentaire de la vente");
            errors.add("Veuillez renseigner l'identreprise de la vente");
            return errors;
        }
      if(StringUtils.hasLength(categoriDTO.getCode())){
          errors.add("Veuillez renseigner le code de la vente");
      }

        return errors;



}
}