package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.ArticleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Articlevalidator {
    public static List<String> validate(ArticleDTO articleDTO){
        List<String> errors = new ArrayList<>();
        if(articleDTO == null){
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez renseigner le commentaire de la vente");
            errors.add("Veuillez renseigner l'identreprise de la vente");
            return errors;
        }
      if(StringUtils.hasLength(articleDTO.getCode())){
          errors.add("Veuillez renseigner le code de la vente");
      }
   if (articleDTO.getPrixUnitaireHT() == null) {
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
        }
           if (articleDTO.getTauxTva() == null) {
                errors.add("Veuillez renseigner le taux de TVA de l'article");
            }
        return errors;

    }
}
