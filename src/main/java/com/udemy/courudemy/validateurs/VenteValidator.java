package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.VenteDTO;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {
    public static List<String> validate(VenteDTO venteDTO){
        List<String> errors = new ArrayList<>();
        if(venteDTO == null){
            errors.add("Veuillez renseigner la date de la vente");

            return errors;
        }
        if (venteDTO.getDateVente() == null) {
            errors.add("Veuillez renseigner la date de la vente");
        }


        return errors;
}
}
