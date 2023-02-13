package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public class Rolevalidator {
    public static List<String> validate(RoleDTO roleDTO){
        List<String> errors = new ArrayList<>();
        if(roleDTO == null){
            errors.add("Veuillez renseigner le nom du role");
            return errors;
        }
        if (roleDTO.getRoleName() == null) {
            errors.add("Veuillez renseigner le nom du role");
        }
        return errors;

    }
}

