package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.MouvementStockDTO;

import java.util.ArrayList;
import java.util.List;

public class MouvementStockvalidator {
    public static List<String> validate(MouvementStockDTO mouvementStockDTO){
        List<String> errors = new ArrayList<>();
        if(mouvementStockDTO == null){
            errors.add("Veuillez renseigner la quantité de la vente");
            errors.add("Veuillez renseigner le produit de la vente");
            return errors;
        }
        if (mouvementStockDTO.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la vente");
        }


        if (mouvementStockDTO.getArticle() == null) {
            errors.add("Veuillez renseigner le produit de la vente");
        }
        return errors;

    }

}
